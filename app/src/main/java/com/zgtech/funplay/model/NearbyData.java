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
     * obj : [{"userId":43,"userNick":"趣玩-43","userIcon":"upload/default.jpg","userTag1":"","userTag2":"","avgPrice":0,"avgMark":5},{"userId":12,"userNick":"趣玩啊","userIcon":"upload/user/img/20170913/93a7bc97856b4f84a368e520960e3166.jpg","userTag1":"","userTag2":"","avgPrice":300,"avgMark":4},{"userId":53,"userNick":"趣玩啊","userIcon":"upload/default.jpg","userTag1":"","userTag2":"","avgPrice":0,"avgMark":0},{"userId":52,"userNick":"cast18507455265","userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userTag1":"","userTag2":"","avgPrice":0,"avgMark":0},{"userId":51,"userNick":"趣玩-51","userIcon":"upload/default.jpg","userTag1":"","userTag2":"","avgPrice":0,"avgMark":0}]
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
         * userId : 43
         * userNick : 趣玩-43
         * userIcon : upload/default.jpg
         * userTag1 :
         * userTag2 :
         * avgPrice : 0
         * avgMark : 5
         */

        private int userId;
        private String userNick;
        private String userIcon;
        private String userTag1;
        private String userTag2;
        private int avgPrice;
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

        public String getUserTag1() {
            return userTag1;
        }

        public void setUserTag1(String userTag1) {
            this.userTag1 = userTag1;
        }

        public String getUserTag2() {
            return userTag2;
        }

        public void setUserTag2(String userTag2) {
            this.userTag2 = userTag2;
        }

        public int getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(int avgPrice) {
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
