package com.zgtech.funplay.activity;

import android.content.Intent;
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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.greendao.gen.DaoMaster;
import com.zgtech.funplay.greendao.gen.DaoSession;
import com.zgtech.funplay.greendao.gen.HxUserModelDao;
import com.zgtech.funplay.model.HxUserModel;
import com.zgtech.funplay.model.UserDetailModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.FunPlayUtils;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 我的主页
 * Created by Administrator on 2017/8/14.
 */

public class CoreUserDetailPageActivity extends BaseActivity {
    @Bind(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;
    @Bind(R.id.tabs)
    PagerSlidingTabStrip tabs;
    @Bind(R.id.viewpager)
    ViewPager viewpager;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_deal_count)
    TextView tvDealCount;
    @Bind(R.id.tv_certify)
    TextView tvCertify;
    @Bind(R.id.tv_job)
    TextView tvJob;
    @Bind(R.id.tv_sex)
    TextView tvSex;
    @Bind(R.id.tv_height)
    TextView tvHeight;
    @Bind(R.id.tv_constellation)
    TextView tvConstellation;
    @Bind(R.id.tv_service_site)
    TextView tvServiceSite;
    @Bind(R.id.tv_sign)
    TextView tvSign;
    @Bind(R.id.tv_introduce)
    TextView tvIntroduce;
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.fl_send_msg)
    FrameLayout flSendMsg;
    @Bind(R.id.btn_send_msg)
    Button btnSendMsg;

    private MyPagerAdapter adapter;
    private TaStoryFragment taStoryFragment;
    private TaPinTuanFragment taPinTuanFragment;
    private String userId = "";
    private boolean isMyself = false;
    private UserDetailModel.ObjBean individualModel;

    private DaoMaster.DevOpenHelper devOpenHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core_user_detail);
        ButterKnife.bind(this);


        userId = getIntent().getExtras().getString("userId", "12");
        isMyself = getIntent().getBooleanExtra("isMyself", false);
        initData();
        initView();
    }

    @Override
    public void initView() {
        initStatusBarState();
        adapter = new MyPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        initTabs(viewpager);

        if (isMyself) {
            flSendMsg.setVisibility(View.GONE);
        }
    }

    @Override
    public void initData() {
        mApiStores.getUserDetailData(userId).enqueue(new Callback<UserDetailModel>() {
            @Override
            public void onResponse(Call<UserDetailModel> call, Response<UserDetailModel> response) {
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

            private void handleServerData(UserDetailModel model) {
                individualModel = model.getObj();
                initElementView(individualModel);

                devOpenHelper = new DaoMaster.DevOpenHelper(CoreUserDetailPageActivity.this, "zayin.db", null);
                DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
                DaoSession daoSession = daoMaster.newSession();
                HxUserModelDao hxUserModelDao = daoSession.getHxUserModelDao();

                HxUserModel hxUserModel = new HxUserModel();
                hxUserModel.setImUser(individualModel.getImUser());
                hxUserModel.setUserId(individualModel.getUserId() + "");
                hxUserModel.setHxNickname(individualModel.getUserNick());
                hxUserModel.setHxAvatar(ApiStores.API_SERVER_URL + individualModel.getUserIcon());
                hxUserModelDao.insertOrReplace(hxUserModel);
            }

            @Override
            public void onFailure(Call<UserDetailModel> call, Throwable t) {

            }
        });
    }

    private void initElementView(UserDetailModel.ObjBean individualModel) {
        tvName.setText(individualModel.getUserNick() + "");
        tvCertify.setText(individualModel.getStateIdent() == 0 ? "未认证" : "已认证");
        tvDealCount.setText("成交" + individualModel.getTransactionCount() + "" + "笔");
        tvJob.setText(individualModel.getStateIdentJob() + "");
        tvSex.setText(individualModel.getUserSex() == 1 ? "男" : "女");
        tvHeight.setText(individualModel.getUserHeight() + "cm");
        tvConstellation.setText(FunPlayUtils.code2StrConstellation(individualModel.getUserConstellation()));
        tvServiceSite.setText(individualModel.getServiceAddress());
        tvSign.setText(individualModel.getUserSign());
        tvIntroduce.setText(individualModel.getUserRemark());
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

    @OnClick({R.id.ll_back, R.id.tv_right, R.id.btn_send_msg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.tv_right:
                break;
            case R.id.btn_send_msg:
                L.i("btn_send_msg_imUser", "ec13742d26");

                Intent intent = new Intent(CoreUserDetailPageActivity.this, ChatActivity.class);
                intent.putExtra("imUser", "6c01daea76");
                startActivity(intent);
                break;
        }
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
