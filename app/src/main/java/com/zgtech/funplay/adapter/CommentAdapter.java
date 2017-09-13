package com.zgtech.funplay.adapter;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zgtech.funplay.R;
import com.zgtech.funplay.model.FriendTalkData;
import com.zgtech.funplay.utils.L;

import java.util.List;

/**
 * 说说列表下边的评论RecyclerView适配器
 * Created by Administrator on 2017/6/14.
 */

public class CommentAdapter extends BaseQuickAdapter<FriendTalkData.ListBean.CommentsBean, BaseViewHolder> {

    public CommentAdapter(int layoutResId, List<FriendTalkData.ListBean.CommentsBean> data) {
        super(layoutResId, data);

    }

    @Override
    protected void convert(BaseViewHolder helper, final FriendTalkData.ListBean.CommentsBean individuallModel) {
        TextView tvUserName = helper.getView(R.id.tv_username);
        TextView tvCommentContent = helper.getView(R.id.tv_comment_content);

        tvUserName.setText(individuallModel.getCommentUserNick() + ":");
        tvCommentContent.setText(individuallModel.getCommentContent());
    }


    private void initClickListener(final FriendTalkData.ListBean.CommentsBean individuallModel, View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L.i("getSpaceId", individuallModel.getSpaceId() + "");
            }
        });
    }
}
