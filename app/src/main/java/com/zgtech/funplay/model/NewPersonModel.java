package com.zgtech.funplay.model;

/**
 * 新人   数据模型
 * Created by Administrator on 2017/8/3.
 */

public class NewPersonModel {

    private String avatarImgUrl;
    private String nick;
    private String deal;
    private String score;
    private String star;
    private String siteImgUrl;
    private String price;
    private String[] signs;

    public NewPersonModel() {
    }

    public NewPersonModel(String avatarImgUrl, String nick, String deal, String score, String star, String siteImgUrl, String price, String[] signs) {
        this.avatarImgUrl = avatarImgUrl;
        this.nick = nick;
        this.deal = deal;
        this.score = score;
        this.star = star;
        this.siteImgUrl = siteImgUrl;
        this.price = price;
        this.signs = signs;
    }

    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getSiteImgUrl() {
        return siteImgUrl;
    }

    public void setSiteImgUrl(String siteImgUrl) {
        this.siteImgUrl = siteImgUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String[] getSigns() {
        return signs;
    }

    public void setSigns(String[] signs) {
        this.signs = signs;
    }
}
