package com.zgtech.funplay.model;

/**
 * Created by Administrator on 2017/8/16.
 */

public class PinTuanAllModel {
    private String siteUrl;
    private String title;
    private String time;
    private String price;
    private String state;

    public PinTuanAllModel() {
    }

    public PinTuanAllModel(String siteUrl, String title, String time, String price, String state) {
        this.siteUrl = siteUrl;
        this.title = title;
        this.time = time;
        this.price = price;
        this.state = state;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
