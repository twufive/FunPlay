package com.zgtech.funplay.activity.tabcenter;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yancy.gallerypick.inter.IHandlerCallBack;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.MainActivity;
import com.zgtech.funplay.activity.PhotoViewActivity;
import com.zgtech.funplay.adapter.ImageAdapter;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.UpImgsModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.retrofit.RetrofitParameterBuilder;
import com.zgtech.funplay.utils.CameraUtils;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.SP;
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
 * 发布新的拼团订单
 * Created by Administrator on 2017/8/31.
 */

public class PushNewOrderActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.gridview)
    GridView gridView;
    @Bind(R.id.et_title)
    EditText etTitle;
    @Bind(R.id.et_size)
    EditText etSize;
    @Bind(R.id.et_price_new)
    EditText etPriceNew;
    @Bind(R.id.et_price_old)
    EditText etPriceOld;
    @Bind(R.id.et_order_trip)
    EditText etOrderTrip;
    @Bind(R.id.et_order_remark)
    EditText etOrderRemark;
    @Bind(R.id.et_order_attention)
    EditText etOrderAttention;
    @Bind(R.id.et_order_contact)
    EditText etOrderContact;
    @Bind(R.id.et_order_phone)
    EditText etOrderPhone;
    private ImageAdapter imageAdapter;

    private ArrayList<String> originPhotoList = new ArrayList<>();
    private IHandlerCallBack iHandlerCallBack;
    private ProgressDialog dialog;
    private String exclusiveId;
    private HashMap<Object, Object> originMap = new HashMap<>();
    private String title;
    private String size;
    private String priceNew;
    private String priceOld;
    private String orderTrip;
    private String orderRemark;
    private String orderAttention;
    private String orderContact;
    private String orderPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_push_new_order);
        ButterKnife.bind(this);

        exclusiveId = SP.getString(this, "exclusiveId", "");

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
        tvToolbar.setText("发布拼团");
        tvRight.setText("保存");
        tvRight.setTextColor(Color.WHITE);

        initGridView();
    }

    @Override
    public void initData() {

    }

    private void initGridView() {
        imageAdapter = new ImageAdapter(PushNewOrderActivity.this, originPhotoList);
        gridView.setAdapter(imageAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (originPhotoList.size() < 9 && position == originPhotoList.size()) {
                    showPhotoDialog(originPhotoList);
                } else {
                    showItemClickDialog(position);
                }
            }

        });
    }

    private void showPhotoDialog(ArrayList<String> originPhotoList) {
        monitorGalleryPick();
        CameraUtils.initGalleryConfig(iHandlerCallBack, originPhotoList);
        CameraUtils.initPermissions(this);
    }

    private void showItemClickDialog(final int position) {
        final AlertDialog dlg = new AlertDialog.Builder(this).create();
        dlg.show();
        Window window = dlg.getWindow();
        window.setContentView(R.layout.fx_dialog_social_main);
        TextView tv_paizhao = (TextView) window.findViewById(R.id.tv_content1);
        tv_paizhao.setText("看大图");
        tv_paizhao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PushNewOrderActivity.this, PhotoViewActivity.class);
                intent.putStringArrayListExtra("imgurllist", originPhotoList);
                intent.putExtra("position", position);
                startActivity(intent);
                dlg.cancel();
            }
        });
        TextView tv_xiangce = (TextView) window.findViewById(R.id.tv_content2);
        tv_xiangce.setText("删除");
        tv_xiangce.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                originPhotoList.remove(position);
                imageAdapter.notifyDataSetChanged();
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

    @OnClick({R.id.ll_back, R.id.tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_right:
                title = etTitle.getText().toString();
                size = etSize.getText().toString();
                priceNew = etPriceNew.getText().toString();
                priceOld = etPriceOld.getText().toString();
                orderTrip = etOrderTrip.getText().toString();
                orderRemark = etOrderRemark.getText().toString();
                orderAttention = etOrderAttention.getText().toString();
                orderContact = etOrderContact.getText().toString();
                orderPhone = etOrderPhone.getText().toString();

                if (TextUtils.isEmpty(title)) {
                    T.showShort("请填写拼团标题");
                } else if (TextUtils.isEmpty(size)) {
                    T.showShort("请填写拼团人数");
                } else if (TextUtils.isEmpty(priceNew)) {
                    T.showShort("请填写拼团价格");
                } else if (TextUtils.isEmpty(priceOld)) {
                    T.showShort("请填写拼团折扣价");
                } else if (TextUtils.isEmpty(orderTrip)) {
                    T.showShort("请填写拼团路线安排");
                } else if (TextUtils.isEmpty(orderRemark)) {
                    T.showShort("请填写拼团费用说明");
                } else if (TextUtils.isEmpty(orderAttention)) {
                    T.showShort("请填写拼团注意事项");
                } else if (TextUtils.isEmpty(orderContact)) {
                    T.showShort("请填写拼团联系人");
                } else if (TextUtils.isEmpty(orderPhone)) {
                    T.showShort("请填写拼团联系方式");
                } else {

                    dialog = new ProgressDialog(this);
                    dialog.setCanceledOnTouchOutside(false);
                    dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    dialog.setMessage("正在发布...");
                    dialog.show();
                    upImgsToServer(originPhotoList);

                    L.i("orginList", originPhotoList.toString());
                }


                break;
        }
    }

    private void upImgsToServer(ArrayList<String> originPhotoList) {
        final RetrofitParameterBuilder retrofitParameterBuilder = RetrofitParameterBuilder.newBuilder();

        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < originPhotoList.size(); i++) {
            File file = new File(originPhotoList.get(i));
            fileList.add(file);
        }

        Luban.compress(PushNewOrderActivity.this, fileList)
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

                    pushOrder(urlList);

                    retrofitParameterBuilder.cleanParams();
                } else {
                    T.showShort(PushNewOrderActivity.this, response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<UpImgsModel> call, Throwable t) {

            }
        });
    }

    private void pushOrder(List<String> urlList) {
        originMap.put("orderTitle", title);
        originMap.put("orderSize", size);
        originMap.put("orderPrice1", priceNew);
        originMap.put("orderPrice0", priceOld);
        originMap.put("orderTrip", orderTrip);
        originMap.put("orderRemark", orderRemark);
        originMap.put("orderAttention", orderAttention);
        originMap.put("orderContact", orderContact);
        originMap.put("orderPhone", orderPhone);
        originMap.put("state", "1");
        addMapParam(urlList);

        RequestBody body = RequestBodyBuilder.build(originMap);

        mApiStores.pushNewOrder(body).enqueue(new Callback<BaseResultModel>() {
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
                T.showShort("发布拼团成功!");
                dialog.dismiss();

                Intent intent = new Intent(PushNewOrderActivity.this, MainActivity.class);
                intent.putExtra("whichFragment", 0);
                startActivity(intent);
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
            originMap.put("orderPicture" + temp, urlList.get(i));
        }
    }
}
