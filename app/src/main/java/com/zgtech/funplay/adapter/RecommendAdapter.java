package com.zgtech.funplay.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CoreUserPageActivity;
import com.zgtech.funplay.model.RecommendModel;

import java.util.List;

/**
 * 推荐   适配器
 * Created by Administrator on 2017/8/3.
 */

public class RecommendAdapter extends BaseQuickAdapter<RecommendModel, BaseViewHolder> {
    private Activity act;

    public RecommendAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<RecommendModel> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, RecommendModel individualModel) {
        ImageView ivAvatar = helper.getView(R.id.iv_avatar);
        ImageView ivStar = helper.getView(R.id.iv_star);
        ImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvSign = helper.getView(R.id.tv_sign);
        TextView tvRead = helper.getView(R.id.tv_read);
        CardView cardview = helper.getView(R.id.cardview);

//        ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        Glide.with(FunPlayApplication.getContext())
//                .load(individualModel.getAvatarImgUrl())
//                .into(ivAvatar);
        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(individualModel.getSiteImgUrl())
                .into(ivSite);

        tvSign.setText(individualModel.getSign());
        tvRead.setText(individualModel.getReadCount());

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act, CoreUserPageActivity.class);
                act.startActivity(intent);
            }
        });


    }
}
