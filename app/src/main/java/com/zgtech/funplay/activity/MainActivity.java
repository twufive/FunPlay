package com.zgtech.funplay.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.tabcenter.PinTuanTogetherActivity;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.fragment.FindFragment;
import com.zgtech.funplay.fragment.HomeFragment;
import com.zgtech.funplay.fragment.MessageFragment;
import com.zgtech.funplay.fragment.MineFragment;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.P;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zgtech.funplay.utils.ActivityCollectorUtils.finishAll;

public class MainActivity extends BaseActivity {
    @Bind(R.id.frame_container)
    FrameLayout frameContainer;
    @Bind(R.id.bnb_main)
    BottomNavigationBar bnbMain;
    @Bind(R.id.iv_tab_post)
    ImageView ivTabPost;

    String[] permissions = new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.RECORD_AUDIO};
    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private boolean popupWindowIsShow = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        P.initPerMissions(this, permissions);
        initData();
        initView();
    }

    @Override
    public void initView() {
        int NOW_FRAGMENT = getIntent().getIntExtra("whichFragment", 0);
        ivTabPost.bringToFront();

        initTabBottom();
        initTabListener(NOW_FRAGMENT);
    }

    @Override
    public void initData() {

    }


    private void initTabBottom() {
        bnbMain.setMode(BottomNavigationBar.MODE_FIXED);
        bnbMain.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bnbMain.addItem(new BottomNavigationItem(R.drawable.ic_home_black_24dp, "首页").setActiveColorResource(R.color.colorPrimary));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.ic_message_black_24dp, "消息").setActiveColorResource(R.color.colorPrimary));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.icon_white, "").setActiveColorResource(R.color.white).setInActiveColorResource(R.color.white));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.ic_friend_circle, "旅游圈").setActiveColorResource(R.color.colorPrimary));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.ic_person_black_24dp, "我的").setActiveColorResource(R.color.colorPrimary));
        bnbMain.initialise();
    }


    private void initTabListener(int NOW_FRAGMENT) {
        bnbMain.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                initTabSelect(position);
            }

            private void initTabSelect(int position) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                switch (position) {
                    case 0:
                        if (homeFragment == null) {
                            transaction.replace(R.id.frame_container, HomeFragment.newInstance());
                        } else {
                            transaction.replace(R.id.frame_container, homeFragment);
                        }
                        break;
                    case 1:
                        if (messageFragment == null) {
                            transaction.replace(R.id.frame_container, MessageFragment.newInstance());
                        } else {
                            transaction.replace(R.id.frame_container, messageFragment);
                        }
                        break;
                    case 2:
                        L.i("tabCenterClick", "true");
                        break;
                    case 3:
                        if (findFragment == null) {
                            transaction.replace(R.id.frame_container, FindFragment.newInstance());
                        } else {
                            transaction.replace(R.id.frame_container, findFragment);
                        }
                        break;
                    case 4:
                        if (mineFragment == null) {
                            transaction.replace(R.id.frame_container, MineFragment.newInstance());
                        } else {
                            transaction.replace(R.id.frame_container, mineFragment);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        bnbMain.selectTab(NOW_FRAGMENT);
    }


    @OnClick({R.id.iv_tab_post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_tab_post:
                popupWindowIsShow = true;
                showPop();
                break;
            default:
                break;
        }
    }

    /**
     * 点击加号弹窗的窗口
     */
    private void showPop() {
        View popView = getLayoutInflater().inflate(R.layout.pop_tab_post, null);
        final PopupWindow pop = new PopupWindow(popView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT, true);
        pop.setBackgroundDrawable(new ColorDrawable(Color.argb(200, 41, 41, 41)));//支持点击Back虚拟键退出
//                pop.showAtLocation(frameContainer, Gravity.NO_GRAVITY, 0, getStatusBarHeight(this));
        pop.setAnimationStyle(R.style.PopupAnimation);
        pop.showAtLocation(frameContainer, Gravity.NO_GRAVITY, 0, 0);
        pop.update();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.BLACK);
        }

        initPoPClicks(pop, popView);
    }

    /**
     * 初始化点击中间加号弹出窗口的点击事件
     * @param pop 窗口
     * @param popView 视图
     */
    private void initPoPClicks(final PopupWindow pop, View popView) {
        // 新闻界面
        CardView cvPopNews = (CardView) popView.findViewById(R.id.cv_pop_news);
        cvPopNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, PinTuanTogetherActivity.class);
            }
        });

        // 系统公告
        CardView cvPopPost = (CardView) popView.findViewById(R.id.cv_pop_post);
        cvPopPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, CoreWanZhuanDiQiuActivity.class);
            }
        });

        // 寻找当地人
        LinearLayout llFindLocal = (LinearLayout) popView.findViewById(R.id.ll_pop_find_local);
        llFindLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
                bnbMain.selectTab(0);
            }
        });

        // 结伴出游
        LinearLayout llTravelTogether = (LinearLayout) popView.findViewById(R.id.ll_pop_travel_together);
        llTravelTogether.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, PinTuanTogetherActivity.class);
            }
        });

        // 系统公告
        LinearLayout llPopPost = (LinearLayout) popView.findViewById(R.id.ll_pop_post);
        llPopPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, CoreWanZhuanDiQiuActivity.class);
            }
        });


        ImageView ivPostPop = (ImageView) popView.findViewById(R.id.iv_tab_post_pop);
        ivPostPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });



    }

    private void toTargetActivity(PopupWindow pop, Class targetActivity) {
        Intent intent = new Intent(MainActivity.this, targetActivity);
        startActivity(intent);
        pop.dismiss();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (popupWindowIsShow) {
            popupWindowIsShow = false;
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                decorView.setSystemUiVisibility(option);
                getWindow().setStatusBarColor(Color.TRANSPARENT);
            }
        }
    }

    private long exitTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            // 判断是否在两秒之内连续点击返回键，是则退出，否则不退出
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出趣玩", Toast.LENGTH_SHORT).show();
                // 将系统当前的时间赋值给exitTime
                exitTime = System.currentTimeMillis();
            } else {
                finishAll();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
