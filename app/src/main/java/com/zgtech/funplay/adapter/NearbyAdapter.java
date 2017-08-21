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
import com.zgtech.funplay.model.NearbyModel;

import java.util.List;

/**
 * 附近   适配器
 * Created by Administrator on 2017/8/3.
 */

public class NearbyAdapter extends BaseQuickAdapter<NearbyModel, BaseViewHolder> {
    private Activity act;

    public NearbyAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<NearbyModel> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, NearbyModel individualModel) {
        ImageView ivAvatar = helper.getView(R.id.iv_avatar);
        TextView tvNick = helper.getView(R.id.tv_nick);
        TextView tvPrice = helper.getView(R.id.tv_price);
        CardView cardview = helper.getView(R.id.cardview);

        ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(individualModel.getImgUrl())
                .into(ivAvatar);

        tvNick.setText(individualModel.getNick());
        tvPrice.setText("￥" + individualModel.getPrice() + "/时");


        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act, CoreUserPageActivity.class);
                act.startActivity(intent);
            }
        });
    }
}
