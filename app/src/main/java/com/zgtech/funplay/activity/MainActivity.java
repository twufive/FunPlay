package com.zgtech.funplay.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.center.PinTuanTogetherActivity;
import com.zgtech.funplay.fragment.FindFragment;
import com.zgtech.funplay.fragment.HomeFragment;
import com.zgtech.funplay.fragment.MessageFragment;
import com.zgtech.funplay.fragment.MineFragment;
import com.zgtech.funplay.utils.LogUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    @Bind(R.id.frame_container)
    FrameLayout frameContainer;
    @Bind(R.id.bnb_main)
    BottomNavigationBar bnbMain;
    @Bind(R.id.iv_tab_post)
    ImageView ivTabPost;

    private HomeFragment homeFragment;
    private MessageFragment messageFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private int NOW_FRAGMENT;
    private boolean popupWindowIsShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ivTabPost.bringToFront();
        initTabBottom();
        initTabListener(NOW_FRAGMENT);
    }


    private void initTabBottom() {
        bnbMain.setMode(BottomNavigationBar.MODE_FIXED);
        bnbMain.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bnbMain.addItem(new BottomNavigationItem(R.drawable.icon_tab_a, "首页").setActiveColorResource(R.color.colorPrimary));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.icon_tab_b, "消息").setActiveColorResource(R.color.colorPrimary));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.icon_white, "").setActiveColorResource(R.color.white).setInActiveColorResource(R.color.white));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.icon_tab_c, "旅游圈").setActiveColorResource(R.color.colorPrimary));
        bnbMain.addItem(new BottomNavigationItem(R.drawable.icon_tab_d, "我的").setActiveColorResource(R.color.colorPrimary));
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
                        /**这里是中间的那个红色按钮噢*/
                        LogUtils.i("tabCenterClick", "true");
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
        }
    }

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

        initPoPClicks(pop,popView);
    }

    private void initPoPClicks(final PopupWindow pop, View popView) {
        CardView cardPinTuan = (CardView) popView.findViewById(R.id.cardview_pintuan);
        CardView cardDiqiu = (CardView) popView.findViewById(R.id.cardview_diqiu);

        LinearLayout llSeekGuider = (LinearLayout) popView.findViewById(R.id.ll_seek_guider);
        LinearLayout llPinTuan = (LinearLayout) popView.findViewById(R.id.ll_pintuan_together);
        LinearLayout llDiqiu = (LinearLayout) popView.findViewById(R.id.ll_play_diqiu);

        ImageView ivPostPop = (ImageView) popView.findViewById(R.id.iv_tab_post_pop);

        ivPostPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });

        cardPinTuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.i("cardPinTuanhahhahhah");

                Intent intent = new Intent(MainActivity.this, PinTuanTogetherActivity.class);
                startActivity(intent);

                pop.dismiss();

//                pop.setAnimationStyle();
            }
        });

        llPinTuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LogUtils.i("llPinTuanhahhahhah");
            }
        });
    }

    /**
     * 获取状态通知栏高度
     *
     * @param activity
     * @return
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect frame = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        Log.d(TAG, "statusBarHeight:" + frame.top + "px");
        return frame.top;
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
        } else {

        }
    }
}
