package com.zgtech.funplay.model;

import java.util.List;

/**
 * 登录成功后返回的数据实体
 * Created by Administrator on 2017/8/28.
 */

public class LoginModel {

    /**
     * code : 2
     * msg : 成功
     * obj : {"iosToken":"","androidToken":"1234567899","verifyCode":"","checkCode":"","userId":12,"userPhone":"15073001217","userPwd":"信息保密，你看不到的","verifyPwd":"","modifyTime":1503539290000,"state":0,"userType":1,"detail":{"detailId":6,"userPhone":"15073001217","userRegTime":1501137592000,"userCode":"+86","userNick":"cast.zhou","userSex":1,"userBirthday":622137600000,"userHeight":170,"userConstellation":1,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userBackground":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userFp":"10012","userQr":"upload/qrimg/20170727/5a8067c61dfc42b59f6681cb33cde478.png","userCity":"11_01_01","userSign":"要趣玩，来找我","userStealthSettings":0,"notificationVibration":false,"notificationSound":false,"notificationDisplayDetails":false,"imUser":"ec13742d26","wxUser":"","stateIdent":1,"stateIdentJob":0,"userTag":"","userVocation":"","userTag1":0,"userVocation1":1,"userTag2":0,"userVocation2":0,"absolutePath":"E:/upload","userRegisterProgress":0,"userId":12},"balance":{"balanceId":0,"userId":0,"userBalance":0},"pictures":[{"pictureId":2,"userId":12,"pictureUrl":"upload/user_img/20170721/1e47bdd89e214e738a81157379567689.jpg","pictureRemark":"图片二","modifyTime":1501237182000,"state":0}],"skills":[{"skillId":2,"userId":12,"skillTypeId":1,"skillTypeName":"跑","skillType":0,"skillPrice":5,"skillPriceType":0}]}
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
         * androidToken : 1234567899
         * verifyCode :
         * checkCode :
         * userId : 12
         * userPhone : 15073001217
         * userPwd : 信息保密，你看不到的
         * verifyPwd :
         * modifyTime : 1503539290000
         * state : 0
         * userType : 1
         * detail : {"detailId":6,"userPhone":"15073001217","userRegTime":1501137592000,"userCode":"+86","userNick":"cast.zhou","userSex":1,"userBirthday":622137600000,"userHeight":170,"userConstellation":1,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userBackground":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userFp":"10012","userQr":"upload/qrimg/20170727/5a8067c61dfc42b59f6681cb33cde478.png","userCity":"11_01_01","userSign":"要趣玩，来找我","userStealthSettings":0,"notificationVibration":false,"notificationSound":false,"notificationDisplayDetails":false,"imUser":"ec13742d26","wxUser":"","stateIdent":1,"stateIdentJob":0,"userTag":"","userVocation":"","userTag1":0,"userVocation1":1,"userTag2":0,"userVocation2":0,"absolutePath":"E:/upload","userRegisterProgress":0,"userId":12}
         * balance : {"balanceId":0,"userId":0,"userBalance":0}
         * pictures : [{"pictureId":2,"userId":12,"pictureUrl":"upload/user_img/20170721/1e47bdd89e214e738a81157379567689.jpg","pictureRemark":"图片二","modifyTime":1501237182000,"state":0}]
         * skills : [{"skillId":2,"userId":12,"skillTypeId":1,"skillTypeName":"跑","skillType":0,"skillPrice":5,"skillPriceType":0}]
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
        private DetailBean detail;
        private BalanceBean balance;
        private List<PicturesBean> pictures;
        private List<SkillsBean> skills;

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

        public List<PicturesBean> getPictures() {
            return pictures;
        }

        public void setPictures(List<PicturesBean> pictures) {
            this.pictures = pictures;
        }

        public List<SkillsBean> getSkills() {
            return skills;
        }

        public void setSkills(List<SkillsBean> skills) {
            this.skills = skills;
        }

        public static class DetailBean {
            /**
             * detailId : 6
             * userPhone : 15073001217
             * userRegTime : 1501137592000
             * userCode : +86
             * userNick : cast.zhou
             * userSex : 1
             * userBirthday : 622137600000
             * userHeight : 170
             * userConstellation : 1
             * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
             * userBackground : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
             * userFp : 10012
             * userQr : upload/qrimg/20170727/5a8067c61dfc42b59f6681cb33cde478.png
             * userCity : 11_01_01
             * userSign : 要趣玩，来找我
             * userStealthSettings : 0
             * notificationVibration : false
             * notificationSound : false
             * notificationDisplayDetails : false
             * imUser : ec13742d26
             * wxUser :
             * stateIdent : 1
             * stateIdentJob : 0
             * userTag :
             * userVocation :
             * userTag1 : 0
             * userVocation1 : 1
             * userTag2 : 0
             * userVocation2 : 0
             * absolutePath : E:/upload
             * userRegisterProgress : 0
             * userId : 12
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
            private int userTag1;
            private int userVocation1;
            private int userTag2;
            private int userVocation2;
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

            public int getUserTag1() {
                return userTag1;
            }

            public void setUserTag1(int userTag1) {
                this.userTag1 = userTag1;
            }

            public int getUserVocation1() {
                return userVocation1;
            }

            public void setUserVocation1(int userVocation1) {
                this.userVocation1 = userVocation1;
            }

            public int getUserTag2() {
                return userTag2;
            }

            public void setUserTag2(int userTag2) {
                this.userTag2 = userTag2;
            }

            public int getUserVocation2() {
                return userVocation2;
            }

            public void setUserVocation2(int userVocation2) {
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

        public static class PicturesBean {
            /**
             * pictureId : 2
             * userId : 12
             * pictureUrl : upload/user_img/20170721/1e47bdd89e214e738a81157379567689.jpg
             * pictureRemark : 图片二
             * modifyTime : 1501237182000
             * state : 0
             */

            private int pictureId;
            private int userId;
            private String pictureUrl;
            private String pictureRemark;
            private long modifyTime;
            private int state;

            public int getPictureId() {
                return pictureId;
            }

            public void setPictureId(int pictureId) {
                this.pictureId = pictureId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getPictureUrl() {
                return pictureUrl;
            }

            public void setPictureUrl(String pictureUrl) {
                this.pictureUrl = pictureUrl;
            }

            public String getPictureRemark() {
                return pictureRemark;
            }

            public void setPictureRemark(String pictureRemark) {
                this.pictureRemark = pictureRemark;
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
        }

        public static class SkillsBean {
            /**
             * skillId : 2
             * userId : 12
             * skillTypeId : 1
             * skillTypeName : 跑
             * skillType : 0
             * skillPrice : 5
             * skillPriceType : 0
             */

            private int skillId;
            private int userId;
            private int skillTypeId;
            private String skillTypeName;
            private int skillType;
            private int skillPrice;
            private int skillPriceType;

            public int getSkillId() {
                return skillId;
            }

            public void setSkillId(int skillId) {
                this.skillId = skillId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getSkillTypeId() {
                return skillTypeId;
            }

            public void setSkillTypeId(int skillTypeId) {
                this.skillTypeId = skillTypeId;
            }

            public String getSkillTypeName() {
                return skillTypeName;
            }

            public void setSkillTypeName(String skillTypeName) {
                this.skillTypeName = skillTypeName;
            }

            public int getSkillType() {
                return skillType;
            }

            public void setSkillType(int skillType) {
                this.skillType = skillType;
            }

            public int getSkillPrice() {
                return skillPrice;
            }

            public void setSkillPrice(int skillPrice) {
                this.skillPrice = skillPrice;
            }

            public int getSkillPriceType() {
                return skillPriceType;
            }

            public void setSkillPriceType(int skillPriceType) {
                this.skillPriceType = skillPriceType;
            }
        }
    }

    @Override
    public String toString() {
        return "LoginModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
