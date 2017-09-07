package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.RegistCodeModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.RegexUtils;
import com.zgtech.funplay.utils.T;
import com.zgtech.funplay.utils.TimeCountDownUtils;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.zgtech.funplay.R.id.tv_get_verify;

/**
 * 注册第一页面
 * Created by Administrator on 2017/8/9.
 */

public class RegistAActivity extends BaseActivity {
    @Bind(R.id.et_mobile)
    EditText etMobile;
    @Bind(R.id.et_verify)
    EditText etVerify;
    @Bind(tv_get_verify)
    TextView tvGetVerify;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.btn_regist)
    Button btnRegist;
    @Bind(R.id.tv_protocol)
    TextView tvProtocol;

    private String obj;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_a);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {


    }

    @Override
    public void initData() {

    }

    @OnClick({tv_get_verify, R.id.btn_regist, R.id.tv_protocol})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case tv_get_verify:
                String mobile = etMobile.getText().toString();

                if (TextUtils.isEmpty(mobile)) {
                    T.showShort("请填写手机号码");
                } else if (!RegexUtils.isMobilePhoneNumber(mobile)) {
                    T.showShort("请填写正确的手机号码");
                } else {
                    doGetVerifyCode(mobile);
                }
                break;
            case R.id.btn_regist:
                toNextActivity(RegistBActivity.class);
//                doRegist();
                break;
            case R.id.tv_protocol:
                //打开用户协议webView
                break;
        }
    }

    private void doRegist() {
        String mobilePhone = etMobile.getText().toString();
        String verifyCode = etVerify.getText().toString();
        String pwd = etPwd.getText().toString();
        String objCode = obj;

        HashMap map = new HashMap();
        map.put("userPhone", mobilePhone);
        map.put("userPwd", pwd);
        map.put("verifyPwd", pwd);
        map.put("verifyCode", verifyCode);
        map.put("checkCode", objCode);
        RequestBody body = RequestBodyBuilder.build(map);

        mApiStores.doRegist(body).enqueue(new Callback<BaseResultModel>() {
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
                toNextActivity(RegistBActivity.class);
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    private void doGetVerifyCode(String mobile) {
        TimeCountDownUtils timer = new TimeCountDownUtils(60000, 1000, tvGetVerify);
        timer.start();

        mApiStores.getRegisterVerifyCode(mobile).enqueue(new Callback<RegistCodeModel>() {
            @Override
            public void onResponse(Call<RegistCodeModel> call, Response<RegistCodeModel> response) {
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

            private void handleServerData(RegistCodeModel model) {
                obj = model.getObj();
            }

            @Override
            public void onFailure(Call<RegistCodeModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
