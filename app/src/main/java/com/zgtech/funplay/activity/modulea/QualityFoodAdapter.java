package com.zgtech.funplay.activity.modulea;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.model.QualityFoodModel;
import com.zgtech.funplay.model.QualityScenicModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.DateUtil;

import java.util.List;

/**
 * 说说列表下边的评论RecyclerView适配器
 * Created by Administrator on 2017/6/14.
 */

public class QualityFoodAdapter extends BaseQuickAdapter<QualityFoodModel.ListBean, BaseViewHolder> {

    public QualityFoodAdapter(int layoutResId, List<QualityFoodModel.ListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, QualityFoodModel.ListBean foodBean) {
        TextView tvTitle = helper.getView(R.id.tv_food_title);
        TextView tvDate = helper.getView(R.id.tv_food_date);
        ImageView ivFood = helper.getView(R.id.iv_food);


        tvTitle.setText(foodBean.getName());
        tvDate.setText(DateUtil.long2strTimeShort(foodBean.getCreateTime()));

        Glide.with(FunPlayApplication.getContext())
                .load(ApiStores.API_SERVER_URL + foodBean.getCover())
                .placeholder(R.drawable.bg_user_detail)
                .into(ivFood);
    }
}
