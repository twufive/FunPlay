package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.global.OptionsUtils;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.T;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 注册第三页面
 * Created by Administrator on 2017/8/9.
 */

public class RegistCActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_age)
    TextView tvAge;
    @Bind(R.id.tv_height)
    TextView tvHeight;
    @Bind(R.id.tv_constellation)
    TextView tvConstellation;
    @Bind(R.id.btn_complete)
    Button btnComplete;

    private String sex;
    private String birth;
    private String height;
    private String constellation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_c);
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

    @OnClick({R.id.ll_back, R.id.tv_sex, R.id.tv_age, R.id.tv_height, R.id.tv_constellation, R.id.btn_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_sex:
                OptionsUtils.showSexOptions(RegistCActivity.this, new OptionsUtils.OptionsCallback() {
                    @Override
                    public void onSelectComleted(String result) {
                        sex = result;
                        tvSex.setText(result);
                    }
                });


                break;
            case R.id.tv_age:
                OptionsUtils.showBirthOptions(RegistCActivity.this, new OptionsUtils.OptionsCallback() {
                    @Override
                    public void onSelectComleted(String result) {
                        birth = result;
                        tvAge.setText(result);
                    }
                });
                break;
            case R.id.tv_height:
                OptionsUtils.showStatureOptions(RegistCActivity.this, new OptionsUtils.OptionsCallback() {
                    @Override
                    public void onSelectComleted(String result) {
                        height = result;
                        tvHeight.setText(result);
                    }
                });
                break;
            case R.id.tv_constellation:
                OptionsUtils.showConstellationOptions(RegistCActivity.this, new OptionsUtils.OptionsCallback() {
                    @Override
                    public void onSelectComleted(String result) {
                        String[] split = result.split(",");
                        String strConstellation = split[0];
                        String constellationCode = split[1];

                        constellation = constellationCode;
                        tvConstellation.setText(strConstellation);
                    }
                });
                break;
            case R.id.btn_complete:
                if (TextUtils.isEmpty(sex)) {
                    T.showShort("请选择性别");
                } else if (TextUtils.isEmpty(birth)) {
                    T.showShort("请选择生日");
                } else if (TextUtils.isEmpty(height)) {
                    T.showShort("请选择身高");
                } else if (TextUtils.isEmpty(constellation)) {
                    T.showShort("请选择星座");
                } else {
                    modifyPersonal();
                }
                break;
        }
    }

    private void modifyPersonal() {
        String sexCode = null;
        if (sex.equals("男")) {
            sexCode = "1";
        } else if (sex.equals("女")) {
            sexCode = "2";
        }


        HashMap map = new HashMap();
        map.put("userRegisterProgress", "2");
        map.put("userSex", sexCode);
        map.put("userHeight", height);
        map.put("userConstellation", constellation);

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
                toNextActivity(LoginActivity.class);
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
