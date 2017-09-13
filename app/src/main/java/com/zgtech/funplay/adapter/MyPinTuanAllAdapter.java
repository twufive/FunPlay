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
import com.zgtech.funplay.model.MyPinTuanModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.FunPlayUtils;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 我的拼团(全部)   适配器
 * Created by Administrator on 2017/8/3.
 */

public class MyPinTuanAllAdapter extends BaseQuickAdapter<MyPinTuanModel.ObjBean, BaseViewHolder> {
    private Activity act;

    public MyPinTuanAllAdapter(Activity act, @LayoutRes int layoutResId, @Nullable List<MyPinTuanModel.ObjBean> data) {
        super(layoutResId, data);

        this.act = act;
    }

    @Override
    protected void convert(BaseViewHolder helper, MyPinTuanModel.ObjBean individualModel) {
        CircleImageView ivSite = helper.getView(R.id.iv_site);
        TextView tvTitle = helper.getView(R.id.tv_title);
        TextView tvTime = helper.getView(R.id.tv_time);
        TextView tvPrice = helper.getView(R.id.tv_price);
        TextView tvState = helper.getView(R.id.tv_state);
        TextView tvBtn = helper.getView(R.id.tv_btn);

        ivSite.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(FunPlayApplication.getContext())
                .load(ApiStores.API_SERVER_URL + individualModel.getOrderPicture1())
                .placeholder(R.drawable.bg_user_detail)
                .into(ivSite);

        long time = individualModel.getModifyTime();
        String strTime = FunPlayUtils.long2strTime(time);
        tvTime.setText("下单时间:" + strTime);

        int stateCode = individualModel.getState();
        tvState.setText("" + FunPlayUtils.code2StrState(stateCode));


        tvTitle.setText(individualModel.getOrderTitle());
        tvPrice.setText("总价:￥" + individualModel.getOrderPrice1());
        tvBtn.setText("");

    }
}
