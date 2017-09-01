package com.zgtech.funplay.fragment;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.QuickAdapter;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.model.FriendTalkModel;
import com.zgtech.funplay.utils.L;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 旅游圈模块
 * Created by Administrator on 2017/8/1.
 */

public class FindFragment extends BaseFragment {
    @Bind(R.id.iv_right)
    ImageView ivRight;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;
    private List<FriendTalkModel> originList;
    private QuickAdapter quickAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
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
        L.i("FindFragment", "onDestroy");
    }


    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initStausBar();


        quickAdapter = new QuickAdapter(getActivity(), R.layout.fp_item_social_main, originList);
        recyclerview.setLayoutManager(new LinearLayoutManager(FunPlayApplication.getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerview.setAdapter(quickAdapter);
    }

    private void initStausBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void initData() {
        originList = new ArrayList<FriendTalkModel>();
        FriendTalkModel individualModel = new FriendTalkModel();
        individualModel.setAvatarUrl("http://www.qqtu8.net/f/20140603131718.jpg");
        individualModel.setTitle("桂林*荔枝");
        individualModel.setContent("雨洗刷不掉我对你的思念，风吹走不掉我对你的爱恋。这次在桂林玩得很开心，希望以后还有机会可以来这里玩。桂林山水甲天下名不虚传！");
        individualModel.setFriendTalkPics("http://image5.tuku.cn/pic/wallpaper/fengjing/daziranshenqishanshuifengjingbizhi/012.jpg,http://img.taopic.com/uploads/allimg/140826/267848-140R60T34860.jpg,http://pic36.nipic.com/20131203/3822951_101052690000_2.jpg,http://pic36.nipic.com/20131203/3822951_101052690000_2.jpg,http://image5.tuku.cn/pic/wallpaper/fengjing/daziranshenqishanshuifengjingbizhi/012.jpg,http://img.taopic.com/uploads/allimg/140826/267848-140R60T34860.jpg,http://img.taopic.com/uploads/allimg/140826/267848-140R60T34860.jpg,http://img.taopic.com/uploads/allimg/140826/267848-140R60T34860.jpg,http://pic36.nipic.com/20131203/3822951_101052690000_2.jpg");
        individualModel.setSign("桂林三日游，900元/5人");

        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
    }

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    @OnClick(R.id.iv_right)
    public void onViewClicked() {
    }
}
