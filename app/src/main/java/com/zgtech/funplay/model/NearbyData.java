package com.zgtech.funplay.model;

import java.util.List;

/**
 * 首页 附近数据实体
 * Created by Administrator on 2017/8/31.
 */

public class NearbyData {


    /**
     * code : 2
     * msg : 成功
     * obj : [{"userId":12,"userNick":"cast.zhou","userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userTag1":0,"userTag2":0,"avgPrice":"300.00","avgMark":4},{"userId":42,"userNick":"趣玩-42","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0},{"userId":41,"userNick":"趣玩-41","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0},{"userId":40,"userNick":"趣玩-40","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0},{"userId":39,"userNick":"趣玩-39","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0}]
     */

    private int code;
    private String msg;
    private List<ObjBean> obj;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * userId : 12
         * userNick : cast.zhou
         * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
         * userTag1 : 0
         * userTag2 : 0
         * avgPrice : 300.00
         * avgMark : 4
         */

        private int userId;
        private String userNick;
        private String userIcon;
        private int userTag1;
        private int userTag2;
        private String avgPrice;
        private int avgMark;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserNick() {
            return userNick;
        }

        public void setUserNick(String userNick) {
            this.userNick = userNick;
        }

        public String getUserIcon() {
            return userIcon;
        }

        public void setUserIcon(String userIcon) {
            this.userIcon = userIcon;
        }

        public int getUserTag1() {
            return userTag1;
        }

        public void setUserTag1(int userTag1) {
            this.userTag1 = userTag1;
        }

        public int getUserTag2() {
            return userTag2;
        }

        public void setUserTag2(int userTag2) {
            this.userTag2 = userTag2;
        }

        public String getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(String avgPrice) {
            this.avgPrice = avgPrice;
        }

        public int getAvgMark() {
            return avgMark;
        }

        public void setAvgMark(int avgMark) {
            this.avgMark = avgMark;
        }
    }
}
