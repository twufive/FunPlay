package com.zgtech.funplay.model;

import java.util.List;

/**
 * 首页推荐数据实体
 * Created by Administrator on 2017/8/31.
 */

public class RecommendModel {


    /**
     * code : 2
     * msg : 成功
     * obj : {"addressList":[{"orderId":7,"orderTitle":"【2017年8月20日-五人团】烈士公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":5,"commentCount":1},{"orderId":9,"orderTitle":"火车站十人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":4,"commentCount":2},{"orderId":1,"orderTitle":"【2017年8月15日-五人团】岳麓山两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":4,"commentCount":5},{"orderId":10,"orderTitle":"火车站十人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":0,"commentCount":0},{"orderId":8,"orderTitle":"【2017年8月21日-两人团】植物园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":0,"commentCount":0}],"foodList":[{"orderId":5,"orderTitle":"【2017年8月19日-两人团】洋湖公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":5,"commentCount":2},{"orderId":6,"orderTitle":"【2017年8月20日-两人团】月湖公园两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":4,"commentCount":3},{"orderId":3,"orderTitle":"【2017年8月17日-五人团】橘子洲两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":0,"commentCount":0},{"orderId":2,"orderTitle":"【2017年8月16日-两人团】岳麓山两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":0,"commentCount":0},{"orderId":26,"orderTitle":"火车站十人团两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderPro":"43","userId":12,"userIcon":"upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg","avgMark":0,"commentCount":0}]}
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
        private List<AddressListBean> addressList;
        private List<FoodListBean> foodList;

        public List<AddressListBean> getAddressList() {
            return addressList;
        }

        public void setAddressList(List<AddressListBean> addressList) {
            this.addressList = addressList;
        }

        public List<FoodListBean> getFoodList() {
            return foodList;
        }

        public void setFoodList(List<FoodListBean> foodList) {
            this.foodList = foodList;
        }

        public static class AddressListBean {
            /**
             * orderId : 7
             * orderTitle : 【2017年8月20日-五人团】烈士公园两日游
             * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * orderPro : 43
             * userId : 12
             * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
             * avgMark : 5
             * commentCount : 1
             */

            private int orderId;
            private String orderTitle;
            private String orderPicture1;
            private String orderPro;
            private int userId;
            private String userIcon;
            private int avgMark;
            private int commentCount;

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

            public String getOrderPro() {
                return orderPro;
            }

            public void setOrderPro(String orderPro) {
                this.orderPro = orderPro;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
            }

            public int getAvgMark() {
                return avgMark;
            }

            public void setAvgMark(int avgMark) {
                this.avgMark = avgMark;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }
        }

        public static class FoodListBean {
            /**
             * orderId : 5
             * orderTitle : 【2017年8月19日-两人团】洋湖公园两日游
             * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
             * orderPro : 43
             * userId : 12
             * userIcon : upload/user_img/20170721/0ade284541ed433a8cbaedd845e5f1f1.jpg
             * avgMark : 5
             * commentCount : 2
             */

            private int orderId;
            private String orderTitle;
            private String orderPicture1;
            private String orderPro;
            private int userId;
            private String userIcon;
            private int avgMark;
            private int commentCount;

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

            public String getOrderPro() {
                return orderPro;
            }

            public void setOrderPro(String orderPro) {
                this.orderPro = orderPro;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getUserIcon() {
                return userIcon;
            }

            public void setUserIcon(String userIcon) {
                this.userIcon = userIcon;
            }

            public int getAvgMark() {
                return avgMark;
            }

            public void setAvgMark(int avgMark) {
                this.avgMark = avgMark;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }
        }
    }
}
