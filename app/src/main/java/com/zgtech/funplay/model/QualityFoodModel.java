package com.zgtech.funplay.model;

import java.util.List;

/**
 * Created by Juice on 2018-3-3.
 */

public class QualityFoodModel {


    /**
     * code : 2
     * msg : 成功
     * list : [{"foodId":1,"name":"长沙臭豆腐","descript":"当地美食","cover":"/upload/1516876812672.jpg","orderNum":"1","createTime":1518417381000},{"foodId":2,"name":"糖油粑粑","descript":"当地美食","cover":"/upload/1516876830982.jpg","orderNum":"2","createTime":1518417381000},{"foodId":3,"name":"槟榔","descript":"百年老店","cover":"/upload/1516876930565.jpg","orderNum":"3","createTime":1518417381000}]
     * page : null
     */

    private int code;
    private String msg;
    private Object page;
    private List<ListBean> list;

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

    public Object getPage() {
        return page;
    }

    public void setPage(Object page) {
        this.page = page;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * foodId : 1
         * name : 长沙臭豆腐
         * descript : 当地美食
         * cover : /upload/1516876812672.jpg
         * orderNum : 1
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
