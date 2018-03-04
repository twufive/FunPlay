package com.zgtech.funplay.model;

/**
 * Created by Juice on 2018-3-3.
 */

public class QualityScenicDetailModel {


    /**
     * code : 2
     * msg : 成功
     * obj : {"viewId":2,"name":"橘子洲","descript":"湘江中心","cover":"/upload/1516876694790.jpg","orderNum":"2","createTime":1518417399000}
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
         * viewId : 2
         * name : 橘子洲
         * descript : 湘江中心
         * cover : /upload/1516876694790.jpg
         * orderNum : 2
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
