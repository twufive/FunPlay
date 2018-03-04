package com.zgtech.funplay.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CoreOrderDetailActivity;
import com.zgtech.funplay.model.PinTuanTogetherModel;
import com.zgtech.funplay.retrofit.ApiStores;

import java.util.List;

/**
 * 一起拼团(大厅核心页面)
 * Created by Administrator on 2017/8/3.
 */

public class PinTuanTogetherAdapter extends BaseQuickAdapter<PinTuanTogetherModel.ObjBean, BaseViewHolder> {
    private Activity act;

    public PinTuanTogetherAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<PinTuanTogetherModel.ObjBean> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, final PinTuanTogetherModel.ObjBean individualModel) {
        ImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvScore = helper.getView(R.id.tv_score);
        TextView tvPrice = helper.getView(R.id.tv_price);
        TextView tvPriceOld = helper.getView(R.id.tv_price_old);
        Button btnRush = helper.getView(R.id.btn_rush);
        Button btnCountAll = helper.getView(R.id.btn_count_all);
        TextView tvCountNow = helper.getView(R.id.tv_count_now);
        LinearLayout llCard = helper.getView(R.id.ll_scenic_card);

        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(ApiStores.API_SERVER_URL + individualModel.getOrderPicture1())
                .into(ivSite);

        tvTitle.setText(individualModel.getOrderTitle());
        tvTitle.setMaxLines(1);
        tvScore.setText(individualModel.getAvgMark() + "分");
        tvPrice.setText("￥" + individualModel.getOrderPrice1());//getOrderPrice1为折后价
        tvPriceOld.setText("￥" + individualModel.getOrderPrice0());//getOrderPrice0为折前价
        tvPrice.getPaint().setFlags(Paint.FAKE_BOLD_TEXT_FLAG);//现价加粗
        tvPriceOld.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //中划线

        btnCountAll.setText(individualModel.getOrderSize() + "人团");
        tvCountNow.setText("已团" + individualModel.getOrderTransactionCount() + "人");



        btnRush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(act, CoreOrderDetailActivity.class);
                intent.putExtra("orderId", individualModel.getOrderId() + "");
                act.startActivity(intent);
            }
        });

    }
}
