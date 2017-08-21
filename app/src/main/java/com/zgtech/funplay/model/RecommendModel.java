package com.zgtech.funplay.model;

/**
 * Created by Administrator on 2017/8/3.
 */

public class RecommendModel {
    private String site;
    private String siteImgUrl;
    private String avatarImgUrl;
    private String sign;
    private String star;
    private String readCount;

    public RecommendModel() {
    }

    public RecommendModel(String site, String siteImgUrl, String avatarImgUrl, String sign, String star, String readCount) {
        this.site = site;
        this.siteImgUrl = siteImgUrl;
        this.avatarImgUrl = avatarImgUrl;
        this.sign = sign;
        this.star = star;
        this.readCount = readCount;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getSiteImgUrl() {
        return siteImgUrl;
    }

    public void setSiteImgUrl(String siteImgUrl) {
        this.siteImgUrl = siteImgUrl;
    }

    public String getAvatarImgUrl() {
        return avatarImgUrl;
    }

    public void setAvatarImgUrl(String avatarImgUrl) {
        this.avatarImgUrl = avatarImgUrl;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getReadCount() {
        return readCount;
    }

    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }
}
