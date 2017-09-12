package com.zgtech.funplay.model;

/**
 * Created by Administrator on 2017/9/11.
 */

public class MineExternalModel {

    /**
     * code : 2
     * msg : 成功
     * obj : {"userId":45,"userHotCount":0,"userCollectionCount":0,"userNick":"趣玩-45","userIcon":"upload/default.jpg","userBackground":"","userSign":""}
     */

    private int code;
    private String msg;
    private ObjBean obj;

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

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * userId : 45
         * userHotCount : 0
         * userCollectionCount : 0
         * userNick : 趣玩-45
         * userIcon : upload/default.jpg
         * userBackground :
         * userSign :
         */

        private int userId;
        private int userHotCount;
        private int userCollectionCount;
        private String userNick;
        private String userIcon;
        private String userBackground;
        private String userSign;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getUserHotCount() {
            return userHotCount;
        }

        public void setUserHotCount(int userHotCount) {
            this.userHotCount = userHotCount;
        }

        public int getUserCollectionCount() {
            return userCollectionCount;
        }

        public void setUserCollectionCount(int userCollectionCount) {
            this.userCollectionCount = userCollectionCount;
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

        public String getUserBackground() {
            return userBackground;
        }

        public void setUserBackground(String userBackground) {
            this.userBackground = userBackground;
        }

        public String getUserSign() {
            return userSign;
        }

        public void setUserSign(String userSign) {
            this.userSign = userSign;
        }
    }
}
