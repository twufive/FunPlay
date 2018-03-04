package com.zgtech.funplay.model;

/**
 * Created by Juice on 2018-3-3.
 */

public class QualityFoodDetailModel {


    /**
     * code : 2
     * msg : 成功
     * obj : {"foodId":2,"name":"糖油粑粑","descript":"当地美食","cover":"/upload/1516876830982.jpg","orderNum":"2","createTime":1518417381000}
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
         * foodId : 2
         * name : 糖油粑粑
         * descript : 当地美食
         * cover : /upload/1516876830982.jpg
         * orderNum : 2
         * createTime : 1518417381000
         */

        private int foodId;
        private String name;
        private String descript;
        private String cover;
        private String orderNum;
        private long createTime;

        public int getFoodId() {
            return foodId;
        }

        public void setFoodId(int foodId) {
            this.foodId = foodId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescript() {
            return descript;
        }

        public void setDescript(String descript) {
            this.descript = descript;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getOrderNum() {
            return orderNum;
        }

        public void setOrderNum(String orderNum) {
            this.orderNum = orderNum;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }
    }
}
