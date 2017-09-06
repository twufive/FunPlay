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
     * obj : {"serviceAddress":"长沙市","spaces":[{"comments":[{"commentContent":"","commentId":0,"commentUserId":0,"commentUserNick":"","modifyTime":"2017-09-04","spaceId":4,"userId":12}],"goodCounts":0,"goodNicks":"","modifyTime":1504524527000,"orderId":1,"orderPrice1":1,"orderSize":1,"orderTitle":"1","pictures":[],"spaceContent":"牛批牛批🐮","spaceContentMin":"牛批牛批🐮","spaceId":4,"spacePicture1":"upload/user/img/20170904/aa631f6688254bf0bebf36778b1c67f2.png","spacePicture2":"upload/user/img/20170904/0db1d49dda634e95aa7661c5e3e499ba.png","spacePicture3":"","spacePicture4":"","spacePicture5":"","spacePicture6":"","spacePicture7":"","spacePicture8":"","spacePicture9":"","spacePictureCount":0,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"},{"comments":[{"commentContent":"","commentId":0,"commentUserId":0,"commentUserNick":"","modifyTime":"2017-09-04","spaceId":3,"userId":12}],"goodCounts":0,"goodNicks":"","modifyTime":1504524332000,"orderId":2,"orderPrice1":200,"orderSize":5,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","pictures":[],"spaceContent":"hahha","spaceContentMin":"hah","spaceId":3,"spacePicture1":"","spacePicture2":"","spacePicture3":"","spacePicture4":"","spacePicture5":"","spacePicture6":"","spacePicture7":"","spacePicture8":"","spacePicture9":"","spacePictureCount":0,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"},{"comments":[{"commentContent":"","commentId":0,"commentUserId":0,"commentUserNick":"","modifyTime":"2017-09-04","spaceId":2,"userId":12}],"goodCounts":0,"goodNicks":"","modifyTime":1504517920000,"orderId":2,"orderPrice1":200,"orderSize":5,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","pictures":[],"spaceContent":"hahaha","spaceContentMin":"hahaha","spaceId":2,"spacePicture1":"","spacePicture2":"","spacePicture3":"","spacePicture4":"","spacePicture5":"","spacePicture6":"","spacePicture7":"","spacePicture8":"","spacePicture9":"","spacePictureCount":0,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"},{"comments":[{"commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","commentId":1,"commentUserId":12,"commentUserNick":"cast.zhou","modifyTime":"2017-08-18","spaceId":1,"userId":12},{"commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长****的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","commentId":2,"commentUserId":12,"commentUserNick":"cast.zhou","modifyTime":"2017-08-18","spaceId":1,"userId":12}],"goodCounts":3,"goodNicks":"趣玩-13,趣玩-14,cast.zhou","modifyTime":1503038831000,"orderId":2,"orderPrice1":200,"orderSize":5,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","pictures":[],"spaceContent":"今天组了五人开黑团去岳麓山杀了三进三出，杀得人仰马翻，杀得口吐白沫，特发此文，聊表谢意，谢谢Cast.Zhou、MM、CC、Nice、COCO、豆豆的大力支持！","spaceContentMin":"今天组了五人开黑团去岳麓山杀了三进三出...","spaceId":1,"spacePicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture2":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture3":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture4":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture5":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture6":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture7":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture8":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture9":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePictureCount":1,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"}],"stateIdent":1,"stateIdentJob":0,"togethers":[{"avgMark":4.3,"orderId":"1","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPrice0":500,"orderPrice1":300,"orderSize":5,"orderTitle":"【2017年8月15日-五人团】岳麓山两日游","orderTransactionCount":14}],"transactionCount":104,"userBackground":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userConstellation":1,"userHeight":170,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou","userRemark":"这是个人简介，哈哈哈哈，12杀！","userSex":1,"userSign":"要趣玩，来找我","userVocation":"1、0"}
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
         * serviceAddress : 长沙市
         * spaces : [{"comments":[{"commentContent":"","commentId":0,"commentUserId":0,"commentUserNick":"","modifyTime":"2017-09-04","spaceId":4,"userId":12}],"goodCounts":0,"goodNicks":"","modifyTime":1504524527000,"orderId":1,"orderPrice1":1,"orderSize":1,"orderTitle":"1","pictures":[],"spaceContent":"牛批牛批🐮","spaceContentMin":"牛批牛批🐮","spaceId":4,"spacePicture1":"upload/user/img/20170904/aa631f6688254bf0bebf36778b1c67f2.png","spacePicture2":"upload/user/img/20170904/0db1d49dda634e95aa7661c5e3e499ba.png","spacePicture3":"","spacePicture4":"","spacePicture5":"","spacePicture6":"","spacePicture7":"","spacePicture8":"","spacePicture9":"","spacePictureCount":0,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"},{"comments":[{"commentContent":"","commentId":0,"commentUserId":0,"commentUserNick":"","modifyTime":"2017-09-04","spaceId":3,"userId":12}],"goodCounts":0,"goodNicks":"","modifyTime":1504524332000,"orderId":2,"orderPrice1":200,"orderSize":5,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","pictures":[],"spaceContent":"hahha","spaceContentMin":"hah","spaceId":3,"spacePicture1":"","spacePicture2":"","spacePicture3":"","spacePicture4":"","spacePicture5":"","spacePicture6":"","spacePicture7":"","spacePicture8":"","spacePicture9":"","spacePictureCount":0,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"},{"comments":[{"commentContent":"","commentId":0,"commentUserId":0,"commentUserNick":"","modifyTime":"2017-09-04","spaceId":2,"userId":12}],"goodCounts":0,"goodNicks":"","modifyTime":1504517920000,"orderId":2,"orderPrice1":200,"orderSize":5,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","pictures":[],"spaceContent":"hahaha","spaceContentMin":"hahaha","spaceId":2,"spacePicture1":"","spacePicture2":"","spacePicture3":"","spacePicture4":"","spacePicture5":"","spacePicture6":"","spacePicture7":"","spacePicture8":"","spacePicture9":"","spacePictureCount":0,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"},{"comments":[{"commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","commentId":1,"commentUserId":12,"commentUserNick":"cast.zhou","modifyTime":"2017-08-18","spaceId":1,"userId":12},{"commentContent":"**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长****的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长**的太长了","commentId":2,"commentUserId":12,"commentUserNick":"cast.zhou","modifyTime":"2017-08-18","spaceId":1,"userId":12}],"goodCounts":3,"goodNicks":"趣玩-13,趣玩-14,cast.zhou","modifyTime":1503038831000,"orderId":2,"orderPrice1":200,"orderSize":5,"orderTitle":"岳麓山5人一日游，200块多不多不多！！！","pictures":[],"spaceContent":"今天组了五人开黑团去岳麓山杀了三进三出，杀得人仰马翻，杀得口吐白沫，特发此文，聊表谢意，谢谢Cast.Zhou、MM、CC、Nice、COCO、豆豆的大力支持！","spaceContentMin":"今天组了五人开黑团去岳麓山杀了三进三出...","spaceId":1,"spacePicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture2":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture3":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture4":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture5":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture6":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture7":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture8":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePicture9":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","spacePictureCount":1,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":12,"userNick":"cast.zhou"}]
         * stateIdent : 1
         * stateIdentJob : 0
         * togethers : [{"avgMark":4.3,"orderId":"1","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPrice0":500,"orderPrice1":300,"orderSize":5,"orderTitle":"【2017年8月15日-五人团】岳麓山两日游","orderTransactionCount":14}]
         * transactionCount : 104
         * userBackground : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
         * userConstellation : 1
         * userHeight : 170
         * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
         * userId : 12
         * userNick : cast.zhou
         * userRemark : 这是个人简介，哈哈哈哈，12杀！
         * userSex : 1
         * userSign : 要趣玩，来找我
         * userVocation : 1、0
         */

        private String serviceAddress;
        private int stateIdent;
        private int stateIdentJob;
        private int transactionCount;
        private String userBackground;
        private int userConstellation;
        private int userHeight;
        private String userIcon;
        private int userId;
        private String userNick;
        private String userRemark;
        private int userSex;
        private String userSign;
        private String userVocation;
        private List<SpacesBean> spaces;
        private List<TogethersBean> togethers;

        public String getServiceAddress() {
            return serviceAddress;
        }

        public void setServiceAddress(String serviceAddress) {
            this.serviceAddress = serviceAddress;
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

        public String getUserBackground() {
            return userBackground;
        }

        public void setUserBackground(String userBackground) {
            this.userBackground = userBackground;
        }

        public int getUserConstellation() {
            return userConstellation;
        }

        public void setUserConstellation(int userConstellation) {
            this.userConstellation = userConstellation;
        }

        public int getUserHeight() {
            return userHeight;
        }

        public void setUserHeight(int userHeight) {
            this.userHeight = userHeight;
        }

        public String getUserIcon() {
            return userIcon;
        }

        public void setUserIcon(String userIcon) {
            this.userIcon = userIcon;
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

        public String getUserRemark() {
            return userRemark;
        }

        public void setUserRemark(String userRemark) {
            this.userRemark = userRemark;
        }

        public int getUserSex() {
            return userSex;
        }

        public void setUserSex(int userSex) {
            this.userSex = userSex;
        }

        public String getUserSign() {
            return userSign;
        }

        public void setUserSign(String userSign) {
            this.userSign = userSign;
        }

        public String getUserVocation() {
            return userVocation;
        }

        public void setUserVocation(String userVocation) {
            this.userVocation = userVocation;
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
             * comments : [{"commentContent":"","commentId":0,"commentUserId":0,"commentUserNick":"","modifyTime":"2017-09-04","spaceId":4,"userId":12}]
             * goodCounts : 0
             * goodNicks :
             * modifyTime : 1504524527000
             * orderId : 1
             * orderPrice1 : 1
             * orderSize : 1
             * orderTitle : 1
             * pictures : []
             * spaceContent : 牛批牛批🐮
             * spaceContentMin : 牛批牛批🐮
             * spaceId : 4
             * spacePicture1 : upload/user/img/20170904/aa631f6688254bf0bebf36778b1c67f2.png
             * spacePicture2 : upload/user/img/20170904/0db1d49dda634e95aa7661c5e3e499ba.png
             * spacePicture3 :
             * spacePicture4 :
             * spacePicture5 :
             * spacePicture6 :
             * spacePicture7 :
             * spacePicture8 :
             * spacePicture9 :
             * spacePictureCount : 0
             * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
             * userId : 12
             * userNick : cast.zhou
             */

            private int goodCounts;
            private String goodNicks;
            private long modifyTime;
            private int orderId;
            private int orderPrice1;
            private int orderSize;
            private String orderTitle;
            private String spaceContent;
            private String spaceContentMin;
            private int spaceId;
            private String spacePicture1;
            private String spacePicture2;
            private String spacePicture3;
            private String spacePicture4;
            private String spacePicture5;
            private String spacePicture6;
            private String spacePicture7;
            private String spacePicture8;
            private String spacePicture9;
            private int spacePictureCount;
            private String userIcon;
            private int userId;
            private String userNick;
            private List<CommentsBean> comments;
            private List<?> pictures;

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

            public long getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(long modifyTime) {
                this.modifyTime = modifyTime;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
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

            public String getOrderTitle() {
                return orderTitle;
            }

            public void setOrderTitle(String orderTitle) {
                this.orderTitle = orderTitle;
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

            public int getSpaceId() {
                return spaceId;
            }

            public void setSpaceId(int spaceId) {
                this.spaceId = spaceId;
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

            public int getSpacePictureCount() {
                return spacePictureCount;
            }

            public void setSpacePictureCount(int spacePictureCount) {
                this.spacePictureCount = spacePictureCount;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
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

            public List<CommentsBean> getComments() {
                return comments;
            }

            public void setComments(List<CommentsBean> comments) {
                this.comments = comments;
            }

            public List<?> getPictures() {
                return pictures;
            }

            public void setPictures(List<?> pictures) {
                this.pictures = pictures;
            }

            public static class CommentsBean {
                /**
                 * commentContent :
                 * commentId : 0
                 * commentUserId : 0
                 * commentUserNick :
                 * modifyTime : 2017-09-04
                 * spaceId : 4
                 * userId : 12
                 */

                private String commentContent;
                private int commentId;
                private int commentUserId;
                private String commentUserNick;
                private String modifyTime;
                private int spaceId;
                private int userId;

                public String getCommentContent() {
                    return commentContent;
                }

                public void setCommentContent(String commentContent) {
                    this.commentContent = commentContent;
                }

                public int getCommentId() {
                    return commentId;
                }

                public void setCommentId(int commentId) {
                    this.commentId = commentId;
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

                public String getModifyTime() {
                    return modifyTime;
                }

                public void setModifyTime(String modifyTime) {
                    this.modifyTime = modifyTime;
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
            }
        }

        public static class TogethersBean {
            /**
             * avgMark : 4.3
             * orderId : 1
             * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * orderPrice0 : 500
             * orderPrice1 : 300
             * orderSize : 5
             * orderTitle : 【2017年8月15日-五人团】岳麓山两日游
             * orderTransactionCount : 14
             */

            private double avgMark;
            private String orderId;
            private String orderPicture1;
            private int orderPrice0;
            private int orderPrice1;
            private int orderSize;
            private String orderTitle;
            private int orderTransactionCount;

            public double getAvgMark() {
                return avgMark;
            }

            public void setAvgMark(double avgMark) {
                this.avgMark = avgMark;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getOrderPicture1() {
                return orderPicture1;
            }

            public void setOrderPicture1(String orderPicture1) {
                this.orderPicture1 = orderPicture1;
            }

            public int getOrderPrice0() {
                return orderPrice0;
            }

            public void setOrderPrice0(int orderPrice0) {
                this.orderPrice0 = orderPrice0;
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

            public String getOrderTitle() {
                return orderTitle;
            }

            public void setOrderTitle(String orderTitle) {
                this.orderTitle = orderTitle;
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
