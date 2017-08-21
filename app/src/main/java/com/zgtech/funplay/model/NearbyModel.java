package com.zgtech.funplay.model;

/**
 * Created by Administrator on 2017/8/3.
 */

public class NearbyModel {

    private String imgUrl;
    private String nick;
    private String price;
    private String[] signs;

    public NearbyModel() {
    }

    public NearbyModel(String imgUrl, String nick, String price, String[] signs) {
        this.imgUrl = imgUrl;
        this.nick = nick;
        this.price = price;
        this.signs = signs;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
