package com.zgtech.funplay.activity.center;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zgtech.funplay.R;
import com.zgtech.funplay.adapter.PinTuanCoreAdapter;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.model.PinTuanCoreModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PinTuanTogetherActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_right)
    ImageView ivRight;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    private PinTuanCoreAdapter adapter;
    private List<PinTuanCoreModel> originList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pintuan_together);
        ButterKnife.bind(this);
        initData();
        initView();
    }

    @Override
    public void initView() {
        llBack.setVisibility(View.VISIBLE);
//        ivRight.setVisibility(View.VISIBLE);
        tvToolbar.setText("一起拼团");
//        ivRight.setBackgroundResource(R.drawable.ic_add_white_24dp);
//        ivRight.setImageResource(R.drawable.icon_arrow_right);


        adapter = new PinTuanCoreAdapter(this, R.layout.fp_item_pintuan_together, originList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(linearLayoutManager);
        recyclerview.setAdapter(adapter);
    }

    @Override
    public void initData() {

        originList = new ArrayList<PinTuanCoreModel>();

        PinTuanCoreModel individualModel = new PinTuanCoreModel();
//        individualModel.setSiteUrl("http://img1.imgtn.bdimg.com/it/u=3703540791,4182251432&fm=26&gp=0.jpg");
        individualModel.setSiteUrl("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1308834482,4094457384&fm=26&gp=0.jpg");
        individualModel.setTitle("长沙火宫殿+橘子洲+岳麓山+天心阁+湖南第一师范一日游【纯玩再升级】");
        individualModel.setScore("4.6");
        individualModel.setPrice("59");
        individualModel.setPriceOld("240");
        individualModel.setTuanCountAll("5");
        individualModel.setTuanCountNow("4");


        originList.add(individualModel);
        originList.add(individualModel);
        originList.add(individualModel);
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
}
