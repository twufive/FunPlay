package com.zgtech.funplay;

import android.app.Application;
import android.content.Context;
import android.util.DisplayMetrics;

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


    }

    /**
     * 提供一个应用级别的全局上下文mContext
     */
    public static Context getContext() {
        return mContext;
    }
}
