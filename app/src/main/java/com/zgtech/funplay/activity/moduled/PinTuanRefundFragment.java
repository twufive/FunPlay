package com.zgtech.funplay.activity.moduled;

import android.os.Bundle;
import android.view.View;

import com.zgtech.funplay.base.BaseFragment;

/**
 * 我的拼团，退款/售后fragment
 * Created by Administrator on 2017/8/16.
 */

public class PinTuanRefundFragment extends BaseFragment {
    @Override
    protected void initView(View view, Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {

    }
//    @Bind(R.id.recyclerview)
//    RecyclerView recyclerview;
//
//    private PinTuanRefundAdapter adapter;
//    private List<PinTuanAllModel> originList;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_pintuan_refund, container, false);
//        ButterKnife.bind(this, view);
//
//        initData();
//        initView(view, savedInstanceState);
//        return view;
//
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        ButterKnife.unbind(this);
//    }
//
//    @Override
//    protected void initView(View view, Bundle savedInstanceState) {
//        adapter = new PinTuanRefundAdapter(mActivity, R.layout.fp_item_pintuan_all, originList);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
//        recyclerview.setLayoutManager(linearLayoutManager);
//        recyclerview.setAdapter(adapter);
//    }
//
//    @Override
//    protected void initData() {
//        originList = new ArrayList<PinTuanAllModel>();
//
//        PinTuanAllModel pinTuanAllModel = new PinTuanAllModel();
//        pinTuanAllModel.setSiteUrl("http://img1.imgtn.bdimg.com/it/u=3703540791,4182251432&fm=26&gp=0.jpg");
//        pinTuanAllModel.setState("已退款");
//        pinTuanAllModel.setPrice("88");
//        pinTuanAllModel.setTime("2017-08-17 10:09");
//        pinTuanAllModel.setTitle("靖港古镇三日游");
//
//        originList.add(pinTuanAllModel);
//        originList.add(pinTuanAllModel);
//        originList.add(pinTuanAllModel);
//        originList.add(pinTuanAllModel);
//        originList.add(pinTuanAllModel);
//        originList.add(pinTuanAllModel);
//        originList.add(pinTuanAllModel);
//        originList.add(pinTuanAllModel);
//    }
//
//    public static PinTuanRefundFragment newInstance() {
//        PinTuanRefundFragment fragment = new PinTuanRefundFragment();
//        return fragment;
//    }
}
