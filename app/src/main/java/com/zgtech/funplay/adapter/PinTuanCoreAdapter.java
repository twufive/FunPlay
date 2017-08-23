package com.zgtech.funplay.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CorePinTuanTogetherActivity;
import com.zgtech.funplay.model.PinTuanCoreModel;

import java.util.List;

/**
 * 一起拼团(大厅核心页面)
 * Created by Administrator on 2017/8/3.
 */

public class PinTuanCoreAdapter extends BaseQuickAdapter<PinTuanCoreModel, BaseViewHolder> {
    private Activity act;

    public PinTuanCoreAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<PinTuanCoreModel> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, PinTuanCoreModel individualModel) {
        ImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvScore = helper.getView(R.id.tv_score);
        TextView tvPrice = helper.getView(R.id.tv_price);
        TextView tvPriceOld = helper.getView(R.id.tv_price_old);
        Button btnRush = helper.getView(R.id.btn_rush);
        Button btnCountAll = helper.getView(R.id.btn_count_all);
        TextView tvCountNow = helper.getView(R.id.tv_count_now);

        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(individualModel.getSiteUrl())
                .into(ivSite);

        tvTitle.setText(individualModel.getTitle());
        tvScore.setText(individualModel.getScore()+"分");
        tvPrice.setText("￥" + individualModel.getPrice());
        tvPriceOld.setText("￥" + individualModel.getPriceOld());
        btnCountAll.setText(individualModel.getTuanCountAll() + "人团");
        tvCountNow.setText("已团" + individualModel.getTuanCountNow() + "人");

        tvPriceOld.getPaint().setFlags(Paint. STRIKE_THRU_TEXT_FLAG); //中划线

        btnRush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act, CorePinTuanTogetherActivity.class);
                act.startActivity(intent);
            }
        });

    }
}
