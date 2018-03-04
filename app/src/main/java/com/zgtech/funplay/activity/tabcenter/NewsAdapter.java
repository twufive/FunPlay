package com.zgtech.funplay.activity.tabcenter;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.R;
import com.zgtech.funplay.model.NewsModel;
import com.zgtech.funplay.model.QualityFoodModel;
import com.zgtech.funplay.retrofit.ApiStores;
import com.zgtech.funplay.utils.DateUtil;

import java.util.List;

/**
 * 说说列表下边的评论RecyclerView适配器
 * Created by Administrator on 2017/6/14.
 */

public class NewsAdapter extends BaseQuickAdapter<NewsModel.ListBean, BaseViewHolder> {

    public NewsAdapter(int layoutResId, List<NewsModel.ListBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, NewsModel.ListBean foodBean) {
        TextView tvTitle = helper.getView(R.id.tv_news_title);
        TextView tvSubTitle = helper.getView(R.id.tv_news_subtitle);
        TextView tvDate = helper.getView(R.id.tv_news_date);
        tvTitle.setText(foodBean.getTitle());
        tvSubTitle.setText(foodBean.getSubTitle());
        tvDate.setText(foodBean.getCreateTime());
    }
}
