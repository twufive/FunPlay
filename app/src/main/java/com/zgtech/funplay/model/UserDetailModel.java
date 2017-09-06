package com.zgtech.funplay.model;

import java.util.List;

/**
 * 查询某个导游的详情数据实体
 * Created by Administrator on 2017/9/4.
 */

public class UserDetailModel {

    /**
     * code : 2
     * msg : 成功
     * obj : {"userId":12,"userNick":"cast.zhou","userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userBackground":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userSex":1,"userHeight":170,"userConstellation":1,"stateIdent":1,"stateIdentJob":0,"transactionCount":2,"spaces":[{"spaceId":1,"userId":12,"userNick":"cast.zhou","userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","spaceContent":"今天组了五人开黑团去岳麓山杀了三进三出，杀得人仰马翻，杀得口吐白沫，特发此文，聊表谢意，谢谢Cast.Zhou、MM、CC、Nice、COCO、豆豆的大力支持！","spaceContentMin":"今天组了五人开黑团去岳麓山杀了三进三出...","spacePictureCount":1,"spacePicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture2":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture3":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture4":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture5":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture6":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture7":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture8":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture9":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","pictures":[],"orderId":2,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","orderPrice1":200,"orderSize":5,"modifyTime":1503038831000,"comments":[{"commentId":1,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","modifyTime":"2017-08-18"},{"commentId":2,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长****的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","modifyTime":"2017-08-18"},{"commentId":3,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"},{"commentId":4,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"},{"commentId":5,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"}],"goodCounts":3,"goodNicks":"cast.zhou,趣玩-13,趣玩-14"}],"togethers":[{"orderId":null,"orderTitle":null,"orderPicture1":null,"orderSize":0,"orderPrice1":0,"orderPrice0":0,"avgMark":0,"orderTransactionCount":0}]}
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
         * userId : 12
         * userNick : cast.zhou
         * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
         * userBackground : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
         * userSex : 1
         * userHeight : 170
         * userConstellation : 1
         * stateIdent : 1
         * stateIdentJob : 0
         * transactionCount : 2
         * spaces : [{"spaceId":1,"userId":12,"userNick":"cast.zhou","userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","spaceContent":"今天组了五人开黑团去岳麓山杀了三进三出，杀得人仰马翻，杀得口吐白沫，特发此文，聊表谢意，谢谢Cast.Zhou、MM、CC、Nice、COCO、豆豆的大力支持！","spaceContentMin":"今天组了五人开黑团去岳麓山杀了三进三出...","spacePictureCount":1,"spacePicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture2":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture3":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture4":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture5":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture6":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture7":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture8":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture9":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","pictures":[],"orderId":2,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","orderPrice1":200,"orderSize":5,"modifyTime":1503038831000,"comments":[{"commentId":1,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","modifyTime":"2017-08-18"},{"commentId":2,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长****的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","modifyTime":"2017-08-18"},{"commentId":3,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"},{"commentId":4,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"},{"commentId":5,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"}],"goodCounts":3,"goodNicks":"cast.zhou,趣玩-13,趣玩-14"}]
         * togethers : [{"orderId":null,"orderTitle":null,"orderPicture1":null,"orderSize":0,"orderPrice1":0,"orderPrice0":0,"avgMark":0,"orderTransactionCount":0}]
         */

        private int userId;
        private String userNick;
        private String userIcon;
        private String userBackground;
        private int userSex;
        private int userHeight;
        private int userConstellation;
        private int stateIdent;
        private int stateIdentJob;
        private int transactionCount;
        private List<SpacesBean> spaces;
        private List<TogethersBean> togethers;

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

        public String getUserBackground() {
            return userBackground;
        }

        public void setUserBackground(String userBackground) {
            this.userBackground = userBackground;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
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

        public int getTransactionCount() {
            return transactionCount;
        }

        public void setTransactionCount(int transactionCount) {
            this.transactionCount = transactionCount;
        }

        public List<SpacesBean> getSpaces() {
            return spaces;
        }

        public void setSpaces(List<SpacesBean> spaces) {
            this.spaces = spaces;
        }

        public List<TogethersBean> getTogethers() {
            return togethers;
        }

        public void setTogethers(List<TogethersBean> togethers) {
            this.togethers = togethers;
        }

        public static class SpacesBean {
            /**
             * spaceId : 1
             * userId : 12
             * userNick : cast.zhou
             * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
             * spaceContent : 今天组了五人开黑团去岳麓山杀了三进三出，杀得人仰马翻，杀得口吐白沫，特发此文，聊表谢意，谢谢Cast.Zhou、MM、CC、Nice、COCO、豆豆的大力支持！
             * spaceContentMin : 今天组了五人开黑团去岳麓山杀了三进三出...
             * spacePictureCount : 1
             * spacePicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture2 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture3 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture4 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture5 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture6 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture7 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture8 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * spacePicture9 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * pictures : []
             * orderId : 2
             * orderTitle : 岳麓山5人一日游，200块多不多不多！！！
             * orderPrice1 : 200
             * orderSize : 5
             * modifyTime : 1503038831000
             * comments : [{"commentId":1,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","modifyTime":"2017-08-18"},{"commentId":2,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长****的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","modifyTime":"2017-08-18"},{"commentId":3,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"},{"commentId":4,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"},{"commentId":5,"spaceId":1,"userId":12,"commentUserId":12,"commentUserNick":"cast.zhou","commentContent":"**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好**的刚好","modifyTime":"2017-08-18"}]
             * goodCounts : 3
             * goodNicks : cast.zhou,趣玩-13,趣玩-14
             */

            private int spaceId;
            private int userId;
            private String userNick;
            private String userIcon;
            private String spaceContent;
            private String spaceContentMin;
            private int spacePictureCount;
            private String spacePicture1;
            private String spacePicture2;
            private String spacePicture3;
            private String spacePicture4;
            private String spacePicture5;
            private String spacePicture6;
            private String spacePicture7;
            private String spacePicture8;
            private String spacePicture9;
            private int orderId;
            private String orderTitle;
            private int orderPrice1;
            private int orderSize;
            private long modifyTime;
            private int goodCounts;
            private String goodNicks;
            private List<?> pictures;
            private List<CommentsBean> comments;

            public int getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(int spaceId) {
                this.spaceId = spaceId;
            }

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

            public String getSpaceContent() {
                return spaceContent;
            }

            public void setSpaceContent(String spaceContent) {
                this.spaceContent = spaceContent;
            }

            public String getSpaceContentMin() {
                return spaceContentMin;
            }

            public void setSpaceContentMin(String spaceContentMin) {
                this.spaceContentMin = spaceContentMin;
            }

            public int getSpacePictureCount() {
                return spacePictureCount;
            }

            public void setSpacePictureCount(int spacePictureCount) {
                this.spacePictureCount = spacePictureCount;
            }

            public String getSpacePicture1() {
                return spacePicture1;
            }

            public void setSpacePicture1(String spacePicture1) {
                this.spacePicture1 = spacePicture1;
            }

            public String getSpacePicture2() {
                return spacePicture2;
            }

            public void setSpacePicture2(String spacePicture2) {
                this.spacePicture2 = spacePicture2;
            }

            public String getSpacePicture3() {
                return spacePicture3;
            }

            public void setSpacePicture3(String spacePicture3) {
                this.spacePicture3 = spacePicture3;
            }

            public String getSpacePicture4() {
                return spacePicture4;
            }

            public void setSpacePicture4(String spacePicture4) {
                this.spacePicture4 = spacePicture4;
            }

            public String getSpacePicture5() {
                return spacePicture5;
            }

            public void setSpacePicture5(String spacePicture5) {
                this.spacePicture5 = spacePicture5;
            }

            public String getSpacePicture6() {
                return spacePicture6;
            }

            public void setSpacePicture6(String spacePicture6) {
                this.spacePicture6 = spacePicture6;
            }

            public String getSpacePicture7() {
                return spacePicture7;
            }

            public void setSpacePicture7(String spacePicture7) {
                this.spacePicture7 = spacePicture7;
            }

            public String getSpacePicture8() {
                return spacePicture8;
            }

            public void setSpacePicture8(String spacePicture8) {
                this.spacePicture8 = spacePicture8;
            }

            public String getSpacePicture9() {
                return spacePicture9;
            }

            public void setSpacePicture9(String spacePicture9) {
                this.spacePicture9 = spacePicture9;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getOrderTitle() {
                return orderTitle;
            }

            public void setOrderTitle(String orderTitle) {
                this.orderTitle = orderTitle;
            }

            public int getOrderPrice1() {
                return orderPrice1;
            }

            public void setOrderPrice1(int orderPrice1) {
                this.orderPrice1 = orderPrice1;
            }

            public int getOrderSize() {
                return orderSize;
            }

            public void setOrderSize(int orderSize) {
                this.orderSize = orderSize;
            }

            public long getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(long modifyTime) {
                this.modifyTime = modifyTime;
            }

            public int getGoodCounts() {
                return goodCounts;
            }

            public void setGoodCounts(int goodCounts) {
                this.goodCounts = goodCounts;
            }

            public String getGoodNicks() {
                return goodNicks;
            }

            public void setGoodNicks(String goodNicks) {
                this.goodNicks = goodNicks;
            }

            public List<?> getPictures() {
                return pictures;
            }

            public void setPictures(List<?> pictures) {
                this.pictures = pictures;
            }

            public List<CommentsBean> getComments() {
                return comments;
            }

            public void setComments(List<CommentsBean> comments) {
                this.comments = comments;
            }

            public static class CommentsBean {
                /**
                 * commentId : 1
                 * spaceId : 1
                 * userId : 12
                 * commentUserId : 12
                 * commentUserNick : cast.zhou
                 * commentContent : **的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了
                 * modifyTime : 2017-08-18
                 */

                private int commentId;
                private int spaceId;
                private int userId;
                private int commentUserId;
                private String commentUserNick;
                private String commentContent;
                private String modifyTime;

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
                }

                public int getSpaceId() {
                    return spaceId;
                }

                public void setSpaceId(int spaceId) {
                    this.spaceId = spaceId;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public int getCommentUserId() {
                    return commentUserId;
                }

                public void setCommentUserId(int commentUserId) {
                    this.commentUserId = commentUserId;
                }

                public String getCommentUserNick() {
                    return commentUserNick;
                }

                public void setCommentUserNick(String commentUserNick) {
                    this.commentUserNick = commentUserNick;
                }

                public String getCommentContent() {
                    return commentContent;
                }

                public void setCommentContent(String commentContent) {
                    this.commentContent = commentContent;
                }

                public String getModifyTime() {
                    return modifyTime;
                }

                public void setModifyTime(String modifyTime) {
                    this.modifyTime = modifyTime;
                }
            }
        }

        public static class TogethersBean {
            /**
             * orderId : null
             * orderTitle : null
             * orderPicture1 : null
             * orderSize : 0
             * orderPrice1 : 0
             * orderPrice0 : 0
             * avgMark : 0
             * orderTransactionCount : 0
             */

            private String orderId;
            private String orderTitle;
            private String orderPicture1;
            private int orderSize;
            private int orderPrice1;
            private int orderPrice0;
            private int avgMark;
            private int orderTransactionCount;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getOrderTitle() {
                return orderTitle;
            }

            public void setOrderTitle(String orderTitle) {
                this.orderTitle = orderTitle;
            }

            public String getOrderPicture1() {
                return orderPicture1;
            }

            public void setOrderPicture1(String orderPicture1) {
                this.orderPicture1 = orderPicture1;
            }

            public int getOrderSize() {
                return orderSize;
            }

            public void setOrderSize(int orderSize) {
                this.orderSize = orderSize;
            }

            public int getOrderPrice1() {
                return orderPrice1;
            }

            public void setOrderPrice1(int orderPrice1) {
                this.orderPrice1 = orderPrice1;
            }

            public int getOrderPrice0() {
                return orderPrice0;
            }

            public void setOrderPrice0(int orderPrice0) {
                this.orderPrice0 = orderPrice0;
            }

            public int getAvgMark() {
                return avgMark;
            }

            public void setAvgMark(int avgMark) {
                this.avgMark = avgMark;
            }

            public int getOrderTransactionCount() {
                return orderTransactionCount;
            }

            public void setOrderTransactionCount(int orderTransactionCount) {
                this.orderTransactionCount = orderTransactionCount;
            }
        }
    }
}
