package com.zgtech.funplay.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.easeui.domain.EaseUser;
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
import com.zgtech.funplay.utils.SP;
import com.zgtech.funplay.utils.T;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 新的闪屏页
 * Created by Administrator on 2017/9/14.
 */

public class SplashNewActivity extends BaseActivity {
    @Bind(R.id.rl_root)
    RelativeLayout rlRoot;

    private DaoMaster.DevOpenHelper devOpenHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_new);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    @Override
    public void initView() {
        initStatusBarState();

        //闪屏动画合集
        AnimationSet set = getAnimationSet();
        setAnimListener(set);
    }

    private void initStatusBarState() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void initData() {

    }


    @NonNull
    private AnimationSet getAnimationSet() {
        // 旋转动画
        RotateAnimation animRotate = new RotateAnimation(0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animRotate.setDuration(2000);// 动画时间
        animRotate.setFillAfter(true);// 保持动画结束状态

        // 缩放动画
        ScaleAnimation animScale = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animScale.setDuration(2000);
        animScale.setFillAfter(true);// 保持动画结束状态

        // 渐变动画
        AlphaAnimation animAlpha = new AlphaAnimation(0, 1);
        animAlpha.setDuration(2000);// 动画时间
        animAlpha.setFillAfter(true);// 保持动画结束状态

        // 动画集合
        AnimationSet set = new AnimationSet(true);
//        set.addAnimation(animRotate);
        set.addAnimation(animScale);
        set.addAnimation(animAlpha);

        // 启动动画
        rlRoot.startAnimation(set);
        return set;
    }

    private void setAnimListener(AnimationSet set) {
        set.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 动画结束,跳转页面
                // 否则跳登陆页面
                boolean isLogined = SP.getBoolean(SplashNewActivity.this, "isLogined", false);


                // 登陆页面
                if (isLogined) {
                    //已经输入密码登录过
                    //登录的时候，要验证用户的真实性
                    String mobile = SP.getString(SplashNewActivity.this, "myMobile", "");
                    String pwd = SP.getString(SplashNewActivity.this, "myPwd", "");
                    String androidToken = SP.getString(SplashNewActivity.this, "androidToken", "");

                    doLogin(mobile,pwd);
                } else {
                    Intent intent = new Intent(SplashNewActivity.this, LoginActivity.class);
                    fadeNextActivity(intent);

//                    toNextActivityAndCloseThis(MainActivity.class);
                }

            }
        });
    }

    private void doLogin(final String mobile, final String pwd) {
        HashMap map = new HashMap();
        map.put("userPhone", mobile);
        map.put("userPwd", pwd);
        RequestBody body = RequestBodyBuilder.build(map);
        mApiStores.doLogin(body).enqueue(new Callback<LoginBackUserModel>() {
            @Override
            public void onResponse(Call<LoginBackUserModel> call, Response<LoginBackUserModel> response) {
                if (response.isSuccessful()) {
                    if (response.body().getCode() == 2) {
                        handleServerData(response.body(),mobile,pwd);
                    } else {
                        T.showShort(response.body().getMsg());
                    }
                } else {
                    T.showShort(response.toString());
                }
            }

            private void handleServerData(LoginBackUserModel model, String mobile, String pwd) {
                saveUserInfo(model,mobile,pwd);
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

    private String saveUserInfo(LoginBackUserModel loginBackUserModel, String mobile, String pwd) {
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

        SP.setString(SplashNewActivity.this, "userId", exclusiveId);
        SP.setString(SplashNewActivity.this, "myImUser", myImUser);
        SP.setString(SplashNewActivity.this, "myNick", myNick);
        SP.setString(SplashNewActivity.this, "myAvatar", myAvatar);
        SP.setString(SplashNewActivity.this, "mySex", mySex);
        SP.setString(SplashNewActivity.this, "myMobile", mobile);
        SP.setString(SplashNewActivity.this, "myPwd", pwd);



        SP.setString(SplashNewActivity.this, "stateIdent", stateIdent);//身份认证
        SP.setString(SplashNewActivity.this, "stateIdentJob", stateIdentJob);//职业认证




        devOpenHelper = new DaoMaster.DevOpenHelper(SplashNewActivity.this, "zayin.db", null);
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
    
}
