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
import com.zgtech.funplay.activity.CoreOrderDetailActivity;
import com.zgtech.funplay.model.RecommendModel;
import com.zgtech.funplay.retrofit.ApiStores;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 推荐   景点适配器
 * Created by Administrator on 2017/8/3.
 */

public class RecommendSiteAdapter extends BaseQuickAdapter<RecommendModel.ObjBean.AddressListBean, BaseViewHolder> {
    private Activity act;

    public RecommendSiteAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<RecommendModel.ObjBean.AddressListBean> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, final RecommendModel.ObjBean.AddressListBean individualModel) {
        CircleImageView ivAvatar = helper.getView(R.id.iv_avatar);
        ImageView ivStar = helper.getView(R.id.iv_star);
        ImageView iv01 = helper.getView(R.id.iv_01);
        ImageView iv02 = helper.getView(R.id.iv_02);
        ImageView iv03 = helper.getView(R.id.iv_03);
        ImageView iv04 = helper.getView(R.id.iv_04);
        ImageView iv05 = helper.getView(R.id.iv_05);
        ImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvSign = helper.getView(R.id.tv_sign);
        TextView tvRead = helper.getView(R.id.tv_read);
        CardView cardview = helper.getView(R.id.cardview);

        ivAvatar.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(ApiStores.API_SERVER_URL + individualModel.getUserIcon())
                .into(ivAvatar);

        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(ApiStores.API_SERVER_URL + individualModel.getOrderPicture1())
                .into(ivSite);

        tvSign.setText(individualModel.getOrderTitle() + "");
        tvRead.setText(individualModel.getCommentCount() + "");

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
            case 0:
                iv01.setVisibility(View.VISIBLE);
                iv02.setVisibility(View.VISIBLE);
                iv03.setVisibility(View.VISIBLE);
                iv04.setVisibility(View.VISIBLE);
                iv05.setVisibility(View.VISIBLE);
                break;

        }

        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act, CoreOrderDetailActivity.class);
                intent.putExtra("orderId", individualModel.getOrderId() + "");
                act.startActivity(intent);
            }
        });
    }
}
