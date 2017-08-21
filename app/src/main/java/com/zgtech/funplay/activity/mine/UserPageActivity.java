package com.zgtech.funplay.activity.mine;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.TaPinTuanFragment;
import com.zgtech.funplay.activity.TaStoryFragment;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的主页
 * Created by Administrator on 2017/8/14.
 */

public class UserPageActivity extends BaseActivity {
    @Bind(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    private MyPagerAdapter adapter;
    private TaStoryFragment taStoryFragment;
    private TaPinTuanFragment taPinTuanFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_user_detail);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
//        llBack.setVisibility(View.VISIBLE);
//        tvToolbar.setText("我的主页");

        initStatusBarState();

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        initTabs(viewpager);
    }

    @Override
    public void initData() {

    }


    private void initTabs(ViewPager viewPagerV4) {
        tabs.setViewPager(viewPagerV4);
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:

                        break;
                    case 1:

                        break;
                    default:
                        break;
                }

//                nestedScrollView.scrollTo(0, 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"TA的故事", "TA的拼团"};

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return taStoryFragment == null ? TaStoryFragment.newInstance() : taStoryFragment;
                case 1:
                    return taPinTuanFragment == null ? TaPinTuanFragment.newInstance() : taPinTuanFragment;
                default:
                    return taStoryFragment == null ? TaStoryFragment.newInstance() : taStoryFragment;
            }


        }

    }

    private void initStatusBarState() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
