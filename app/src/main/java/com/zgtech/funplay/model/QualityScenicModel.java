package com.zgtech.funplay.model;

import java.util.List;

/**
 * Created by Juice on 2018-3-3.
 */

public class QualityScenicModel {


    /**
     * code : 2
     * msg : 成功
     * list : [{"viewId":3,"name":"武功山","descript":"风景秀丽","cover":"/upload/1516875121805.jpg","orderNum":"1","createTime":1518417399000},{"viewId":2,"name":"橘子洲","descript":"湘江中心","cover":"/upload/1516876694790.jpg","orderNum":"2","createTime":1518417399000}]
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
         * viewId : 3
         * name : 武功山
         * descript : 风景秀丽
         * cover : /upload/1516875121805.jpg
         * orderNum : 1
         * createTime : 1518417399000
         */

        private int viewId;
        private String name;
        private String descript;
        private String cover;
        private String orderNum;
        private long createTime;

        public int getViewId() {
            return viewId;
        }

        public void setViewId(int viewId) {
            this.viewId = viewId;
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
