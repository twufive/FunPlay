package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.LoginModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.RegexUtils;
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
 * 登录页面
 * Created by Administrator on 2017/8/9.
 */

public class LoginActivity extends BaseActivity {
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_to_register)
    TextView tvToRegister;
    @Bind(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @Bind(R.id.et_mobile)
    EditText etMobile;
    @Bind(R.id.et_pwd)
    EditText etPwd;
    @Bind(R.id.rl_to_mobile_login)
    RelativeLayout rlToMobileLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        etMobile.setText("15073001217");
        etPwd.setText("123456");
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.btn_login, R.id.tv_to_register, R.id.tv_forget_pwd,R.id.rl_to_mobile_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                doRegax();
                break;
            case R.id.tv_forget_pwd:
                toNextActivity(LoginForgetPwdActivity.class);
                break;
            case R.id.rl_to_mobile_login:
                toNextActivity(LoginSMSActivity.class);
                break;
            case R.id.tv_to_register:
                toNextActivity(RegistAActivity.class);
                break;
        }
    }

    private void doRegax() {
        String mobile = etMobile.getText().toString();
        String pwd = etPwd.getText().toString();

        if (TextUtils.isEmpty(mobile)) {
            T.showShort("请输入手机号码");
        } else if (!RegexUtils.isMobilePhoneNumber(mobile)) {
            T.showShort("请输入正确的手机号码");
        } else if (TextUtils.isEmpty(pwd)) {
            T.showShort("请输入密码");
        } else {
            doLogin(mobile,pwd);
        }
    }

    private void doLogin(String mobile, String pwd) {
        HashMap map = new HashMap();
        map.put("userPhone", mobile);
        map.put("userPwd", pwd);
        RequestBody body = RequestBodyBuilder.build(map);

        mApiStores.doLogin(body).enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
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

            private void handleServerData(LoginModel model) {
                L.i("loginInfo", model.toString());
                toNextActivityAndCloseThis(MainActivity.class);
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }
}
