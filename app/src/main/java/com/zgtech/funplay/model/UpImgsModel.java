package com.zgtech.funplay.model;

import java.util.List;

/**
 * 批量上传图片返回数据实体
 * Created by Administrator on 2017/7/4.
 */

public class UpImgsModel {
    /**
     * code : 2
     * msg : 成功
     * list : ["user/img/20170704/f834d28241954bb79b935dd3a4af0dca.jpg","user/img/20170704/8243fe5188004726a055e0de31d4aebd.jpg","user/img/20170704/340075dc01de4c3eadc5027a0b1edcd4.jpg"]
     * page : null
     */

    private int code;
    private String msg;
    private Object page;
    private List<String> list;

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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
