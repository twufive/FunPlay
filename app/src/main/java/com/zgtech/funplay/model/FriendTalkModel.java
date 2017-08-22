package com.zgtech.funplay.model;

/**
 * 旅游圈数据实体
 * Created by Administrator on 2017/8/22.
 */

public class FriendTalkModel {
    private String avatarUrl;
    private String title;
    private String content;
    private String friendTalkPics;
    private String sign;

    public FriendTalkModel() {

    }

    public FriendTalkModel(String avatarUrl, String title, String content, String friendTalkPics, String sign) {
        this.avatarUrl = avatarUrl;
        this.title = title;
        this.content = content;
        this.friendTalkPics = friendTalkPics;
        this.sign = sign;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFriendTalkPics() {
        return friendTalkPics;
    }

    public void setFriendTalkPics(String friendTalkPics) {
        this.friendTalkPics = friendTalkPics;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
