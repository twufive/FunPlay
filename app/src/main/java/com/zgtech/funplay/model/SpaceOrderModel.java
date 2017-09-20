package com.zgtech.funplay.model;

import java.util.List;

/**
 * 旅游圈发布说说时，需要用到的订单列表
 * Created by Administrator on 2017/9/18.
 */

public class SpaceOrderModel {

    /**
     * code : 2
     * msg : 成功
     * obj : [{"orderId":41,"orderTitle":"岳麓山两五4rrfrer人团两日游","orderPirce1":0,"orderSize":5},{"orderId":40,"orderTitle":"岳麓山两五人团两日游","orderPirce1":0,"orderSize":5},{"orderId":39,"orderTitle":"Changsha","orderPirce1":0,"orderSize":5},{"orderId":9,"orderTitle":"火车站十人团两日游","orderPirce1":0,"orderSize":10},{"orderId":8,"orderTitle":"【2017年8月21日-两人团】植物园两日游","orderPirce1":0,"orderSize":2},{"orderId":7,"orderTitle":"【2017年8月20日-五人团】烈士公园两日游","orderPirce1":0,"orderSize":5},{"orderId":6,"orderTitle":"【2017年8月20日-两人团】月湖公园两日游","orderPirce1":0,"orderSize":2},{"orderId":5,"orderTitle":"【2017年8月19日-两人团】洋湖公园两日游","orderPirce1":0,"orderSize":2},{"orderId":4,"orderTitle":"【2017年8月18日-两人团】梅西湖两日游","orderPirce1":0,"orderSize":2},{"orderId":3,"orderTitle":"【2017年8月17日-五人团】橘子洲两日游","orderPirce1":0,"orderSize":5},{"orderId":2,"orderTitle":"【2017年8月16日-两人团】岳麓山两日游","orderPirce1":0,"orderSize":2},{"orderId":1,"orderTitle":"【2017年8月15日-五人团】岳麓山两日游","orderPirce1":0,"orderSize":5}]
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
         * orderId : 41
         * orderTitle : 岳麓山两五4rrfrer人团两日游
         * orderPirce1 : 0
         * orderSize : 5
         */

        private int orderId;
        private String orderTitle;
        private int orderPirce1;
        private int orderSize;

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

        public int getOrderPirce1() {
            return orderPirce1;
        }

        public void setOrderPirce1(int orderPirce1) {
            this.orderPirce1 = orderPirce1;
        }

        public int getOrderSize() {
            return orderSize;
        }

        public void setOrderSize(int orderSize) {
            this.orderSize = orderSize;
        }
    }
}
