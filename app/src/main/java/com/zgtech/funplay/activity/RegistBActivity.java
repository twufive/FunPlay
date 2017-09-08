package com.zgtech.funplay.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.global.GlideImageLoader;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.UpImgsModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.retrofit.RetrofitParameterBuilder;
import com.zgtech.funplay.utils.T;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import me.shaohui.advancedluban.Luban;
import me.shaohui.advancedluban.OnMultiCompressListener;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 注册第二页面
 * Created by Administrator on 2017/8/9.
 */

public class RegistBActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @Bind(R.id.et_nick)
    EditText etNick;
    @Bind(R.id.et_wx_user)
    EditText etWxUser;
    @Bind(R.id.et_vocation)
    EditText etVocation;
    @Bind(R.id.btn_next)
    Button btnNext;

    private IHandlerCallBack iHandlerCallBack;
    private static final int REQUEST_CODE = 100;
    private static final String TAG = "Gallery";
    private GalleryConfig galleryConfig;
    private List<String> path = new ArrayList<>();//照片存放路径
    private ProgressDialog dialog;
    private ArrayList<String> originPhotoList = new ArrayList<>();

    private String userIcon = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_b);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("个人资料");

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.iv_avatar, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.iv_avatar:
                monitorGalleryPick();
                initGalleryConfig();
                initPermissions();
                break;
            case R.id.btn_next:
                doModify();
                break;
        }
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
                originPhotoList.addAll(photoList);

                dialog = new ProgressDialog(RegistBActivity.this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                dialog.setMessage("正在上传...");
                dialog.show();
                readyUpImgsToServer(originPhotoList);
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

    private void initGalleryConfig() {
        int existSize = originPhotoList.size();
        int maxSize = 9 - existSize;
        //开启相册
        galleryConfig = new GalleryConfig.Builder()
                .imageLoader(new GlideImageLoader())    // ImageLoader 加载框架（必填）
                .iHandlerCallBack(iHandlerCallBack)     // 监听接口（必填）
                .provider("com.zgtech.funplay.fileprovider")   // provider (必填)
                .pathList(path)
                .multiSelect(false)                      // 是否多选   默认：false
//                .multiSelect(true, maxSize)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .maxSize(1)                             // 配置多选时 的多选数量。    默认：9
                .crop(false)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .crop(false, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(false)                     // 是否现实相机按钮  默认：false
                .filePath("/Gallery")// 图片存放路径
                .build();
    }

    // 授权管理
    private void initPermissions() {
        if (ContextCompat.checkSelfPermission(RegistBActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(RegistBActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i(TAG, "拒绝过了");
                Toast.makeText(RegistBActivity.this, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(RegistBActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
            }
        } else {
            Log.i(TAG, "不需要授权 ");
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(RegistBActivity.this);
        }
    }

    private void readyUpImgsToServer(ArrayList<String> originPhotoList) {
        final RetrofitParameterBuilder retrofitParameterBuilder = RetrofitParameterBuilder.newBuilder();

        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < originPhotoList.size(); i++) {
            File file = new File(originPhotoList.get(i));
            fileList.add(file);
        }

        Luban.compress(RegistBActivity.this, fileList)
                .setMaxSize(500)                // 限制最终图片大小（单位：Kb）
                .setMaxHeight(1920)             // 限制图片高度
                .setMaxWidth(1080)              // 限制图片宽度
                .putGear(Luban.CUSTOM_GEAR)
                .launch(new OnMultiCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(List<File> fileList) {
                        for (int i = 0; i < fileList.size(); i++) {
                            retrofitParameterBuilder.addParameter("imgFiles", fileList.get(i));
                        }

                        retrofitParameterBuilder.addParameter("id", "");
                        Map<String, RequestBody> map = retrofitParameterBuilder.bulider();
                        doUp(retrofitParameterBuilder, map);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    private void doUp(final RetrofitParameterBuilder retrofitParameterBuilder, Map<String, RequestBody> map) {
        mApiStores.upImgs(map).enqueue(new Callback<UpImgsModel>() {
            @Override
            public void onResponse(Call<UpImgsModel> call, Response<UpImgsModel> response) {
                if (response.isSuccessful()) {
                    ifSuccess(response);
                } else {
                    T.showShort("请检查您的网络链接");
                }
            }

            private void ifSuccess(Response<UpImgsModel> response) {
                if (response.body().getCode() == 2) {
                    List<String> urlList = response.body().getList();
                    userIcon = urlList.get(0);

                    retrofitParameterBuilder.cleanParams();

                    Glide.with(RegistBActivity.this)
                            .load(ApiStores.API_SERVER_URL+userIcon)
                            .into(ivAvatar);

                    dialog.dismiss();
                } else {
                    T.showShort(response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<UpImgsModel> call, Throwable t) {

            }
        });
    }

    private void doModify() {
        String nick = etNick.getText().toString();
        String wxUser = etWxUser.getText().toString();
        String vocation = etVocation.getText().toString();

        if (TextUtils.isEmpty(nick)) {
            T.showShort("请填写您的昵称");
        } else if (TextUtils.isEmpty(wxUser)) {
            T.showShort("请填写您的微信账号");
        } else if (TextUtils.isEmpty(vocation)) {
            T.showShort("请填写您的职业");
        } else {

            HashMap map = new HashMap();
            map.put("userRegisterProgress", "0");
            map.put("userIcon", userIcon);
            map.put("userNick", nick);
            map.put("userVocation", vocation);
            RequestBody body = RequestBodyBuilder.build(map);

            mApiStores.modifyPersonal(body).enqueue(new Callback<BaseResultModel>() {
                @Override
                public void onResponse(Call<BaseResultModel> call, Response<BaseResultModel> response) {
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

                private void handleServerData(BaseResultModel model) {
                    toNextActivity(RegistCActivity.class);
                }

                @Override
                public void onFailure(Call<BaseResultModel> call, Throwable t) {
                    T.showShort(t.toString());
                }
            });
        }
    }

}
