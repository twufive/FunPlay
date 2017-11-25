package com.zgtech.funplay.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyDialogListener;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CoreUserDetailPageActivity;
import com.zgtech.funplay.activity.moduled.MyCertifyActivity;
import com.zgtech.funplay.activity.moduled.MyCollectActivity;
import com.zgtech.funplay.activity.moduled.MyInfoActivity;
import com.zgtech.funplay.activity.moduled.MyOrderActivity;
import com.zgtech.funplay.activity.moduled.MyPinTuanActivity;
import com.zgtech.funplay.activity.moduled.MyPwdActivity;
import com.zgtech.funplay.activity.moduled.MyReportActivity;
import com.zgtech.funplay.activity.moduled.MySuggestActivity;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.greendao.gen.DaoMaster;
import com.zgtech.funplay.greendao.gen.DaoSession;
import com.zgtech.funplay.greendao.gen.HxUserModelDao;
import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.HxUserModel;
import com.zgtech.funplay.model.MineExternalModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.retrofit.RequestBodyBuilder;
import com.zgtech.funplay.utils.ActivityCollectorUtils;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.SP;
import com.zgtech.funplay.utils.T;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 个人中心模块
 * Created by Administrator on 2017/8/1.
 */

public class MineFragment extends BaseFragment {
    @Bind(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @Bind(R.id.tv_nick)
    TextView tvNick;
    @Bind(R.id.tv_sign)
    TextView tvSign;
    @Bind(R.id.tv_care)
    TextView tvCare;
    @Bind(R.id.tv_fans)
    TextView tvFans;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.appBar)
    AppBarLayout appBar;
    @Bind(R.id.rl_order)
    RelativeLayout rlOrder;
    @Bind(R.id.rl_pintuan)
    RelativeLayout rlPinTuan;
    @Bind(R.id.rl_info)
    RelativeLayout rlInfo;
    @Bind(R.id.rl_page)
    RelativeLayout rlPage;
    @Bind(R.id.rl_mine_collect)
    RelativeLayout rlMineCollect;
    @Bind(R.id.rl_mine_suggestion)
    RelativeLayout rlMineSuggestion;
    @Bind(R.id.rl_certify)
    RelativeLayout rlCertify;
    @Bind(R.id.rl_report)
    RelativeLayout rlReport;
    @Bind(R.id.rl_pwd)
    RelativeLayout rlPwd;
    @Bind(R.id.rl_logout)
    RelativeLayout rlLogout;
    private String userId;

    private DaoMaster.DevOpenHelper devOpenHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        ButterKnife.bind(this, view);

        devOpenHelper = new DaoMaster.DevOpenHelper(mActivity, "zayin.db", null);

        userId = SP.getString(mActivity, "userId", "");
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
        L.i("MineFragment", "onDestroy");

        devOpenHelper.close();
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initStatusBarState();
    }

    private void initStatusBarState() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void initData() {
        initMyInfo();
    }

    private void initMyInfo() {
        mApiStores.getMyExternalInfoData("true", userId).enqueue(new Callback<MineExternalModel>() {
            @Override
            public void onResponse(Call<MineExternalModel> call, Response<MineExternalModel> response) {
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

            private void handleServerData(MineExternalModel model) {
                MineExternalModel.ObjBean obj = model.getObj();
                initElementView(obj);
            }

            @Override
            public void onFailure(Call<MineExternalModel> call, Throwable t) {

            }
        });
    }

    private void initElementView(MineExternalModel.ObjBean individualModel) {
        Glide.with(mActivity)
                .load(ApiStores.API_SERVER_URL + individualModel.getUserIcon())
                .into(ivAvatar);


        tvNick.setText(individualModel.getUserNick());
        tvSign.setText(individualModel.getUserSign());
        tvCare.setText("关注  " + individualModel.getUserHotCount() + "");
        tvFans.setText("粉丝  " + individualModel.getUserCollectionCount() + "");



        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        HxUserModelDao hxUserModelDao = daoSession.getHxUserModelDao();

        String myImUser = SP.getString(mActivity, "myImUser", "");

        HxUserModel hxUserModel = new HxUserModel();
        hxUserModel.setImUser(myImUser);
        hxUserModel.setUserId(individualModel.getUserId() + "");
        hxUserModel.setHxNickname(individualModel.getUserNick());
        hxUserModel.setHxAvatar(ApiStores.API_SERVER_URL + individualModel.getUserIcon());
        hxUserModelDao.insertOrReplace(hxUserModel);
    }

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }


    @OnClick({R.id.iv_avatar, R.id.tv_nick, R.id.tv_sign, R.id.tv_care, R.id.tv_fans, R.id.rl_order, R.id.rl_pintuan, R.id.rl_info, R.id.rl_page, R.id.rl_mine_collect, R.id.rl_mine_suggestion, R.id.rl_certify, R.id.rl_report, R.id.rl_pwd, R.id.rl_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_avatar:
                break;
            case R.id.tv_nick:
                break;
            case R.id.tv_sign:
                break;
            case R.id.tv_care:
                break;
            case R.id.tv_fans:
                break;
            case R.id.rl_order:
                toNextActivity(MyOrderActivity.class);
                break;
            case R.id.rl_pintuan:
                toNextActivity(MyPinTuanActivity.class);
                break;
            case R.id.rl_info:
                toNextActivity(MyInfoActivity.class);
                break;
            case R.id.rl_page:
                SP.setString(mActivity, "otherUserId", userId);

                Intent intent = new Intent(mActivity, CoreUserDetailPageActivity.class);
                intent.putExtra("isMyself", true);
                intent.putExtra("userId", userId);
                mActivity.startActivity(intent);
                break;
            case R.id.rl_mine_collect:
                toNextActivity(MyCollectActivity.class);
                break;
            case R.id.rl_mine_suggestion:
                toNextActivity(MySuggestActivity.class);
                break;
            case R.id.rl_certify:
                toNextActivity(MyCertifyActivity.class);
                break;
            case R.id.rl_report:
                toNextActivity(MyReportActivity.class);
                break;
            case R.id.rl_pwd:
                toNextActivity(MyPwdActivity.class);
                break;
            case R.id.rl_logout:
                showLogoutDialog();
                break;
        }
    }

    private void showLogoutDialog() {
        StyledDialog.buildMdAlert("退出登录", "您确定要退出登录吗?", new MyDialogListener() {
            @Override
            public void onFirst() {
                String androidToken = SP.getString(mActivity, "androidToken", "");
                HashMap map = new HashMap();
                map.put("androidToken", androidToken);
                RequestBody body = RequestBodyBuilder.build(map);
                mApiStores.logout(body).enqueue(new Callback<BaseResultModel>() {
                    @Override
                    public void onResponse(Call<BaseResultModel> call, Response<BaseResultModel> response) {
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

                    private void handleServerData(BaseResultModel model) {
                        SP.setBoolean(mActivity, "isLogined", false);

                        ActivityCollectorUtils.finishAll();
                    }

                    @Override
                    public void onFailure(Call<BaseResultModel> call, Throwable t) {
                        T.showShort(t.toString());
                    }
                });
            }

            @Override
            public void onSecond() {

            }

            @Override
            public void onThird() {

            }
        })
                .setBtnSize(20)
                .setBtnText("确定", "取消", "")
                .show();
    }
}
