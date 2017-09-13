package com.zgtech.funplay.model;

import java.util.List;

/**
 * 登录成功后返回的数据实体
 * Created by Administrator on 2017/8/28.
 */

public class LoginBackUserModel {

    /**
     * code : 2
     * msg : 成功
     * obj : {"iosToken":"","androidToken":"b386c3f31de9bcc1b5917832315c3c92","verifyCode":"","checkCode":"","userId":45,"userPhone":"17707470095","userPwd":"信息保密，你看不到的","verifyPwd":"","modifyTime":1505284089000,"state":0,"userType":0,"login":false,"detail":{"detailId":39,"userPhone":"17707470095","userRegTime":1504776705000,"userCode":"+86","userNick":"趣玩啊","userSex":1,"userBirthday":883584000000,"userHeight":174,"userConstellation":9,"userIcon":"upload/user/img/20170913/07133fe1d4ba45d69fda2d9463f7cc0a.jpg","userBackground":"","userFp":"10045","userQr":"upload/qrimg/20170907/47b85564cb334e1a890ad725bcf38537.png","userCity":"11_01_01","userSign":"","userRemark":"lang li ge lang","userStealthSettings":0,"notificationVibration":true,"notificationSound":true,"notificationDisplayDetails":true,"imUser":"2343562dea","wxUser":"","stateIdent":0,"stateIdentJob":0,"userTag":"","userVocation":"","userTag1":"","userVocation1":"","userTag2":"","userVocation2":"","absolutePath":"E:/upload","userRegisterProgress":0,"userId":45},"balance":{"balanceId":0,"userId":0,"userBalance":0},"pictures":[],"skills":[]}
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
         * iosToken :
         * androidToken : b386c3f31de9bcc1b5917832315c3c92
         * verifyCode :
         * checkCode :
         * userId : 45
         * userPhone : 17707470095
         * userPwd : 信息保密，你看不到的
         * verifyPwd :
         * modifyTime : 1505284089000
         * state : 0
         * userType : 0
         * login : false
         * detail : {"detailId":39,"userPhone":"17707470095","userRegTime":1504776705000,"userCode":"+86","userNick":"趣玩啊","userSex":1,"userBirthday":883584000000,"userHeight":174,"userConstellation":9,"userIcon":"upload/user/img/20170913/07133fe1d4ba45d69fda2d9463f7cc0a.jpg","userBackground":"","userFp":"10045","userQr":"upload/qrimg/20170907/47b85564cb334e1a890ad725bcf38537.png","userCity":"11_01_01","userSign":"","userRemark":"lang li ge lang","userStealthSettings":0,"notificationVibration":true,"notificationSound":true,"notificationDisplayDetails":true,"imUser":"2343562dea","wxUser":"","stateIdent":0,"stateIdentJob":0,"userTag":"","userVocation":"","userTag1":"","userVocation1":"","userTag2":"","userVocation2":"","absolutePath":"E:/upload","userRegisterProgress":0,"userId":45}
         * balance : {"balanceId":0,"userId":0,"userBalance":0}
         * pictures : []
         * skills : []
         */

        private String iosToken;
        private String androidToken;
        private String verifyCode;
        private String checkCode;
        private int userId;
        private String userPhone;
        private String userPwd;
        private String verifyPwd;
        private long modifyTime;
        private int state;
        private int userType;
        private boolean login;
        private DetailBean detail;
        private BalanceBean balance;
        private List<?> pictures;
        private List<?> skills;

        public String getIosToken() {
            return iosToken;
        }

        public void setIosToken(String iosToken) {
            this.iosToken = iosToken;
        }

        public String getAndroidToken() {
            return androidToken;
        }

        public void setAndroidToken(String androidToken) {
            this.androidToken = androidToken;
        }

        public String getVerifyCode() {
            return verifyCode;
        }

        public void setVerifyCode(String verifyCode) {
            this.verifyCode = verifyCode;
        }

        public String getCheckCode() {
            return checkCode;
        }

        public void setCheckCode(String checkCode) {
            this.checkCode = checkCode;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserPhone() {
            return userPhone;
        }

        public void setUserPhone(String userPhone) {
            this.userPhone = userPhone;
        }

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }

        public String getVerifyPwd() {
            return verifyPwd;
        }

        public void setVerifyPwd(String verifyPwd) {
            this.verifyPwd = verifyPwd;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public int getUserType() {
            return userType;
        }

        public void setUserType(int userType) {
            this.userType = userType;
        }

        public boolean isLogin() {
            return login;
        }

        public void setLogin(boolean login) {
            this.login = login;
        }

        public DetailBean getDetail() {
            return detail;
        }

        public void setDetail(DetailBean detail) {
            this.detail = detail;
        }

        public BalanceBean getBalance() {
            return balance;
        }

        public void setBalance(BalanceBean balance) {
            this.balance = balance;
        }

        public List<?> getPictures() {
            return pictures;
        }

        public void setPictures(List<?> pictures) {
            this.pictures = pictures;
        }

        public List<?> getSkills() {
            return skills;
        }

        public void setSkills(List<?> skills) {
            this.skills = skills;
        }

        public static class DetailBean {
            /**
             * detailId : 39
             * userPhone : 17707470095
             * userRegTime : 1504776705000
             * userCode : +86
             * userNick : 趣玩啊
             * userSex : 1
             * userBirthday : 883584000000
             * userHeight : 174
             * userConstellation : 9
             * userIcon : upload/user/img/20170913/07133fe1d4ba45d69fda2d9463f7cc0a.jpg
             * userBackground :
             * userFp : 10045
             * userQr : upload/qrimg/20170907/47b85564cb334e1a890ad725bcf38537.png
             * userCity : 11_01_01
             * userSign :
             * userRemark : lang li ge lang
             * userStealthSettings : 0
             * notificationVibration : true
             * notificationSound : true
             * notificationDisplayDetails : true
             * imUser : 2343562dea
             * wxUser :
             * stateIdent : 0
             * stateIdentJob : 0
             * userTag :
             * userVocation :
             * userTag1 :
             * userVocation1 :
             * userTag2 :
             * userVocation2 :
             * absolutePath : E:/upload
             * userRegisterProgress : 0
             * userId : 45
             */

            private int detailId;
            private String userPhone;
            private long userRegTime;
            private String userCode;
            private String userNick;
            private int userSex;
            private long userBirthday;
            private int userHeight;
            private int userConstellation;
            private String userIcon;
            private String userBackground;
            private String userFp;
            private String userQr;
            private String userCity;
            private String userSign;
            private String userRemark;
            private int userStealthSettings;
            private boolean notificationVibration;
            private boolean notificationSound;
            private boolean notificationDisplayDetails;
            private String imUser;
            private String wxUser;
            private int stateIdent;
            private int stateIdentJob;
            private String userTag;
            private String userVocation;
            private String userTag1;
            private String userVocation1;
            private String userTag2;
            private String userVocation2;
            private String absolutePath;
            private int userRegisterProgress;
            private int userId;

            public int getDetailId() {
                return detailId;
            }

            public void setDetailId(int detailId) {
                this.detailId = detailId;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public long getUserRegTime() {
                return userRegTime;
            }

            public void setUserRegTime(long userRegTime) {
                this.userRegTime = userRegTime;
            }

            public String getUserCode() {
                return userCode;
            }

            public void setUserCode(String userCode) {
                this.userCode = userCode;
            }

            public String getUserNick() {
                return userNick;
            }

            public void setUserNick(String userNick) {
                this.userNick = userNick;
            }

            public int getUserSex() {
                return userSex;
            }

            public void setUserSex(int userSex) {
                this.userSex = userSex;
            }

            public long getUserBirthday() {
                return userBirthday;
            }

            public void setUserBirthday(long userBirthday) {
                this.userBirthday = userBirthday;
            }

            public int getUserHeight() {
                return userHeight;
            }

            public void setUserHeight(int userHeight) {
                this.userHeight = userHeight;
            }

            public int getUserConstellation() {
                return userConstellation;
            }

            public void setUserConstellation(int userConstellation) {
                this.userConstellation = userConstellation;
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

            public String getUserFp() {
                return userFp;
            }

            public void setUserFp(String userFp) {
                this.userFp = userFp;
            }

            public String getUserQr() {
                return userQr;
            }

            public void setUserQr(String userQr) {
                this.userQr = userQr;
            }

            public String getUserCity() {
                return userCity;
            }

            public void setUserCity(String userCity) {
                this.userCity = userCity;
            }

            public String getUserSign() {
                return userSign;
            }

            public void setUserSign(String userSign) {
                this.userSign = userSign;
            }

            public String getUserRemark() {
                return userRemark;
            }

            public void setUserRemark(String userRemark) {
                this.userRemark = userRemark;
            }

            public int getUserStealthSettings() {
                return userStealthSettings;
            }

            public void setUserStealthSettings(int userStealthSettings) {
                this.userStealthSettings = userStealthSettings;
            }

            public boolean isNotificationVibration() {
                return notificationVibration;
            }

            public void setNotificationVibration(boolean notificationVibration) {
                this.notificationVibration = notificationVibration;
            }

            public boolean isNotificationSound() {
                return notificationSound;
            }

            public void setNotificationSound(boolean notificationSound) {
                this.notificationSound = notificationSound;
            }

            public boolean isNotificationDisplayDetails() {
                return notificationDisplayDetails;
            }

            public void setNotificationDisplayDetails(boolean notificationDisplayDetails) {
                this.notificationDisplayDetails = notificationDisplayDetails;
            }

            public String getImUser() {
                return imUser;
            }

            public void setImUser(String imUser) {
                this.imUser = imUser;
            }

            public String getWxUser() {
                return wxUser;
            }

            public void setWxUser(String wxUser) {
                this.wxUser = wxUser;
            }

            public int getStateIdent() {
                return stateIdent;
            }

            public void setStateIdent(int stateIdent) {
                this.stateIdent = stateIdent;
            }

            public int getStateIdentJob() {
                return stateIdentJob;
            }

            public void setStateIdentJob(int stateIdentJob) {
                this.stateIdentJob = stateIdentJob;
            }

            public String getUserTag() {
                return userTag;
            }

            public void setUserTag(String userTag) {
                this.userTag = userTag;
            }

            public String getUserVocation() {
                return userVocation;
            }

            public void setUserVocation(String userVocation) {
                this.userVocation = userVocation;
            }

            public String getUserTag1() {
                return userTag1;
            }

            public void setUserTag1(String userTag1) {
                this.userTag1 = userTag1;
            }

            public String getUserVocation1() {
                return userVocation1;
            }

            public void setUserVocation1(String userVocation1) {
                this.userVocation1 = userVocation1;
            }

            public String getUserTag2() {
                return userTag2;
            }

            public void setUserTag2(String userTag2) {
                this.userTag2 = userTag2;
            }

            public String getUserVocation2() {
                return userVocation2;
            }

            public void setUserVocation2(String userVocation2) {
                this.userVocation2 = userVocation2;
            }

            public String getAbsolutePath() {
                return absolutePath;
            }

            public void setAbsolutePath(String absolutePath) {
                this.absolutePath = absolutePath;
            }

            public int getUserRegisterProgress() {
                return userRegisterProgress;
            }

            public void setUserRegisterProgress(int userRegisterProgress) {
                this.userRegisterProgress = userRegisterProgress;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }

        public static class BalanceBean {
            /**
             * balanceId : 0
             * userId : 0
             * userBalance : 0
             */

            private int balanceId;
            private int userId;
            private int userBalance;

            public int getBalanceId() {
                return balanceId;
            }

            public void setBalanceId(int balanceId) {
                this.balanceId = balanceId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getUserBalance() {
                return userBalance;
            }

            public void setUserBalance(int userBalance) {
                this.userBalance = userBalance;
            }
        }
    }
}
