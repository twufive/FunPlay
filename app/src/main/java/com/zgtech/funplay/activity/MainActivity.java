package com.zgtech.funplay.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
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

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zgtech.funplay.FunPlayApplication.mContext;

public class MainActivity extends BaseActivity {
    private static String TAG = "MainActivity";
    private static final int REQUEST_CODE = 100;
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

        initPermission();

        initData();
        initView();
    }

    @Override
    public void initView() {
        NOW_FRAGMENT = getIntent().getIntExtra("whichFragment", 0);
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

        initPoPClicks(pop, popView);
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

        //进入一起拼团体系页面
        cardPinTuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, PinTuanTogetherActivity.class);
            }
        });

        llPinTuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, PinTuanTogetherActivity.class);
            }
        });


        //进入玩赚地球体系页面
        cardDiqiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, CoreWanZhuanDiQiuActivity.class);
            }
        });

        llDiqiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toTargetActivity(pop, CoreWanZhuanDiQiuActivity.class);
            }
        });


    }

    private void toTargetActivity(PopupWindow pop, Class targetActivity) {
        Intent intent = new Intent(MainActivity.this, targetActivity);
        startActivity(intent);
        pop.dismiss();
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

    private void initPermission() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.CAMERA)) {
                Log.i(TAG, "拒绝过了");
                Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的拍照授权开启拍照功能。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
            }
        } else {
            Log.i(TAG, "不需要授权 ");
        }


        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                Log.i(TAG, "拒绝过了");
                Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的储存授权开启相册功能。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE);
            }
        } else {
            Log.i(TAG, "不需要授权 ");
        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "需要授权 ");
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.RECORD_AUDIO)) {
                Log.i(TAG, "拒绝过了");
                Toast.makeText(mContext, "请在 设置-应用管理 中开启此应用的录音授权开启语音聊天功能。", Toast.LENGTH_SHORT).show();
            } else {
                Log.i(TAG, "进行授权");
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, REQUEST_CODE);
            }
        } else {
            Log.i(TAG, "不需要授权 ");
        }
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
