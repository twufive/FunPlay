package com.zgtech.funplay.model;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */

public class QueryGuiderModel {


    /**
     * code : 2
     * msg : 成功
     * obj : [{"avgMark":4,"avgPrice":"300.00","commentCount":17,"orders":[{"orderId":9,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"火车站十人团两日游"},{"orderId":8,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月21日-两人团】植物园两日游"},{"orderId":7,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月20日-五人团】烈士公园两日游"},{"orderId":6,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月20日-两人团】月湖公园两日游"},{"orderId":5,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月19日-两人团】洋湖公园两日游"}],"transactionCount":4,"userIcon":"upload/user/img/20170911/30a02f6389bb49349ab698e7ad2ba8e6.jpg","userId":12,"userNick":"趣玩啊","userTag1":0,"userTag2":0,"userVocation1":0,"userVocation2":0},{"avgMark":0,"avgPrice":"0.00","commentCount":0,"orders":[],"transactionCount":0,"userIcon":"upload/default.jpg","userId":46,"userNick":"趣玩-46","userTag1":0,"userTag2":0,"userVocation1":0,"userVocation2":0},{"avgMark":0,"avgPrice":"0.00","commentCount":0,"orders":[],"transactionCount":0,"userIcon":"upload/default.jpg","userId":45,"userNick":"趣玩啊","userTag1":0,"userTag2":0,"userVocation1":0,"userVocation2":0},{"avgMark":0,"avgPrice":"0.00","commentCount":0,"orders":[],"transactionCount":0,"userIcon":"upload/default.jpg","userId":44,"userNick":"趣玩-44","userTag1":0,"userTag2":0,"userVocation1":0,"userVocation2":0},{"avgMark":0,"avgPrice":"0.00","commentCount":0,"orders":[],"transactionCount":0,"userIcon":"upload/default.jpg","userId":43,"userNick":"趣玩-43","userTag1":0,"userTag2":0,"userVocation1":0,"userVocation2":0}]
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
         * avgMark : 4
         * avgPrice : 300.00
         * commentCount : 17
         * orders : [{"orderId":9,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"火车站十人团两日游"},{"orderId":8,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月21日-两人团】植物园两日游"},{"orderId":7,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月20日-五人团】烈士公园两日游"},{"orderId":6,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月20日-两人团】月湖公园两日游"},{"orderId":5,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月19日-两人团】洋湖公园两日游"}]
         * transactionCount : 4
         * userIcon : upload/user/img/20170911/30a02f6389bb49349ab698e7ad2ba8e6.jpg
         * userId : 12
         * userNick : 趣玩啊
         * userTag1 : 0
         * userTag2 : 0
         * userVocation1 : 0
         * userVocation2 : 0
         */

        private int avgMark;
        private String avgPrice;
        private int commentCount;
        private int transactionCount;
        private String userIcon;
        private int userId;
        private String userNick;
        private int userTag1;
        private int userTag2;
        private int userVocation1;
        private int userVocation2;
        private List<OrdersBean> orders;

        public int getAvgMark() {
            return avgMark;
        }

        public void setAvgMark(int avgMark) {
            this.avgMark = avgMark;
        }

        public String getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(String avgPrice) {
            this.avgPrice = avgPrice;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public int getTransactionCount() {
            return transactionCount;
        }

        public void setTransactionCount(int transactionCount) {
            this.transactionCount = transactionCount;
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

        public int getUserVocation1() {
            return userVocation1;
        }

        public void setUserVocation1(int userVocation1) {
            this.userVocation1 = userVocation1;
        }

        public int getUserVocation2() {
            return userVocation2;
        }

        public void setUserVocation2(int userVocation2) {
            this.userVocation2 = userVocation2;
        }

        public List<OrdersBean> getOrders() {
            return orders;
        }

        public void setOrders(List<OrdersBean> orders) {
            this.orders = orders;
        }

        public static class OrdersBean {
            /**
             * orderId : 9
             * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * orderTitle : 火车站十人团两日游
             */

            private int orderId;
            private String orderPicture1;
            private String orderTitle;

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public String getOrderPicture1() {
                return orderPicture1;
            }

            public void setOrderPicture1(String orderPicture1) {
                this.orderPicture1 = orderPicture1;
            }

            public String getOrderTitle() {
                return orderTitle;
            }

            public void setOrderTitle(String orderTitle) {
                this.orderTitle = orderTitle;
            }
        }
    }
}
