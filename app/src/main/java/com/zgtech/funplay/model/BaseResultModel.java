package com.zgtech.funplay.model;

/**
 * 基础返回数据实体
 * Created by Administrator on 2017/3/22.
 */

public class BaseResultModel {
    /**
     * code : 2
     * msg : 操作成功
     */
    private int code;
    private String msg;

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

    @Override
    public String toString() {
        return "BaseResultModel{" + "code=" + code + ", msg='" + msg + '\'' + '}';
    }
}
