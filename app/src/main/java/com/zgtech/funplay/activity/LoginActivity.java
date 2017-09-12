package com.zgtech.funplay.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;
import com.hyphenate.util.DeviceUuidFactory;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.greendao.gen.DaoMaster;
import com.zgtech.funplay.greendao.gen.DaoSession;
import com.zgtech.funplay.greendao.gen.HxUserModelDao;
import com.zgtech.funplay.model.HxUserModel;
import com.zgtech.funplay.model.LoginBackUserModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.RegexUtils;
import com.zgtech.funplay.utils.SPUtils;
import com.zgtech.funplay.utils.StringUtils;
import com.zgtech.funplay.utils.T;

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

    private String androidToken;
    private DaoMaster.DevOpenHelper devOpenHelper;
    private ProgressDialog dialog;

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
        etMobile.setText("17707470095");
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

    private void doLogin(final String mobile, String pwd) {
        obtainAndSaveDeviceToken(mobile);
//        showLoginingDialog();
        HashMap map = new HashMap();
        map.put("userPhone", mobile);
        map.put("userPwd", pwd);
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.doLogin(body).enqueue(new Callback<LoginBackUserModel>() {
            @Override
            public void onResponse(Call<LoginBackUserModel> call, Response<LoginBackUserModel> response) {
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

            private void handleServerData(LoginBackUserModel model) {
                saveUserInfo(model);
                loginIM(model.getObj().getDetail().getImUser(), "123456");
                toNextActivityAndCloseThis(MainActivity.class);
            }

            @Override
            public void onFailure(Call<LoginBackUserModel> call, Throwable t) {
                T.showShort(t.toString());
            }
        });
    }

    private void loginIM( final String myImUser, String pwd) {
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
              L.i("IMonError",message);
            }
        });
    }

    private String saveUserInfo(LoginBackUserModel loginBackUserModel) {
        String exclusiveId = String.valueOf(loginBackUserModel.getObj().getUserId());
        String myImUser = String.valueOf(loginBackUserModel.getObj().getDetail().getImUser());
        String myNick = String.valueOf(loginBackUserModel.getObj().getDetail().getUserNick());
        String myAvatar = String.valueOf(loginBackUserModel.getObj().getDetail().getUserIcon());
        String mySex = String.valueOf(loginBackUserModel.getObj().getDetail().getUserSex());
        String myMobile = String.valueOf(loginBackUserModel.getObj().getDetail().getUserPhone());

        String stateIdentCode = String.valueOf(loginBackUserModel.getObj().getDetail().getStateIdent());
        String stateIdentJobCode = String.valueOf(loginBackUserModel.getObj().getDetail().getStateIdentJob());

        String stateIdent = stateIdentCode.equals("0")?"未认证":"已认证";
        String stateIdentJob = stateIdentJobCode.equals("0")?"未认证":"已认证";

        SPUtils.setString(LoginActivity.this, "userId", exclusiveId);
        SPUtils.setString(LoginActivity.this, "myImUser", myImUser);
        SPUtils.setString(LoginActivity.this, "myNick", myNick);
        SPUtils.setString(LoginActivity.this, "myAvatar", myAvatar);
        SPUtils.setString(LoginActivity.this, "mySex", mySex);
        SPUtils.setString(LoginActivity.this, "myMobile", myMobile);
        SPUtils.setString(LoginActivity.this, "androidToken", androidToken);


        SPUtils.setString(LoginActivity.this, "stateIdent", stateIdent);//身份认证
        SPUtils.setString(LoginActivity.this, "stateIdentJob", stateIdentJob);//职业认证




        devOpenHelper = new DaoMaster.DevOpenHelper(LoginActivity.this, "zayin.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        HxUserModelDao hxUserModelDao = daoSession.getHxUserModelDao();

        HxUserModel hxUserModel = new HxUserModel();
        hxUserModel.setImUser(myImUser);
        hxUserModel.setUserId(exclusiveId);
        hxUserModel.setHxNickname(myNick);
        hxUserModel.setHxAvatar(ApiStores.API_SERVER_URL + myAvatar);
        hxUserModelDao.insertOrReplace(hxUserModel);

        EaseUser easeUser = new EaseUser(myImUser);
        easeUser.setNickname(myNick);
        easeUser.setAvatar(ApiStores.API_SERVER_URL + myAvatar);
        return myImUser;
    }

    private void obtainAndSaveDeviceToken(String mobile) {
        DeviceUuidFactory deviceUuidFactory = new DeviceUuidFactory(this);
        UUID deviceUuid = deviceUuidFactory.getDeviceUuid();
        String strUUID = String.valueOf(deviceUuid);
        androidToken = StringUtils.MD5(strUUID + mobile);
        SPUtils.setString(this, "androidToken", androidToken);

        L.d("szImei", "" + deviceUuid);
        L.d("androidToken", "" + androidToken);
    }

    private void showLoginingDialog() {
        dialog = new ProgressDialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("正在登录...");
        dialog.show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        devOpenHelper.close();
    }
}
