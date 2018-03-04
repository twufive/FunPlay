package com.zgtech.funplay.activity.modulea;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.CoreOrderDetailActivity;
import com.zgtech.funplay.model.FriendTalkData;
import com.zgtech.funplay.model.QualityScenicModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.DateUtil;
import com.zgtech.funplay.utils.L;

import java.util.List;

/**
 * 说说列表下边的评论RecyclerView适配器
 * Created by Administrator on 2017/6/14.
 */

public class QualityScenicAdapter extends BaseQuickAdapter<QualityScenicModel.ListBean, BaseViewHolder> {

    public QualityScenicAdapter(int layoutResId, List<QualityScenicModel.ListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, QualityScenicModel.ListBean scenicBean) {
        TextView tvTitle = helper.getView(R.id.tv_scenic_title);
        TextView tvDate = helper.getView(R.id.tv_scenic_date);
        ImageView ivScenic = helper.getView(R.id.iv_scenic);


        tvTitle.setText(scenicBean.getName());
        tvDate.setText(DateUtil.long2strTimeShort(scenicBean.getCreateTime()));

        Glide.with(FunPlayApplication.getContext())
                .load(ApiStores.API_SERVER_URL + scenicBean.getCover())
                .placeholder(R.drawable.bg_user_detail)
                .into(ivScenic);
    }
}
