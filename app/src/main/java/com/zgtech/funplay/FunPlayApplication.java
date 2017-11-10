package com.zgtech.funplay;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.hss01248.dialog.MyActyManager;
import com.hss01248.dialog.StyledDialog;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;
import com.hyphenate.easeui.controller.EaseUI;
import com.hyphenate.easeui.domain.EaseUser;
import com.wanjian.cockroach.Cockroach;
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
        initCockroach();
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

    public void initCockroach() {
        Cockroach.install(new Cockroach.ExceptionHandler() {

            // handlerException内部建议手动try{  你的异常处理逻辑  }catch(Throwable e){ } ，以防handlerException内部再次抛出异常，导致循环调用handlerException

            @Override
            public void handlerException(final Thread thread, final Throwable throwable) {
                //开发时使用Cockroach可能不容易发现bug，所以建议开发阶段在handlerException中用Toast谈个提示框，
                //由于handlerException可能运行在非ui线程中，Toast又需要在主线程，所以new了一个new Handler(Looper.getMainLooper())，
                //所以千万不要在下面的run方法中执行耗时操作，因为run已经运行在了ui线程中。
                //new Handler(Looper.getMainLooper())只是为了能弹出个toast，并无其他用途
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //建议使用下面方式在控制台打印异常，这样就可以在Error级别看到红色log
                            Log.e("AndroidRuntime","--->CockroachException:"+thread+"<---",throwable);
//                            Toast.makeText(YiYongApplication.getContext(), "Exception Happend\n" + thread + "\n" + throwable.toString(), Toast.LENGTH_SHORT).show();
//                        throw new RuntimeException("..."+(i++));
                        } catch (Throwable e) {

                        }
                    }
                });
            }
        });
    }

}
