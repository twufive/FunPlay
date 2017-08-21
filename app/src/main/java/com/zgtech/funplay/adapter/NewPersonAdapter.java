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
import com.zgtech.funplay.model.NewPersonModel;

import java.util.List;

/**
 * 新人   适配器
 * Created by Administrator on 2017/8/3.
 */

public class NewPersonAdapter extends BaseQuickAdapter<NewPersonModel, BaseViewHolder> {
    private Activity act;

    public NewPersonAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<NewPersonModel> data) {
        super(layoutResId, data);
        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, NewPersonModel individualModel) {
        ImageView ivAvatar = helper.getView(R.id.iv_avatar);
        ImageView ivStar = helper.getView(R.id.iv_star);
        ImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvNick = helper.getView(R.id.tv_nick);
        TextView tvDeal = helper.getView(R.id.tv_deal);
        TextView tvScore = helper.getView(R.id.tv_score);
        TextView tvPrice = helper.getView(R.id.tv_price);

//        ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        Glide.with(FunPlayApplication.getContext())
//                .load(individualModel.getAvatarImgUrl())
//                .into(ivAvatar);
        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(individualModel.getSiteImgUrl())
                .into(ivSite);

        tvNick.setText(individualModel.getNick());
        tvDeal.setText(individualModel.getDeal() + "笔成交");
        tvScore.setText("评分：" + individualModel.getScore());
        tvPrice.setText("￥" + individualModel.getPrice() + "/时");

    }
}
