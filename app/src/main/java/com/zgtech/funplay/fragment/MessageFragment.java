package com.zgtech.funplay.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.ui.EaseConversationListFragment;
import com.zgtech.funplay.R;
import com.zgtech.funplay.activity.ChatActivity;
import com.zgtech.funplay.base.BaseFragment;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.SPUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 消息模块
 * Created by Administrator on 2017/8/1.
 */
public class MessageFragment extends BaseFragment {
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.tv_right)
    TextView tvRight;
    @Bind(R.id.fl_container)
    FrameLayout flContainer;

    private String userId;
    private EMChatManager emChatManager;
    private EaseConversationListFragment conversationListFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, view);

        userId = SPUtils.getString(getActivity(), "userId", "0");
        emChatManager = EMClient.getInstance().chatManager();

        initView(view, savedInstanceState);
        initData();
        initMessageListener();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        L.i("MessageFragment", "onDestroy");
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        initStatusBar();
        tvToolbar.setText("聊天");

        conversationListFragment = new EaseConversationListFragment();
        getChildFragmentManager().beginTransaction().add(R.id.fl_container, conversationListFragment).commit();

        setItemClickListener();
    }


    private void setItemClickListener() {
        conversationListFragment.setConversationListItemClickListener(new EaseConversationListFragment.EaseConversationListItemClickListener() {
            @Override
            public void onListItemClicked(EMConversation conversation) {
                String conversationId = conversation.conversationId();
                String otherHxId = conversationId;
                
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                intent.putExtra("isGroup", false);
                intent.putExtra("imUser", otherHxId);
                intent.putExtra("isFromConversationList", true);
                startActivity(intent);
            }
        });
    }


    private void initMessageListener() {
        emChatManager.addMessageListener(new EMMessageListener() {
            @Override
            public void onMessageReceived(List<EMMessage> list) {
                conversationListFragment.refresh();
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> list) {
                L.i("LiaoTianReceivedCmd", "" + list.size());
            }

            @Override
            public void onMessageRead(List<EMMessage> list) {

            }

            @Override
            public void onMessageDelivered(List<EMMessage> list) {

            }

            @Override
            public void onMessageChanged(EMMessage emMessage, Object o) {

            }
        });
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = mActivity.getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
            decorView.setSystemUiVisibility(option);
            mActivity.getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    protected void initData() {

    }

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

}
