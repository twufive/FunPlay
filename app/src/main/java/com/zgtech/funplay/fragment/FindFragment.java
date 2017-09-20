package com.zgtech.funplay.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ajguan.library.EasyRefreshLayout;
import com.google.gson.Gson;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.modulec.FriendTalkPushActivity;
import com.zgtech.funplay.adapter.FindAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.global.GlideImageLoader;
import com.zgtech.funplay.model.FriendTalkData;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.SPUtils;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zgtech.funplay.FunPlayApplication.mContext;

/**
 * 旅游圈模块
 * Created by Administrator on 2017/8/1.
 */

public class FindFragment extends BaseFragment {
    @Bind(R.id.iv_right)
    ImageView ivRight;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    @Bind(R.id.easyrefreshlayout)
    EasyRefreshLayout easyRefreshLayout;

    private static String TAG = "FindFragment";
    private static final int REQUEST_CODE = 100;
    private IHandlerCallBack iHandlerCallBack;
    private GalleryConfig galleryConfig;
    private ArrayList<String> path = new ArrayList<>();//照片存放路径

    private List<FriendTalkData.ListBean> originList = new ArrayList<>();
    private List<FriendTalkData.ListBean> loadMoreList = new ArrayList<>();
    private FindAdapter findAdapter;


    private int lastSpaceId = 0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find_second, container, false);
        ButterKnife.bind(this, view);


        initView(view, savedInstanceState);
        initData();

        initRefreshLoadMore();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.i("FindFragment", "onDestroy");
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initStausBar();
    }

    private void initFriendTalks(List<FriendTalkData.ListBean> originList) {
        findAdapter = new FindAdapter(getActivity(), R.layout.fp_item_social_main, originList);
        recyclerview.setLayoutManager(new LinearLayoutManager(FunPlayApplication.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerview.setAdapter(findAdapter);
    }

    private void initStausBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void initData() {
        mApiStores.getFriendTalkData("0", "false").enqueue(new Callback<FriendTalkData>() {
            @Override
            public void onResponse(Call<FriendTalkData> call, Response<FriendTalkData> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode() == 2) {
                        handleServerData(response.body());
                    } else {
                        T.showShort(response.body().getMsg());
                    }
                } else {
                    T.showShort(response.toString());
                }
            }

            private void handleServerData(FriendTalkData model) {
                originList = model.getList();
                lastSpaceId = originList.get(originList.size() - 1).getSpaceId();
                initFriendTalks(originList);
            }

            @Override
            public void onFailure(Call<FriendTalkData> call, Throwable t) {
                T.showShort(t.toString());
            }
        });

    }


    private void initRefreshLoadMore() {
        easyRefreshLayout.addEasyEvent(new EasyRefreshLayout.EasyEvent() {
            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadMoreData();
                    }
                }, 1000);

            }

            @Override
            public void onRefreshing() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        refreshData();
                    }
                }, 1000);

            }
        });
    }

    private void refreshData() {
        mApiStores.getFriendTalkData("0", "false").enqueue(new Callback<FriendTalkData>() {
            @Override
            public void onResponse(Call<FriendTalkData> call, Response<FriendTalkData> response) {
                if (response.isSuccessful()) {
                    ifSuccess(response);
                } else {
                    T.showShort(response.message());
                }
            }

            public void ifSuccess(Response<FriendTalkData> response) {
                if (response.body().getCode() == 2) {

                    if (response.body().getList() != null && response.body().getList().size() != 0) {
                        List<FriendTalkData.ListBean> refreshList = response.body().getList();
                        originList.clear();
                        originList.addAll(refreshList);

                        int size = originList.size();
                        lastSpaceId = originList.get(size - 1).getSpaceId();

                        findAdapter.setNewData(originList);
                        if (easyRefreshLayout != null) {
                            easyRefreshLayout.refreshComplete();
                        }

                        Gson gson = new Gson();
                        String toJson = gson.toJson(response.body());
                        Context context = FunPlayApplication.getContext();
                        SPUtils.setString(context, "YouQuanCache", toJson);
                    } else {
                        if (easyRefreshLayout != null) {
                            easyRefreshLayout.refreshComplete();
                        }
                    }
                } else {
                    Context context = FunPlayApplication.getContext();
                    T.showShort(context, response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<FriendTalkData> call, Throwable t) {

            }
        });
    }

    private void loadMoreData() {
        mApiStores.getFriendTalkData(lastSpaceId + "", "true").enqueue(new Callback<FriendTalkData>() {
            @Override
            public void onResponse(Call<FriendTalkData> call, Response<FriendTalkData> response) {
                if (response.isSuccessful()) {
                    ifSuccess(response);
                } else {
                    T.showShort(response.message());
                }
            }

            public void ifSuccess(Response<FriendTalkData> response) {
                if (response.body().getCode() == 2) {
                    if (response.body().getList() != null && response.body().getList().size() != 0) {
                        loadMoreList.clear();
                        loadMoreList = response.body().getList();
                        int size = loadMoreList.size();
                        lastSpaceId = loadMoreList.get(size - 1).getSpaceId();
                        originList.addAll(loadMoreList);
                        findAdapter.setNewData(originList);
                        if (easyRefreshLayout != null) {
                            easyRefreshLayout.loadMoreComplete(new EasyRefreshLayout.Event() {
                                @Override
                                public void complete() {
                                    findAdapter.notifyDataSetChanged();
                                }
                            }, 1000);
                        }
                    } else {
                        if (easyRefreshLayout != null) {
                            easyRefreshLayout.loadMoreComplete();
                        }

                    }

                } else {
                    Context context = FunPlayApplication.getContext();
                    T.showShort(context, response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<FriendTalkData> call, Throwable t) {

            }
        });
    }


    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @OnClick(R.id.iv_right)
    public void onViewClicked() {
        showPhotoDialog();
    }

    private void showPhotoDialog() {
        final AlertDialog dlg = new AlertDialog.Builder(getActivity()).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.fx_dialog_social_main);
        TextView tv_paizhao = (TextView) window.findViewById(R.id.tv_content1);
        tv_paizhao.setText("拍照");
        tv_paizhao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monitorGalleryPick();
                initGalleryConfig(true);
                initPermissions(true);
                dlg.cancel();
            }
        });
        TextView tv_xiangce = (TextView) window.findViewById(R.id.tv_content2);
        tv_xiangce.setText("相册");
        tv_xiangce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                monitorGalleryPick();
                initGalleryConfig(false);
                initPermissions(false);
                dlg.cancel();
            }
        });

    }

    private void monitorGalleryPick() {
        iHandlerCallBack = new IHandlerCallBack() {
            @Override
            public void onStart() {
                Log.i("haha", "onStart: 开启");
            }

            @Override
            public void onSuccess(List<String> photoList) {
                Log.i("haha", "onSuccess: 返回数据");

                /**通向MomentsPublishActivity*/
                Intent intent = new Intent(getActivity(), FriendTalkPushActivity.class);
                intent.putStringArrayListExtra("photoList", (ArrayList<String>) photoList);
                startActivity(intent);
//                getActivity().finish();
            }

            @Override
            public void onCancel() {
                Log.i("haha", "onCancel: 取消");
            }

            @Override
            public void onFinish() {
                Log.i("haha", "onFinish: 结束");
            }

            @Override
            public void onError() {
                Log.i("haha", "onError: 出错");
            }
        };
    }

    private void initGalleryConfig(boolean isTakePhoto) {
        if (isTakePhoto) {
            //直接拍照
            galleryConfig = new GalleryConfig.Builder()
                    .imageLoader(new GlideImageLoader())
                    .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                    .provider("com.zgtech.funplay.fileprovider")
                    .filePath("/Gallery/Pictures")          // 图片存放路径   （选填）
                    .isOpenCamera(true)                  // 直接开启相机的标识位
                    .build();
        } else {
            //开启相册
            galleryConfig = new GalleryConfig.Builder()
                    .imageLoader(new GlideImageLoader())    // ImageLoader 加载框架（必填）
                    .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                    .provider("com.zgtech.funplay.fileprovider")   // provider (必填)
                    .pathList(path)
                    .multiSelect(true)                      // 是否多选   默认：false
                    .multiSelect(true, 9)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                    .maxSize(9)                             // 配置多选时 的多选数量。    默认：9
                    .crop(false)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                    .crop(false, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                    .isShowCamera(false)                     // 是否现实相机按钮  默认：false
                    .filePath("/Gallery")// 图片存放路径
                    .build();
        }

    }


    // 授权管理
    private void initPermissions(boolean isCamera) {
        if (isCamera) {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "需要授权 ");
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.CAMERA)) {
                    Log.i(TAG, "拒绝过了");
                    Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的拍照授权。", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i(TAG, "进行授权");
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
                }
            } else {
                Log.i(TAG, "不需要授权 ");
                GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(getActivity());
            }
        } else {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                Log.i(TAG, "需要授权 ");
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Log.i(TAG, "拒绝过了");
                    Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
                } else {
                    Log.i(TAG, "进行授权");
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
                }
            } else {
                Log.i(TAG, "不需要授权 ");
                GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(getActivity());
            }
        }
    }
}
