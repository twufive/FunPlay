package com.zgtech.funplay.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.modulea.FilterActivity;
import com.zgtech.funplay.activity.modulea.GuiderQueryActivity;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.fragment.childFragment.CertifyFragment;
import com.zgtech.funplay.fragment.childFragment.HighBeautyFragment;
import com.zgtech.funplay.fragment.childFragment.NearbyFragment;
import com.zgtech.funplay.fragment.childFragment.NewPersonFragment;
import com.zgtech.funplay.fragment.childFragment.RecommendFragment;
import com.zgtech.funplay.utils.L;

import butterknife.ButterKnife;

/**
 * 首页模块
 * Created by Administrator on 2017/8/1.
 */

public class HomeFragment extends BaseFragment {
    private ViewPager viewPager;
    private PagerSlidingTabStrip tabs;
    private ImageView ivHeader;
    private EditText etSeek;
    private RelativeLayout rlSeek;
    private TextView tvSeek;

    private RecommendFragment recommendFragment;
    private NewPersonFragment newPersonFragment;
    private HighBeautyFragment highBeautyFragment;
    private NearbyFragment nearbyFragment;
    private CertifyFragment certifyFragment;
    private MyPagerAdapter adapter;
    private TextView tvFilter;
    private Toolbar toolbar;
    private TextView tvCity;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        initData();
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.i("HomeFragment", "onDestroy");
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initStatusBar();

        initTop(view);
        initViewPager(view);
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void initTop(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        etSeek = (EditText) view.findViewById(R.id.et_seek);
        rlSeek = (RelativeLayout) view.findViewById(R.id.re_search);
        tvSeek = (TextView) view.findViewById(R.id.tv_search);
        tvCity = (TextView) view.findViewById(R.id.tv_city);
        tvFilter = (TextView) view.findViewById(R.id.tv_filter);

        initEditTextChangeListener(rlSeek, tvSeek, etSeek);
        initSearchBoxClick(rlSeek, etSeek);
        initTopClickListener();
    }

    private void initTopClickListener() {
        tvFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, FilterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViewPager(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        tabs = (PagerSlidingTabStrip) view.findViewById(R.id.tabs);
        ivHeader = (ImageView) view.findViewById(R.id.iv_header);

        adapter = new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        initTabs(viewPager);
    }

    @Override
    protected void initData() {

    }

    private void initEditTextChangeListener(final RelativeLayout re_search, final TextView tv_search, final EditText et_search) {
        et_search.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    re_search.setVisibility(View.VISIBLE);
                    tv_search.setText(et_search.getText().toString().trim());
                } else {
                    re_search.setVisibility(View.GONE);
                    tv_search.setText("");
                }

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            public void afterTextChanged(Editable s) {

            }
        });
    }


    private void initSearchBoxClick(RelativeLayout re_search, final EditText et_search) {
        re_search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String title = et_search.getText().toString();

                Intent intent = new Intent(mActivity, GuiderQueryActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });

        re_search.setVisibility(View.GONE);
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
                        ivHeader.setVisibility(View.VISIBLE);
                        toolbar.setBackgroundColor(Color.TRANSPARENT);
                        tvCity.setTextColor(Color.WHITE);
                        tvFilter.setTextColor(Color.WHITE);
                        etSeek.setHintTextColor(Color.WHITE);

                        if (Build.VERSION.SDK_INT >= 21) {
                            View decorView = mActivity.getWindow().getDecorView();
                            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                            decorView.setSystemUiVisibility(option);
                            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
                        }
                        break;
                    case 1:
                        ivHeader.setVisibility(View.GONE);
                        toolbar.setBackgroundColor(Color.WHITE);
                        tvCity.setTextColor(Color.BLACK);
                        tvFilter.setTextColor(Color.BLACK);
                        etSeek.setHintTextColor(Color.GRAY);

                        if (Build.VERSION.SDK_INT >= 21) {
                            View decorView = mActivity.getWindow().getDecorView();
                            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                            decorView.setSystemUiVisibility(option);
//                            mActivity.getWindow().setStatusBarColor(Color.argb(255,229,33,61));
                            mActivity.getWindow().setStatusBarColor(Color.BLACK);
                        }
                        break;
                    case 2:
                        ivHeader.setVisibility(View.GONE);
                        toolbar.setBackgroundColor(Color.WHITE);
                        tvCity.setTextColor(Color.BLACK);
                        tvFilter.setTextColor(Color.BLACK);
                        etSeek.setHintTextColor(Color.GRAY);

                        if (Build.VERSION.SDK_INT >= 21) {
                            View decorView = mActivity.getWindow().getDecorView();
                            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                            decorView.setSystemUiVisibility(option);
                            mActivity.getWindow().setStatusBarColor(Color.BLACK);
                        }
                        break;
                    case 3:
                        ivHeader.setVisibility(View.GONE);
                        toolbar.setBackgroundColor(Color.WHITE);
                        tvCity.setTextColor(Color.BLACK);
                        tvFilter.setTextColor(Color.BLACK);
                        etSeek.setHintTextColor(Color.GRAY);

                        if (Build.VERSION.SDK_INT >= 21) {
                            View decorView = mActivity.getWindow().getDecorView();
                            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                            decorView.setSystemUiVisibility(option);
                            mActivity.getWindow().setStatusBarColor(Color.BLACK);
                        }
                        break;
                    case 4:
                        ivHeader.setVisibility(View.GONE);
                        toolbar.setBackgroundColor(Color.WHITE);
                        tvCity.setTextColor(Color.BLACK);
                        tvFilter.setTextColor(Color.BLACK);
                        etSeek.setHintTextColor(Color.GRAY);

                        if (Build.VERSION.SDK_INT >= 21) {
                            View decorView = mActivity.getWindow().getDecorView();
                            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                            decorView.setSystemUiVisibility(option);
                            mActivity.getWindow().setStatusBarColor(Color.BLACK);
                        }
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

        private final String[] TITLES = {"推荐", "新人", "高颜值", "附近", "已认证"};

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
                    return recommendFragment == null ? RecommendFragment.newInstance() : recommendFragment;
                case 1:
                    return newPersonFragment == null ? NewPersonFragment.newInstance() : newPersonFragment;
                case 2:
                    return highBeautyFragment == null ? HighBeautyFragment.newInstance() : highBeautyFragment;
                case 3:
                    return nearbyFragment == null ? NearbyFragment.newInstance() : nearbyFragment;
                case 4:
                    return certifyFragment == null ? CertifyFragment.newInstance() : certifyFragment;
                default:
                    return recommendFragment == null ? RecommendFragment.newInstance() : recommendFragment;
            }
        }

    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

}
