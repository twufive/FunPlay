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
import com.zgtech.funplay.activity.CoreUserDetailPageActivity;
import com.zgtech.funplay.model.NearbyData;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.SP;

import java.util.List;

/**
 * 附近   适配器
 * Created by Administrator on 2017/8/3.
 */

public class NearbyAdapter extends BaseQuickAdapter<NearbyData.ObjBean, BaseViewHolder> {
    private Activity act;

    public NearbyAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<NearbyData.ObjBean> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, final NearbyData.ObjBean individualModel) {
        ImageView ivAvatar = helper.getView(R.id.iv_avatar);
        TextView tvNick = helper.getView(R.id.tv_nick);
        TextView tvPrice = helper.getView(R.id.tv_price);
        TextView tvTag0 = helper.getView(R.id.tv_tag0);
        TextView tvTag1 = helper.getView(R.id.tv_tag1);
        CardView cardview = helper.getView(R.id.cardview);

        ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);

        if (individualModel.getUserIcon() == null || individualModel.getUserIcon().equals("")) {
            cardview.setVisibility(View.GONE);
        } else {
            Glide.with(FunPlayApplication.getContext())
                    .load(ApiStores.API_SERVER_URL + individualModel.getUserIcon())
                    .into(ivAvatar);
        }



        tvNick.setText(individualModel.getUserNick());
        tvPrice.setText("￥" + individualModel.getAvgPrice() + "/时");
        tvTag0.setText(individualModel.getUserTag1() + "");
        tvTag1.setText(individualModel.getUserTag2() + "");


        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SP.setString(act, "otherUserId", individualModel.getUserId() + "");

                Intent intent = new Intent(act, CoreUserDetailPageActivity.class);
                intent.putExtra("userId", individualModel.getUserId() + "");
                act.startActivity(intent);
            }
        });
    }
}
