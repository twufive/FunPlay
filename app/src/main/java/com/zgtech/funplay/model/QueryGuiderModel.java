package com.zgtech.funplay.model;

import java.util.List;

/**
 * Created by Administrator on 2017/9/13.
 */

public class QueryGuiderModel {


    /**
     * code : 2
     * msg : 成功
     * obj : [{"userId":12,"userNick":"haha","userIcon":"upload/user/img/20171115/5c7f117b3c53427a850e21e69ef2594f.jpg","userTag1":"","userTag2":"","avgPrice":13.39,"avgMark":0,"userVocation1":"","userVocation2":"","transactionCount":52,"commentCount":0,"orders":[{"orderId":51,"orderTitle":"WuHan","orderPicture1":"upload/user/img/20171114/ec5e1c1c46fd4c09b72b67ec220214ca.jpg"},{"orderId":48,"orderTitle":"岳麓山两五人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":47,"orderTitle":"111","orderPicture1":"upload/user/img/20171111/97bfe2eac8c4459a8229ec859ee5ab16.jpg"},{"orderId":46,"orderTitle":"岳麓山两五人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":45,"orderTitle":"testtste","orderPicture1":""}]},{"userId":69,"userNick":"哒哒哒","userIcon":"upload/default.jpg","userTag1":"0","userTag2":"0","avgPrice":0,"avgMark":0,"userVocation1":"0","userVocation2":"0","transactionCount":0,"commentCount":0,"orders":[]},{"userId":68,"userNick":"趣玩-68","userIcon":"upload/default.jpg","userTag1":"0","userTag2":"0","avgPrice":0,"avgMark":0,"userVocation1":"0","userVocation2":"0","transactionCount":0,"commentCount":0,"orders":[]},{"userId":67,"userNick":"趣玩-67","userIcon":"upload/default.jpg","userTag1":"0","userTag2":"0","avgPrice":0,"avgMark":0,"userVocation1":"0","userVocation2":"0","transactionCount":0,"commentCount":0,"orders":[]},{"userId":66,"userNick":"趣玩-66","userIcon":"upload/default.jpg","userTag1":"0","userTag2":"0","avgPrice":0,"avgMark":0,"userVocation1":"0","userVocation2":"0","transactionCount":0,"commentCount":0,"orders":[]}]
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
         * userNick : haha
         * userIcon : upload/user/img/20171115/5c7f117b3c53427a850e21e69ef2594f.jpg
         * userTag1 :
         * userTag2 :
         * avgPrice : 13.39
         * avgMark : 0
         * userVocation1 :
         * userVocation2 :
         * transactionCount : 52
         * commentCount : 0
         * orders : [{"orderId":51,"orderTitle":"WuHan","orderPicture1":"upload/user/img/20171114/ec5e1c1c46fd4c09b72b67ec220214ca.jpg"},{"orderId":48,"orderTitle":"岳麓山两五人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":47,"orderTitle":"111","orderPicture1":"upload/user/img/20171111/97bfe2eac8c4459a8229ec859ee5ab16.jpg"},{"orderId":46,"orderTitle":"岳麓山两五人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg"},{"orderId":45,"orderTitle":"testtste","orderPicture1":""}]
         */

        private int userId;
        private String userNick;
        private String userIcon;
        private String userTag1;
        private String userTag2;
        private double avgPrice;
        private int avgMark;
        private String userVocation1;
        private String userVocation2;
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

        public double getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(double avgPrice) {
            this.avgPrice = avgPrice;
        }

        public int getAvgMark() {
            return avgMark;
        }

        public void setAvgMark(int avgMark) {
            this.avgMark = avgMark;
        }

        public String getUserVocation1() {
            return userVocation1;
        }

        public void setUserVocation1(String userVocation1) {
            this.userVocation1 = userVocation1;
        }

        public String getUserVocation2() {
            return userVocation2;
        }

        public void setUserVocation2(String userVocation2) {
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
             * orderId : 51
             * orderTitle : WuHan
             * orderPicture1 : upload/user/img/20171114/ec5e1c1c46fd4c09b72b67ec220214ca.jpg
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
