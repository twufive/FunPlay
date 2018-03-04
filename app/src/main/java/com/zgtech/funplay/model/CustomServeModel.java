package com.zgtech.funplay.model;

import java.util.List;

/**
 * Created by Juice on 2018-3-4.
 */

public class CustomServeModel {


    /**
     * code : 2
     * msg : 成功
     * list : [{"id":2,"type":"qq","name":"客服1","val":"55411224"},{"id":3,"type":"qq","name":"客服2","val":"44215722"}]
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
         * id : 2
         * type : qq
         * name : 客服1
         * val : 55411224
         */

        private int id;
        private String type;
        private String name;
        private String val;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }
    }
}
