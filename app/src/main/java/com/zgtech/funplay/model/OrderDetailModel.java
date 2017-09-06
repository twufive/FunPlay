package com.zgtech.funplay.model;

import java.util.List;

/**
 * 某个订单详情
 * Created by Administrator on 2017/9/4.
 */

public class OrderDetailModel {

    /**
     * code : 2
     * msg : 成功
     * obj : {"orderId":1,"userId":12,"orderTitle":"【2017年8月15日-五人团】岳麓山两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPicture2":"","orderPicture3":"","orderPicture4":"","orderPicture5":"","orderPicture6":"","orderPicture7":"","orderPicture8":"","orderPicture9":"","orderContent":"【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。","orderPrice1":300,"orderPrice0":500,"orderSize":5,"orderPro":"43","orderTrip":"【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。","orderAttention":"【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。","orderRemark":"【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。","orderCity":"43_01","orderCou":"43_01_04","orderWeek":"60","orderTime":0,"orderPhone":"15073001217","orderContact":"周先生","state":1,"modifyTime":1503310011000,"introduceTime":1503244800000,"orderIdAgain":0,"comments":[{"commentId":5,"userId":0,"commentUserId":16,"commentUserNick":"趣玩-16","orderId":1,"commentMark":4,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":4,"userId":0,"commentUserId":15,"commentUserNick":"趣玩-15","orderId":1,"commentMark":4,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":3,"userId":0,"commentUserId":14,"commentUserNick":"趣玩-14","orderId":1,"commentMark":3,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":2,"userId":0,"commentUserId":13,"commentUserNick":"趣玩-13","orderId":1,"commentMark":4,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":1,"userId":0,"commentUserId":13,"commentUserNick":"趣玩-13","orderId":1,"commentMark":5,"commentPicture":"[\"upload/user_img/20170721/1e47bdd89e214e738a81157379567689.jpg\"]","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1}],"avgMark":0,"commentCounts":0,"goodCounts":0}
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
         * orderId : 1
         * userId : 12
         * orderTitle : 【2017年8月15日-五人团】岳麓山两日游
         * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
         * orderPicture2 :
         * orderPicture3 :
         * orderPicture4 :
         * orderPicture5 :
         * orderPicture6 :
         * orderPicture7 :
         * orderPicture8 :
         * orderPicture9 :
         * orderContent : 【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。
         * orderPrice1 : 300
         * orderPrice0 : 500
         * orderSize : 5
         * orderPro : 43
         * orderTrip : 【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。
         * orderAttention : 【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。
         * orderRemark : 【2017年8月15日】【五人团】岳麓山两日游,湖南18妹子做导游，原价5百块，现在3百块，贵不贵？意不意外？惊不惊喜？速速报名。
         * orderCity : 43_01
         * orderCou : 43_01_04
         * orderWeek : 60
         * orderTime : 0
         * orderPhone : 15073001217
         * orderContact : 周先生
         * state : 1
         * modifyTime : 1503310011000
         * introduceTime : 1503244800000
         * orderIdAgain : 0
         * comments : [{"commentId":5,"userId":0,"commentUserId":16,"commentUserNick":"趣玩-16","orderId":1,"commentMark":4,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":4,"userId":0,"commentUserId":15,"commentUserNick":"趣玩-15","orderId":1,"commentMark":4,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":3,"userId":0,"commentUserId":14,"commentUserNick":"趣玩-14","orderId":1,"commentMark":3,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":2,"userId":0,"commentUserId":13,"commentUserNick":"趣玩-13","orderId":1,"commentMark":4,"commentPicture":"","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1},{"commentId":1,"userId":0,"commentUserId":13,"commentUserNick":"趣玩-13","orderId":1,"commentMark":5,"commentPicture":"[\"upload/user_img/20170721/1e47bdd89e214e738a81157379567689.jpg\"]","commentRemark":"对cast.zhou说：满星好评","modifyTime":1503310011000,"state":1}]
         * avgMark : 0
         * commentCounts : 0
         * goodCounts : 0
         */

        private int orderId;
        private int userId;
        private String orderTitle;
        private String orderPicture1;
        private String orderPicture2;
        private String orderPicture3;
        private String orderPicture4;
        private String orderPicture5;
        private String orderPicture6;
        private String orderPicture7;
        private String orderPicture8;
        private String orderPicture9;
        private String orderContent;
        private int orderPrice1;
        private int orderPrice0;
        private int orderSize;
        private String orderPro;
        private String orderTrip;
        private String orderAttention;
        private String orderRemark;
        private String orderCity;
        private String orderCou;
        private String orderWeek;
        private int orderTime;
        private String orderPhone;
        private String orderContact;
        private int state;
        private long modifyTime;
        private long introduceTime;
        private int orderIdAgain;
        private int avgMark;
        private int commentCounts;
        private int goodCounts;
        private List<CommentsBean> comments;

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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

        public String getOrderPicture2() {
            return orderPicture2;
        }

        public void setOrderPicture2(String orderPicture2) {
            this.orderPicture2 = orderPicture2;
        }

        public String getOrderPicture3() {
            return orderPicture3;
        }

        public void setOrderPicture3(String orderPicture3) {
            this.orderPicture3 = orderPicture3;
        }

        public String getOrderPicture4() {
            return orderPicture4;
        }

        public void setOrderPicture4(String orderPicture4) {
            this.orderPicture4 = orderPicture4;
        }

        public String getOrderPicture5() {
            return orderPicture5;
        }

        public void setOrderPicture5(String orderPicture5) {
            this.orderPicture5 = orderPicture5;
        }

        public String getOrderPicture6() {
            return orderPicture6;
        }

        public void setOrderPicture6(String orderPicture6) {
            this.orderPicture6 = orderPicture6;
        }

        public String getOrderPicture7() {
            return orderPicture7;
        }

        public void setOrderPicture7(String orderPicture7) {
            this.orderPicture7 = orderPicture7;
        }

        public String getOrderPicture8() {
            return orderPicture8;
        }

        public void setOrderPicture8(String orderPicture8) {
            this.orderPicture8 = orderPicture8;
        }

        public String getOrderPicture9() {
            return orderPicture9;
        }

        public void setOrderPicture9(String orderPicture9) {
            this.orderPicture9 = orderPicture9;
        }

        public String getOrderContent() {
            return orderContent;
        }

        public void setOrderContent(String orderContent) {
            this.orderContent = orderContent;
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

        public int getOrderSize() {
            return orderSize;
        }

        public void setOrderSize(int orderSize) {
            this.orderSize = orderSize;
        }

        public String getOrderPro() {
            return orderPro;
        }

        public void setOrderPro(String orderPro) {
            this.orderPro = orderPro;
        }

        public String getOrderTrip() {
            return orderTrip;
        }

        public void setOrderTrip(String orderTrip) {
            this.orderTrip = orderTrip;
        }

        public String getOrderAttention() {
            return orderAttention;
        }

        public void setOrderAttention(String orderAttention) {
            this.orderAttention = orderAttention;
        }

        public String getOrderRemark() {
            return orderRemark;
        }

        public void setOrderRemark(String orderRemark) {
            this.orderRemark = orderRemark;
        }

        public String getOrderCity() {
            return orderCity;
        }

        public void setOrderCity(String orderCity) {
            this.orderCity = orderCity;
        }

        public String getOrderCou() {
            return orderCou;
        }

        public void setOrderCou(String orderCou) {
            this.orderCou = orderCou;
        }

        public String getOrderWeek() {
            return orderWeek;
        }

        public void setOrderWeek(String orderWeek) {
            this.orderWeek = orderWeek;
        }

        public int getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(int orderTime) {
            this.orderTime = orderTime;
        }

        public String getOrderPhone() {
            return orderPhone;
        }

        public void setOrderPhone(String orderPhone) {
            this.orderPhone = orderPhone;
        }

        public String getOrderContact() {
            return orderContact;
        }

        public void setOrderContact(String orderContact) {
            this.orderContact = orderContact;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public long getIntroduceTime() {
            return introduceTime;
        }

        public void setIntroduceTime(long introduceTime) {
            this.introduceTime = introduceTime;
        }

        public int getOrderIdAgain() {
            return orderIdAgain;
        }

        public void setOrderIdAgain(int orderIdAgain) {
            this.orderIdAgain = orderIdAgain;
        }

        public int getAvgMark() {
            return avgMark;
        }

        public void setAvgMark(int avgMark) {
            this.avgMark = avgMark;
        }

        public int getCommentCounts() {
            return commentCounts;
        }

        public void setCommentCounts(int commentCounts) {
            this.commentCounts = commentCounts;
        }

        public int getGoodCounts() {
            return goodCounts;
        }

        public void setGoodCounts(int goodCounts) {
            this.goodCounts = goodCounts;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
        }

        public static class CommentsBean {
            /**
             * commentId : 5
             * userId : 0
             * commentUserId : 16
             * commentUserNick : 趣玩-16
             * orderId : 1
             * commentMark : 4
             * commentPicture :
             * commentRemark : 对cast.zhou说：满星好评
             * modifyTime : 1503310011000
             * state : 1
             */

            private int commentId;
            private int userId;
            private int commentUserId;
            private String commentUserNick;
            private int orderId;
            private int commentMark;
            private String commentPicture;
            private String commentRemark;
            private long modifyTime;
            private int state;

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
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

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getCommentMark() {
                return commentMark;
            }

            public void setCommentMark(int commentMark) {
                this.commentMark = commentMark;
            }

            public String getCommentPicture() {
                return commentPicture;
            }

            public void setCommentPicture(String commentPicture) {
                this.commentPicture = commentPicture;
            }

            public String getCommentRemark() {
                return commentRemark;
            }

            public void setCommentRemark(String commentRemark) {
                this.commentRemark = commentRemark;
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
    }
}
