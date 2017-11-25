package com.zgtech.funplay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.util.DeviceUuidFactory;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.LoginBackUserModel;
import com.zgtech.funplay.model.RegistCodeModel;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.RegexUtils;
import com.zgtech.funplay.utils.SP;
import com.zgtech.funplay.utils.StringUtils;
import com.zgtech.funplay.utils.T;
import com.zgtech.funplay.utils.TimeCountDownUtils;

import java.util.HashMap;
import java.util.UUID;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 登录时使用手机验证码登录页面
 * Created by Administrator on 2017/8/9.
 */

public class LoginSMSActivity extends BaseActivity {
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
    @Bind(R.id.tv_protocol)
    TextView tvProtocol;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_to_register)
    TextView tvToRegister;

    private String obj;
    private String androidToken;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_sms);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("使用手机登录");

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.btn_get_verify, R.id.tv_protocol, R.id.btn_login, R.id.tv_to_register})
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
            case R.id.tv_protocol:
                break;
            case R.id.btn_login:
                doRegax();
                break;
            case R.id.tv_to_register:
                break;
        }
    }

    private void doRegax() {
        String mobile = etMobile.getText().toString();
        String verifyCode = etVerifyCode.getText().toString();

        if (TextUtils.isEmpty(mobile)) {
            T.showShort("请输入手机号码");
        } else if (!RegexUtils.isMobilePhoneNumber(mobile)) {
            T.showShort("请输入正确的手机号码");
        } else if (TextUtils.isEmpty(verifyCode)) {
            T.showShort("请输入验证码");
        } else {
            doLogin(mobile, verifyCode);
        }
    }


    private void doLogin(final String mobile, final String pwd) {
        obtainAndSaveDeviceToken(mobile);
//        showLoginingDialog();
        HashMap map = new HashMap();
        map.put("userPhone", mobile);
        map.put("verifyCode", pwd);
        map.put("checkCode", obj);
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.doLogin(body).enqueue(new Callback<LoginBackUserModel>() {
            @Override
            public void onResponse(Call<LoginBackUserModel> call, Response<LoginBackUserModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode() == 2) {
                        handleServerData(response.body(), mobile, pwd);
                    } else {
                        T.showShort(response.body().getMsg());
                    }
                } else {
                    T.showShort(response.toString());
                }
            }

            private void handleServerData(LoginBackUserModel model, String mobile, String pwd) {
                SP.setBoolean(LoginSMSActivity.this, "isLogined", true);

                loginIM(model.getObj().getDetail().getImUser(), "123456");
                toNextActivityAndCloseThis(MainActivity.class);
            }

            @Override
            public void onFailure(Call<LoginBackUserModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }


    private void loginIM(final String myImUser, String pwd) {
        EMClient.getInstance().login(myImUser, pwd, new EMCallBack() {//回调
            @Override
            public void onSuccess() {
                EMClient.getInstance().groupManager().loadAllGroups();
                EMClient.getInstance().chatManager().loadAllConversations();
                L.i("loginIM", "登录聊天服务器成功！");
                L.i("myImUser", myImUser);
            }

            @Override
            public void onProgress(int progress, String status) {

            }

            @Override
            public void onError(int code, String message) {
                L.i("IMonError", message);
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

    private void obtainAndSaveDeviceToken(String mobile) {
        DeviceUuidFactory deviceUuidFactory = new DeviceUuidFactory(this);
        UUID deviceUuid = deviceUuidFactory.getDeviceUuid();
        String strUUID = String.valueOf(deviceUuid);
        androidToken = StringUtils.MD5(strUUID + mobile);
        SP.setString(this, "androidToken", androidToken);

        L.d("szImei", "" + deviceUuid);
        L.d("androidToken", "" + androidToken);
    }

}
