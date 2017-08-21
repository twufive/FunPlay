package com.zgtech.funplay.model;

/**
 * Created by Administrator on 2017/8/21.
 */

public class PinTuanCoreModel {
    private String siteUrl;
    private String title;
    private String score;
    private String price;
    private String priceOld;
    private String tuanCountAll;
    private String tuanCountNow;

    public PinTuanCoreModel() {
    }

    public PinTuanCoreModel(String siteUrl, String title, String score, String price, String priceOld, String tuanCountAll, String tuanCountNow) {
        this.siteUrl = siteUrl;
        this.title = title;
        this.score = score;
        this.price = price;
        this.priceOld = priceOld;
        this.tuanCountAll = tuanCountAll;
        this.tuanCountNow = tuanCountNow;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(String priceOld) {
        this.priceOld = priceOld;
    }

    public String getTuanCountAll() {
        return tuanCountAll;
    }

    public void setTuanCountAll(String tuanCountAll) {
        this.tuanCountAll = tuanCountAll;
    }

    public String getTuanCountNow() {
        return tuanCountNow;
    }

    public void setTuanCountNow(String tuanCountNow) {
        this.tuanCountNow = tuanCountNow;
    }

    @Override
    public String toString() {
        return "PinTuanCoreModel{" +
                "siteUrl='" + siteUrl + '\'' +
                ", title='" + title + '\'' +
                ", score='" + score + '\'' +
                ", price='" + price + '\'' +
                ", priceOld='" + priceOld + '\'' +
                ", tuanCountAll='" + tuanCountAll + '\'' +
                ", tuanCountNow='" + tuanCountNow + '\'' +
                '}';
    }
}
