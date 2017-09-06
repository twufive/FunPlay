package com.zgtech.funplay.activity.moduled;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的拼团
 * Created by Administrator on 2017/8/5.
 */

public class MyPinTuanActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    private MyPagerAdapter adapter;
    private PinTuanAllFragment pinTuanAllFragment;
    private PinTuanRefundFragment pinTuanRefundFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_pintuan);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
        tvToolbar.setText("我的拼团");

        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        initTabs(viewpager);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_back, R.id.tv_toolbar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_toolbar:
                break;
        }
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
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        private final String[] TITLES = {"全部", "退款/售后"};

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
                    return pinTuanAllFragment == null ? PinTuanAllFragment.newInstance() : pinTuanAllFragment;
                case 1:
//                    return pinTuanRefundFragment == null ? PinTuanRefundFragment.newInstance() : pinTuanRefundFragment;
                default:
                    return pinTuanAllFragment == null ? PinTuanAllFragment.newInstance() : pinTuanAllFragment;
            }
        }

    }
}
