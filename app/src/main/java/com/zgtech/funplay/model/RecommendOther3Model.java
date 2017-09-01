package com.zgtech.funplay.model;

import java.util.List;

/**
 * 首页除去推荐，的其他数据实体
 * Created by Administrator on 2017/8/31.
 */

public class RecommendOther3Model {


    /**
     * code : 2
     * msg : 成功
     * obj : [{"userId":12,"userNick":"cast.zhou","userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userTag1":0,"userTag2":0,"avgPrice":"300.00","avgMark":4,"userVocation1":1,"userVocation2":0,"transactionCount":2,"commentCount":17,"orders":[{"orderId":9,"orderTitle":"火车站十人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":8,"orderTitle":"【2017年8月21日-两人团】植物园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":7,"orderTitle":"【2017年8月20日-五人团】烈士公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":6,"orderTitle":"【2017年8月20日-两人团】月湖公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":5,"orderTitle":"【2017年8月19日-两人团】洋湖公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"}]},{"userId":42,"userNick":"趣玩-42","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0,"userVocation1":0,"userVocation2":0,"transactionCount":0,"commentCount":0,"orders":[]},{"userId":41,"userNick":"趣玩-41","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0,"userVocation1":0,"userVocation2":0,"transactionCount":0,"commentCount":0,"orders":[]},{"userId":40,"userNick":"趣玩-40","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0,"userVocation1":0,"userVocation2":0,"transactionCount":0,"commentCount":0,"orders":[]},{"userId":39,"userNick":"趣玩-39","userIcon":"upload/default.jpg","userTag1":0,"userTag2":0,"avgPrice":"0.00","avgMark":0,"userVocation1":0,"userVocation2":0,"transactionCount":0,"commentCount":0,"orders":[]}]
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
         * userVocation1 : 1
         * userVocation2 : 0
         * transactionCount : 2
         * commentCount : 17
         * orders : [{"orderId":9,"orderTitle":"火车站十人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":8,"orderTitle":"【2017年8月21日-两人团】植物园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":7,"orderTitle":"【2017年8月20日-五人团】烈士公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":6,"orderTitle":"【2017年8月20日-两人团】月湖公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":5,"orderTitle":"【2017年8月19日-两人团】洋湖公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"}]
         */

        private int userId;
        private String userNick;
        private String userIcon;
        private int userTag1;
        private int userTag2;
        private String avgPrice;
        private int avgMark;
        private int userVocation1;
        private int userVocation2;
        private int transactionCount;
        private int commentCount;
        private List<OrdersBean> orders;

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

        public int getTransactionCount() {
            return transactionCount;
        }

        public void setTransactionCount(int transactionCount) {
            this.transactionCount = transactionCount;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
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
             * orderTitle : 火车站十人团两日游
             * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             */

            private int orderId;
            private String orderTitle;
            private String orderPicture1;

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

            public String getOrderPicture1() {
                return orderPicture1;
            }

            public void setOrderPicture1(String orderPicture1) {
                this.orderPicture1 = orderPicture1;
            }
        }
    }
}
