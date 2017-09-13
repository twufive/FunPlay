package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
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

/**
 * 登录时忘记密码页面
 * Created by Administrator on 2017/8/9.
 */

public class LoginForgetPwdActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.et_mobile)
    EditText etMobile;
    @Bind(R.id.et_verify_code)
    EditText etVerifyCode;
    @Bind(R.id.btn_get_verify)
    Button btnGetVerify;
    @Bind(R.id.et_new_pwd)
    EditText etNewPwd;
    @Bind(R.id.btn_change_login)
    Button btnChangeLogin;

    private String obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("忘记密码");


    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.btn_get_verify, R.id.btn_change_login})
    public void onViewClicked(View view) {
        String mobile = etMobile.getText().toString();

        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.btn_get_verify:
                if (TextUtils.isEmpty(mobile)) {
                    T.showShort("请填写手机号码");
                } else if (!RegexUtils.isMobilePhoneNumber(mobile)) {
                    T.showShort("请填写正确的手机号码");
                } else {
                    doGetVerifyCode(mobile);
                }
                break;
            case R.id.btn_change_login:
                String newPwd = etNewPwd.getText().toString();
                String verifyCode = etVerifyCode.getText().toString();
                if (TextUtils.isEmpty(newPwd)) {
                    T.showShort("请输入新的密码！");
                } else if (TextUtils.isEmpty(verifyCode)) {
                    T.showShort("请输入验证码！");
                } else {
                    doModifyPwd(mobile, verifyCode, newPwd);
                }
                break;
        }
    }

    private void doModifyPwd(String mobile, String verifyCode, String newPwd) {
        HashMap map = new HashMap();
        map.put("userPhone", mobile);
        map.put("userPwd", newPwd);
        map.put("verifyPwd", newPwd);
        map.put("verifyCode", verifyCode);
        map.put("checkCode", obj);
        map.put("login", "true");
        RequestBody body = RequestBodyBuilder.build(map);

        mApiStores.modifyPwd(body).enqueue(new Callback<BaseResultModel>() {
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
                T.showShort("恭喜您！修改密码成功！");
                toNextActivity(LoginActivity.class);
            }

            @Override
            public void onFailure(Call<BaseResultModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    private void doGetVerifyCode(String mobile) {
        TimeCountDownUtils timer = new TimeCountDownUtils(60000, 1000, btnGetVerify);
        timer.start();

        mApiStores.getVerifyCode(mobile).enqueue(new Callback<RegistCodeModel>() {
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
