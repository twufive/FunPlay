package com.zgtech.funplay.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zgtech.funplay.R;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.retrofit.RetrofitUtilPublicParams;
import com.zgtech.funplay.utils.ActivityCollectorUtils;
import com.zgtech.funplay.utils.L;

/**
 * Created by Administrator on 2017/8/2.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public String TAG = "NetConditions";
    public ApiStores mApiStores;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollectorUtils.addActivity(this);
        L.d("NowActivity:", getClass().getSimpleName());

        mApiStores = RetrofitUtilPublicParams.initApiStores();
    }

    public abstract void initView();

    public abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollectorUtils.removeActivity(this);
        L.d("DestroyedActivity:", getClass().getSimpleName());
    }

    public void toNextActivity(Class targetActivityClass) {
        Intent intent = new Intent(this, targetActivityClass);
        startActivity(intent);
    }

    public void toNextActivityAndCloseThis(Class targetActivityClass) {
        Intent intent = new Intent(this, targetActivityClass);
        startActivity(intent);
        finish();
    }

    /**
     * 左边滑出，右边滑入的进入下一个Activity动画
     */
    public void slideNextActivity(Intent intent) {
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    /**
     * 进入淡入，出去淡出的进入下一个Activity动画
     */
    public void fadeNextActivity(Intent intent) {
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * 左边滑入，右边滑出的回到上一个Activity动画
     */
    public void backPreActivity(Intent intent) {
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}
