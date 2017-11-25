package com.zgtech.funplay.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CoreUserDetailPageActivity;
import com.zgtech.funplay.model.RecommendOther3Model;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.SP;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 新人   适配器
 * Created by Administrator on 2017/8/3.
 */

public class NewPersonAdapter extends BaseQuickAdapter<RecommendOther3Model.ObjBean, BaseViewHolder> {
    private Activity act;

    public NewPersonAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<RecommendOther3Model.ObjBean> data) {
        super(layoutResId, data);
        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, final RecommendOther3Model.ObjBean individualModel) {
        CircleImageView ivAvatar = helper.getView(R.id.iv_avatar);
        ImageView ivStar = helper.getView(R.id.iv_star);
        ImageView iv01 = helper.getView(R.id.iv_01);
        ImageView iv02 = helper.getView(R.id.iv_02);
        ImageView iv03 = helper.getView(R.id.iv_03);
        ImageView iv04 = helper.getView(R.id.iv_04);
        ImageView iv05 = helper.getView(R.id.iv_05);
        ImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvNick = helper.getView(R.id.tv_nick);
        TextView tvDeal = helper.getView(R.id.tv_deal);
        TextView tvTag0 = helper.getView(R.id.tv_tag0);
        TextView tvTag1 = helper.getView(R.id.tv_tag1);
        TextView tvScore = helper.getView(R.id.tv_score);
        TextView tvPrice = helper.getView(R.id.tv_price);
        CardView cardview = helper.getView(R.id.cardview);
        Button btnSeek = helper.getView(R.id.btn_seek);

        ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);

        Glide.with(FunPlayApplication.getContext())
                .load(ApiStores.API_SERVER_URL + individualModel.getUserIcon())
                .into(ivAvatar);


        if (individualModel.getOrders() != null && individualModel.getOrders().size() != 0) {
            Glide.with(FunPlayApplication.getContext())
                    .load(ApiStores.API_SERVER_URL + individualModel.getOrders().get(0).getOrderPicture1())
                    .into(ivSite);
        } else {
            //否则使用默认图片
//            cardview.setVisibility(View.GONE);
        }


        tvNick.setText(individualModel.getUserNick());
        tvDeal.setText(individualModel.getTransactionCount() + "笔成交");
        tvScore.setText("评分：" + individualModel.getAvgMark());
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

        btnSeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SP.setString(act, "otherUserId", individualModel.getUserId() + "");

                Intent intent = new Intent(act, CoreUserDetailPageActivity.class);
                intent.putExtra("userId", individualModel.getUserId() + "");
                act.startActivity(intent);
            }
        });



        switch (individualModel.getAvgMark()){
            case 5:
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.VISIBLE);
                iv03.setVisibility(View.VISIBLE);
                iv04.setVisibility(View.VISIBLE);
                iv05.setVisibility(View.VISIBLE);
                break;
            case 4:
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.VISIBLE);
                iv03.setVisibility(View.VISIBLE);
                iv04.setVisibility(View.VISIBLE);
                iv05.setVisibility(View.GONE);
                break;
            case 3:
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.VISIBLE);
                iv03.setVisibility(View.VISIBLE);
                iv04.setVisibility(View.GONE);
                iv05.setVisibility(View.GONE);
                break;
            case 2:
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.VISIBLE);
                iv03.setVisibility(View.GONE);
                iv04.setVisibility(View.GONE);
                iv05.setVisibility(View.GONE);
                break;
            case 1:
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.GONE);
                iv03.setVisibility(View.GONE);
                iv04.setVisibility(View.GONE);
                iv05.setVisibility(View.GONE);
                break;
            case 0:
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.VISIBLE);
                iv03.setVisibility(View.VISIBLE);
                iv04.setVisibility(View.VISIBLE);
                iv05.setVisibility(View.VISIBLE);
                break;
        }
    }
}
