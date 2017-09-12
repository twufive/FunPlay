package com.zgtech.funplay.activity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hss01248.dialog.StyledDialog;
import com.hss01248.dialog.interfaces.MyItemDialogListener;
import com.hyphenate.EMMessageListener;
import com.hyphenate.chat.EMChatManager;
import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMConversation;
import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;
import com.hyphenate.easeui.widget.EaseChatMessageList;
import com.hyphenate.easeui.widget.chatrow.EaseCustomChatRowProvider;
import com.zgtech.funplay.R;
import com.zgtech.funplay.base.BaseActivity;
import com.zgtech.funplay.greendao.gen.DaoMaster;
import com.zgtech.funplay.greendao.gen.DaoSession;
import com.zgtech.funplay.greendao.gen.HxUserModelDao;
import com.zgtech.funplay.model.HxUserModel;
import com.zgtech.funplay.utils.L;
import com.zgtech.funplay.utils.T;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 聊天界面
 * Created by Administrator on 2017/4/14.
 */

public class ChatActivity extends BaseActivity {
    @Bind(R.id.ll_back)
    LinearLayout llBack;
    @Bind(R.id.tv_toolbar)
    TextView tvToolbar;
    @Bind(R.id.iv_right)
    ImageView ivRight;
    @Bind(R.id.fl_container)
    FrameLayout flContainer;

    private DaoMaster.DevOpenHelper devOpenHelper;

    private boolean isFromConversationList;
    private EaseChatFragment chatFragment;
    private EMMessageListener msgListener;
    private EMChatManager emChatManager;
    private EMConversation thisConversation;

    private String imUser;
    private String imUserNick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        ButterKnife.bind(this);

        emChatManager = EMClient.getInstance().chatManager();
        devOpenHelper = new DaoMaster.DevOpenHelper(this, "zayin.db", null);
        isFromConversationList = getIntent().getExtras().getBoolean("isFromConversationList", false);
        imUser = getIntent().getExtras().getString("imUser", "");

        initToolBar();
        initEaseChatFragment();
        initChatFragmentListener();
        initMessageListener();

        thisConversation = emChatManager.getConversation(imUser);
    }


    private void initToolBar() {
        llBack.setVisibility(View.VISIBLE);
        ivRight.setVisibility(View.VISIBLE);
        imUserNick = getNick(imUser);
        tvToolbar.setText(imUserNick);
        ivRight.setBackgroundResource(R.drawable.ic_delete_sweep_white_24dp);
//            ivRight.setVisibility(View.GONE);
    }

    private String getNick(String imUser) {
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
        HxUserModelDao hxUserModelDao = daoSession.getHxUserModelDao();

        List<HxUserModel> hxUserModels = hxUserModelDao.loadAll();
        for (HxUserModel hxUserModel : hxUserModels) {
            if (hxUserModel.getImUser().equalsIgnoreCase(imUser)) {
                imUserNick = hxUserModel.getHxNickname();
            }
        }
        return imUserNick;
    }

    @OnClick({R.id.ll_back, R.id.iv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_back:
                finish();
                break;
            case R.id.iv_right:
                EMConversation conversation = EMClient.getInstance().chatManager().getConversation(imUser, EMConversation.EMConversationType.Chat);
                if (conversation != null) {
                    conversation.clearAllMessages();
                    View chatFragmentView = chatFragment.getView();
                    EaseChatMessageList messageList = (EaseChatMessageList) chatFragmentView.findViewById(R.id.message_list);
                    messageList.refresh();
                }
                T.showShort("聊天记录已清除!");
                break;
        }
    }

    private void initEaseChatFragment() {
        chatFragment = new EaseChatFragment();
        Bundle args = new Bundle();

        args.putInt(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
        args.putString(EaseConstant.EXTRA_USER_ID, imUser);

        chatFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container, chatFragment).commit();
    }

    private void initChatFragmentListener() {
        chatFragment.setChatFragmentListener(new EaseChatFragment.EaseChatFragmentHelper() {
            @Override
            public void onSetMessageAttributes(EMMessage message) {

            }

            @Override
            public void onEnterToChatDetails() {

            }

            @Override
            public void onAvatarClick(String username) {
                Intent intent = new Intent(ChatActivity.this, CoreUserDetailPageActivity.class);
                intent.putExtra("userId", username);
                startActivity(intent);
            }

            @Override
            public void onAvatarLongClick(String username) {

            }

            @Override
            public boolean onMessageBubbleClick(EMMessage message) {
                return false;
            }

            @Override
            public void onMessageBubbleLongClick(final EMMessage message) {
                EMMessage.Type type = message.getType();
                if (type.equals(EMMessage.Type.TXT)) {
                    String allStrMessage = message.getBody().toString();
                    String subStrMessage = allStrMessage.substring(5, allStrMessage.length() - 1);

                    showBubbleLongClickDialog(message, subStrMessage);
                }
            }

            private void showBubbleLongClickDialog(final EMMessage message, final String subStrMessage) {
                final List<String> strings = new ArrayList<>();
                strings.add("复制");
                strings.add("删除此条消息");
                StyledDialog.buildBottomItemDialog(strings, "", new MyItemDialogListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        if (text.equals("复制")) {
                            copyThisTexMsg(subStrMessage);
                        } else if (text.equals("删除此条消息")) {
                            deleteThisMsgItem(message);
                        }
                    }

                    @Override
                    public void onBottomBtnClick() {

                    }
                }).show();
            }

            private void copyThisTexMsg(CharSequence text) {
                //获取剪贴板管理器：
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 创建普通字符型ClipData
                ClipData mClipData = ClipData.newPlainText("Label", text);
                // 将ClipData内容放到系统剪贴板里。
                cm.setPrimaryClip(mClipData);
            }

            private void deleteThisMsgItem(EMMessage message) {
                String allStrMessage = message.getBody().toString();
                L.i("onMessageBubbleLongClick", allStrMessage);

                String subStrMessage = allStrMessage.substring(5, allStrMessage.length() - 1);
                L.i("subStrMessage", subStrMessage);

                String msgId = message.getMsgId();
                thisConversation.removeMessage(msgId);

                View chatFragmentView = chatFragment.getView();
                EaseChatMessageList messageList = (EaseChatMessageList) chatFragmentView.findViewById(R.id.message_list);
                messageList.refresh();
            }

            @Override
            public boolean onExtendMenuItemClick(int itemId, View view) {
                return false;
            }

            @Override
            public EaseCustomChatRowProvider onSetCustomChatRowProvider() {
                return null;
            }
        });
    }

    private void initMessageListener() {
        msgListener = new EMMessageListener() {

            @Override
            public void onMessageReceived(List<EMMessage> messages) {
                //收到消息
                L.i("onMessageReceived", messages.toString());
            }

            @Override
            public void onCmdMessageReceived(List<EMMessage> messages) {
                //收到透传消息
                L.i("onCmdMessageReceived", messages.toString());
            }

            @Override
            public void onMessageRead(List<EMMessage> messages) {
                //收到已读回执
            }

            @Override
            public void onMessageDelivered(List<EMMessage> message) {
                //收到已送达回执
            }

            @Override
            public void onMessageChanged(EMMessage message, Object change) {
                //消息状态变动
            }
        };

        EMClient.getInstance().chatManager().addMessageListener(msgListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EMClient.getInstance().chatManager().addMessageListener(msgListener);//注册
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EMClient.getInstance().chatManager().removeMessageListener(msgListener);
        devOpenHelper.close();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (isFromConversationList) {
            finish();
        } else {
            finish();
        }
    }

    /**
     * 左边滑出，右边滑入的进入下一个Activity动画
     */
    public void slideNextActivity(Intent intent) {
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
    }

    /**
     * 进入淡入，出去淡出的进入下一个Activity动画
     */
    public void fadeNextActivity(Intent intent) {
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    /**
     * 左边滑入，右边滑出的回到上一个Activity动画
     */
    public void backPreActivity(Intent intent) {
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

}
