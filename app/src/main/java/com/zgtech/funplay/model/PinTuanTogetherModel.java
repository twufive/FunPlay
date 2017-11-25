package com.zgtech.funplay.model;

import java.util.List;

/**
 * 一起拼团列表的数据实体，核心界面
 * Created by Administrator on 2017/9/1.
 */
public class PinTuanTogetherModel {
    /**
     * code : 2
     * msg : 成功
     * obj : [{"orderTitle":"【2017年8月15日-五人团】岳麓山两日游","orderPicture1":"upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg","orderSize":5,"orderPrice1":300,"orderPrice0":500,"avgMark":4.3,"orderTransactionCount":4}]
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
         * orderTitle : 【2017年8月15日-五人团】岳麓山两日游
         * orderPicture1 : upload/user_img/20170703/8322fe273d3743f4a3867e267f6986eb.jpg
         * orderSize : 5
         * orderPrice1 : 300
         * orderPrice0 : 500
         * avgMark : 4.3
         * orderTransactionCount : 4
         */

        private String orderId;
        private String orderTitle;
        private String orderPicture1;
        private int orderSize;
        private double orderPrice1;
        private double orderPrice0;
        private double avgMark;
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

        public double getOrderPrice1() {
            return orderPrice1;
        }

        public void setOrderPrice1(double orderPrice1) {
            this.orderPrice1 = orderPrice1;
        }

        public double getOrderPrice0() {
            return orderPrice0;
        }

        public void setOrderPrice0(double orderPrice0) {
            this.orderPrice0 = orderPrice0;
        }

        public double getAvgMark() {
            return avgMark;
        }

        public void setAvgMark(double avgMark) {
            this.avgMark = avgMark;
        }

        public int getOrderTransactionCount() {
            return orderTransactionCount;
        }

        public void setOrderTransactionCount(int orderTransactionCount) {
            this.orderTransactionCount = orderTransactionCount;
        }
    }

    @Override
    public String toString() {
        return "PinTuanTogetherModel{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", obj=" + obj +
                '}';
    }
}
