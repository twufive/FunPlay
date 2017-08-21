package com.zgtech.funplay.adapter;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.model.PinTuanAllModel;

import java.util.List;

/**
 * 我的拼团(全部)   适配器
 * Created by Administrator on 2017/8/3.
 */

public class PinTuanAllAdapter extends BaseQuickAdapter<PinTuanAllModel, BaseViewHolder> {
    private Activity act;

    public PinTuanAllAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<PinTuanAllModel> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, PinTuanAllModel individualModel) {
        ImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvTime = helper.getView(R.id.tv_time);
        TextView tvPrice = helper.getView(R.id.tv_price);
        TextView tvState = helper.getView(R.id.tv_state);
        TextView tvBtn = helper.getView(R.id.tv_btn);

        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(individualModel.getSiteUrl())
                .into(ivSite);

        tvTitle.setText(individualModel.getTitle());
        tvTime.setText("下单时间:" + individualModel.getTime());
        tvPrice.setText("总价:￥" + individualModel.getPrice());
        tvState.setText(individualModel.getState());
        tvBtn.setText("再来一单");
    }
}
