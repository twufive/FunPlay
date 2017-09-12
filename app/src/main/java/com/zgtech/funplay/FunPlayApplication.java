package com.zgtech.funplay;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.multidex.MultiDex;

import com.hss01248.dialog.MyActyManager;
import com.hss01248.dialog.StyledDialog;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.easeui.domain.EaseUser;
import com.zgtech.funplay.greendao.gen.DaoMaster;
import com.zgtech.funplay.greendao.gen.DaoSession;
import com.zgtech.funplay.greendao.gen.HxUserModelDao;
import com.zgtech.funplay.model.HxUserModel;
import com.zgtech.funplay.utils.L;

import java.util.List;

/**
 * 趣玩应用入口，全局上下文
 * Created by Administrator on 2017/8/3.
 */

public class FunPlayApplication extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initIM();
        initStyledDialog();
    }

    private void initIM() {
        EMOptions options = new EMOptions();
        EMClient.getInstance().init(FunPlayApplication.this, options);
        EaseUI easeUI = EaseUI.getInstance();
        easeUI.init(FunPlayApplication.this, options);
        initUserProfileProvider(easeUI);
    }

    private void initUserProfileProvider(EaseUI easeUI) {
        // 如果要使用自定义的头像等内容
        easeUI.setUserProfileProvider(new EaseUI.EaseUserProfileProvider() {
            @Override
            public EaseUser getUser(String username) {
                L.i("EaseUserusername", username);
                return initIMUserInfo(username);
            }
        });
    }

    /**
     * 注意，这里是环信提供用户名称，昵称，头像的核心函数.
     */
    public EaseUser initIMUserInfo(final String username) {
        EaseUser easeUser = null;
        easeUser = new EaseUser(username);
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(getApplicationContext(), "zayin.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        HxUserModelDao hxUserModelDao = daoSession.getHxUserModelDao();

        List<HxUserModel> hxUserModels = hxUserModelDao.loadAll();
        for (HxUserModel hxUserModel : hxUserModels) {
            if (hxUserModel.getImUser().equalsIgnoreCase(username)) {
                easeUser.setNick(hxUserModel.getHxNickname());
                easeUser.setNickname(hxUserModel.getHxNickname());
                easeUser.setAvatar(hxUserModel.getHxAvatar());
            }
        }

        devOpenHelper.close();
        return easeUser;
    }

    /**
     * 提供一个应用级别的全局上下文mContext
     */
    public static Context getContext() {
        return mContext;
    }

    private void initStyledDialog() {
        StyledDialog.init(this);
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                //在这里保存顶层activity的引用(内部以软引用实现)
                MyActyManager.getInstance().setCurrentActivity(activity);

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
