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
     * obj : [{"avgMark":4,"avgPrice":300,"commentCount":17,"orders":[{"orderId":41,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"岳麓山两五4rrfrer人团两日游"},{"orderId":40,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"岳麓山两五人团两日游"},{"orderId":39,"orderPicture1":"upload/user/img/20170913/da28855d85a643e288cd45a95c71f143.jpg","orderTitle":"Changsha"},{"orderId":9,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"火车站十人团两日游"},{"orderId":8,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月21日-两人团】植物园两日游"}],"transactionCount":18,"userIcon":"upload/user/img/20170913/93a7bc97856b4f84a368e520960e3166.jpg","userId":12,"userNick":"趣玩啊","userTag1":"","userTag2":"","userVocation1":"","userVocation2":""},{"avgMark":0,"avgPrice":0,"commentCount":0,"orders":[],"transactionCount":0,"userIcon":"upload/default.jpg","userId":53,"userNick":"趣玩啊","userTag1":"0","userTag2":"0","userVocation1":"升级了","userVocation2":""},{"avgMark":0,"avgPrice":0,"commentCount":0,"orders":[],"transactionCount":0,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","userId":52,"userNick":"cast18507455265","userTag1":"0","userTag2":"0","userVocation1":"哈哈哈","userVocation2":"嘿嘿嘿"},{"avgMark":0,"avgPrice":0,"commentCount":0,"orders":[],"transactionCount":0,"userIcon":"upload/default.jpg","userId":51,"userNick":"趣玩-51","userTag1":"0","userTag2":"0","userVocation1":"0","userVocation2":"0"}]
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
         * avgPrice : 300
         * commentCount : 17
         * orders : [{"orderId":41,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"岳麓山两五4rrfrer人团两日游"},{"orderId":40,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"岳麓山两五人团两日游"},{"orderId":39,"orderPicture1":"upload/user/img/20170913/da28855d85a643e288cd45a95c71f143.jpg","orderTitle":"Changsha"},{"orderId":9,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"火车站十人团两日游"},{"orderId":8,"orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderTitle":"【2017年8月21日-两人团】植物园两日游"}]
         * transactionCount : 18
         * userIcon : upload/user/img/20170913/93a7bc97856b4f84a368e520960e3166.jpg
         * userId : 12
         * userNick : 趣玩啊
         * userTag1 :
         * userTag2 :
         * userVocation1 :
         * userVocation2 :
         */

        private int avgMark;
        private int avgPrice;
        private int commentCount;
        private int transactionCount;
        private String userIcon;
        private int userId;
        private String userNick;
        private String userTag1;
        private String userTag2;
        private String userVocation1;
        private String userVocation2;
        private List<OrdersBean> orders;

        public int getAvgMark() {
            return avgMark;
        }

        public void setAvgMark(int avgMark) {
            this.avgMark = avgMark;
        }

        public int getAvgPrice() {
            return avgPrice;
        }

        public void setAvgPrice(int avgPrice) {
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

        public List<OrdersBean> getOrders() {
            return orders;
        }

        public void setOrders(List<OrdersBean> orders) {
            this.orders = orders;
        }

        public static class OrdersBean {
            /**
             * orderId : 41
             * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * orderTitle : 岳麓山两五4rrfrer人团两日游
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
