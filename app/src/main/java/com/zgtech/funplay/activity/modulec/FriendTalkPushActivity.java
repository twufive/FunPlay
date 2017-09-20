package com.zgtech.funplay.activity.modulec;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyItemDialogListener;
import com.yancy.gallerypick.config.GalleryConfig;
import com.yancy.gallerypick.config.GalleryPick;
import com.yancy.gallerypick.inter.IHandlerCallBack;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.MainActivity;
import com.zgtech.funplay.activity.PhotoViewActivity;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.global.GlideImageLoader;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.SpaceOrderModel;
import com.zgtech.funplay.model.UpImgsModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.retrofit.RetrofitParameterBuilder;
import com.zgtech.funplay.utils.SPUtils;
import com.zgtech.funplay.utils.T;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.shaohui.advancedluban.Luban;
import me.shaohui.advancedluban.OnMultiCompressListener;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 发布旅游圈页面
 * Created by Administrator on 2017/8/1.
 */
public class FriendTalkPushActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_right)
    ImageView ivRight;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.et_content)
    EditText etContent;
    @Bind(R.id.gridview)
    GridView gridview;
    @Bind(R.id.iv_add_order)
    ImageView ivAddOrder;
    @Bind(R.id.tv_order_description)
    TextView tvOrderDescription;

    private IHandlerCallBack iHandlerCallBack;
    private static final int REQUEST_CODE = 100;
    private static final String TAG = "Gallery";
    private GalleryConfig galleryConfig;
    private List<String> path = new ArrayList<>();//照片存放路径
    private ProgressDialog dialog;
    private ArrayList<String> originPhotoList = new ArrayList<>();

    private ImageAdapter imageAdapter;
    private String exclusiveId;
    private String talkContent;
    private HashMap<Object, Object> originMap = new HashMap<>();

    private String orderByChoosed;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fx_activity_publish_moments);
        ButterKnife.bind(this);
        originPhotoList = getIntent().getStringArrayListExtra("photoList");
        initView();

        exclusiveId = SPUtils.getString(this, "exclusiveId", "");
    }

    public void initView() {
        tvToolbar.setText("发布动态");
        llBack.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
        tvRight.setText("完成");
        initGridView();
    }

    @Override
    public void initData() {

    }

    private void initGridView() {
        imageAdapter = new ImageAdapter(FriendTalkPushActivity.this, originPhotoList);
        gridview.setAdapter(imageAdapter);
        gridview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (originPhotoList.size() < 9 && position == originPhotoList.size()) {
                    addPhotoToGridView();
                } else {
                    showBigPicOrDeleteDialog(position);
                }
            }

        });
    }


    @OnClick({R.id.ll_back, R.id.tv_right, R.id.iv_add_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
//                finish();
                Intent intent = new Intent(FriendTalkPushActivity.this, MainActivity.class);
                intent.putExtra("whichFragment", "4");
                startActivity(intent);
                finish();
                break;
            case R.id.tv_right:
                talkContent = etContent.getText().toString().trim();
                if (TextUtils.isEmpty(talkContent)) {
                    T.showShort(this, "请输入文字内容....");
                } else {
                    dialog = new ProgressDialog(this);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setMessage("正在发布...");
                    dialog.show();
                    upImgsToServer(originPhotoList);
                }
                break;
            case R.id.iv_add_order:
                showMyOrderListDialog();
                break;
        }
    }

    private void showMyOrderListDialog() {
        mApiStores.getSpaceOrdersData().enqueue(new Callback<SpaceOrderModel>() {
            @Override
            public void onResponse(Call<SpaceOrderModel> call, Response<SpaceOrderModel> response) {
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

            private void handleServerData(SpaceOrderModel model) {
                if (model.getObj().size() == 0 || model.getObj() == null) {
                    T.showShort("您暂时还未发布任何订单噢");
                } else {
                    List<SpaceOrderModel.ObjBean> myOrderList = model.getObj();

                    List<String> strOrderList = new ArrayList<>();
                    for (int i = 0; i < myOrderList.size(); i++) {
                        SpaceOrderModel.ObjBean individualModel = myOrderList.get(i);
                        String orderTitle = individualModel.getOrderTitle();
                        int orderSize = individualModel.getOrderSize();
                        int orderPirce1 = individualModel.getOrderPirce1();

                        strOrderList.add(orderTitle + ";" + orderSize + "人团," + "价格:" + orderPirce1);
                    }

                    StyledDialog.buildIosSingleChoose(strOrderList, new MyItemDialogListener() {
                        @Override
                        public void onItemClick(CharSequence charSequence, int i) {
                            ivAddOrder.setVisibility(View.GONE);
                            tvOrderDescription.setVisibility(View.VISIBLE);

                            tvOrderDescription.setText(charSequence);

                            orderByChoosed = String.valueOf(charSequence);
                        }
                    }).show();
                }
            }

            @Override
            public void onFailure(Call<SpaceOrderModel> call, Throwable t) {

            }
        });
    }

    // 发布说说
    private void sendTalk(String talkContent, List<String> urlList) {
        originMap = new HashMap<>();
        originMap.put("spaceContent", talkContent);
        originMap.put("spaceContentMin", talkContent);
        originMap.put("spacePictrueCount", urlList.size());
        originMap.put("orderId", "1");
        originMap.put("orderTitle", orderByChoosed);
        originMap.put("orderPrice1", "1");
        originMap.put("orderSize", "1");
        addMapParam(urlList);
        RequestBody body = RequestBodyBuilder.build(originMap);


        mApiStores.pushTalk(body).enqueue(new Callback<BaseResultModel>() {
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
                dialog.dismiss();

                SPUtils.setString(FriendTalkPushActivity.this, "YouQuanCache", "");

                Intent intent = new Intent(FriendTalkPushActivity.this, MainActivity.class);
                intent.putExtra("whichFragment", 3);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    private void addMapParam(List<String> urlList) {
        for (int i = 0; i < urlList.size(); i++) {
            int temp = i + 1;
            originMap.put("spacePicture" + temp, urlList.get(i));
        }
    }

    private void upImgsToServer(ArrayList<String> originPhotoList) {
        final RetrofitParameterBuilder retrofitParameterBuilder = RetrofitParameterBuilder.newBuilder();

        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < originPhotoList.size(); i++) {
            File file = new File(originPhotoList.get(i));
            fileList.add(file);
        }

        Luban.compress(FriendTalkPushActivity.this, fileList)
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

                        retrofitParameterBuilder.addParameter("id", exclusiveId);
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


//                    String talkPicture = "";
//                    for (int i = 0; i < urlList.size(); i++) {
//                        talkPicture = talkPicture + urlList.get(i) + ",";
//                    }
//
//                    String talkPictureSub = talkPicture.substring(0, talkPicture.length() - 1);

                    sendTalk(talkContent, urlList);

                    retrofitParameterBuilder.cleanParams();
                } else {
                    T.showShort(FriendTalkPushActivity.this, response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<UpImgsModel> call, Throwable t) {

            }
        });
    }

    @OnClick(R.id.iv_add_order)
    public void onViewClicked() {

    }

    class ImageAdapter extends BaseAdapter {
        LayoutInflater inflater;
        Context context;
        ArrayList<String> list;

        public ImageAdapter(Context context, ArrayList<String> list) {
            this.context = context;
            this.list = list;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            int total = list.size();
            if (total < 9)
                total++;
            return total;
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = inflater.inflate(R.layout.fx_item_gridview_image, null);
            ImageView sdv_image = (ImageView) convertView.findViewById(R.id.sdv_image);
            if (position == list.size() && list.size() < 9) {
                sdv_image.setBackgroundResource(R.drawable.fx_icon_add);
            } else {
                String itemPath = getItem(position);
                Glide.with(FriendTalkPushActivity.this)
                        .load(itemPath)
                        .diskCacheStrategy(DiskCacheStrategy.RESULT)
                        .into(sdv_image);
            }

            return convertView;
        }
    }

    private void addPhotoToGridView() {
        monitorGalleryPick();
        initGalleryConfig();
        initPermissions();
    }

    private void showBigPicOrDeleteDialog(final int position) {
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.fx_dialog_social_main);
        TextView tv_paizhao = (TextView) window.findViewById(R.id.tv_content1);
        tv_paizhao.setText("看大图");
        tv_paizhao.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(FriendTalkPushActivity.this, PhotoViewActivity.class);
                intent.putStringArrayListExtra("imgurllist", originPhotoList);
                intent.putExtra("position", position);
                startActivity(intent);
                dlg.cancel();
            }
        });
        TextView tv_xiangce = (TextView) window.findViewById(R.id.tv_content2);
        tv_xiangce.setText("删除");
        tv_xiangce.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                originPhotoList.remove(position);
                imageAdapter.notifyDataSetChanged();
                dlg.cancel();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
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
                imageAdapter.notifyDataSetChanged();
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
                .multiSelect(true)                      // 是否多选   默认：false
                .multiSelect(true, maxSize)                   // 配置是否多选的同时 配置多选数量   默认：false ， 9
                .maxSize(maxSize)                             // 配置多选时 的多选数量。    默认：9
                .crop(false)                             // 快捷开启裁剪功能，仅当单选 或直接开启相机时有效
                .crop(false, 1, 1, 500, 500)             // 配置裁剪功能的参数，   默认裁剪比例 1:1
                .isShowCamera(false)                     // 是否现实相机按钮  默认：false
                .filePath("/Gallery")// 图片存放路径
                .build();
    }

    // 授权管理
    private void initPermissions() {
        if (ContextCompat.checkSelfPermission(FriendTalkPushActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(FriendTalkPushActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i(TAG, "拒绝过了");
                Toast.makeText(FriendTalkPushActivity.this, "请在 设置-应用管理 中开启此应用的储存授权。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(FriendTalkPushActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
            }
        } else {
            Log.i(TAG, "不需要授权 ");
            GalleryPick.getInstance().setGalleryConfig(galleryConfig).open(FriendTalkPushActivity.this);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(FriendTalkPushActivity.this, MainActivity.class);
        intent.putExtra("whichFragment", 3);
        startActivity(intent);
        finish();
    }
}
