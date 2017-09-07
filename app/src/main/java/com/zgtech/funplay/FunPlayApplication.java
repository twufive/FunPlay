package com.zgtech.funplay;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.hss01248.dialog.MyActyManager;
import com.hss01248.dialog.StyledDialog;

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

        initStyledDialog();

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
}
