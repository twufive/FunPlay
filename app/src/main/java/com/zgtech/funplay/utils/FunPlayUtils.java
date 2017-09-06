package com.zgtech.funplay.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 趣玩公用工具类
 * Created by Administrator on 2017/9/6.
 */

public class FunPlayUtils {

    /**
     * 将订单中的状态码转换成对应的中文字符串
     * */
    public static String code2StrState(int stateCode) {
        String strState = "";
        switch (stateCode){
            case 0:
                strState = "待发布";
                break;
            case 1:
                strState = "发布中";
                break;
            case 2:
                strState = "已撤回";
                break;
            case 3:
                strState = "已交易";
                break;

        }
        return strState;
    }

    /**
     * 将long值转换成时间的字符串值
     * */
    public static String long2str(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dt = new Date(time);
        String sDateTime = sdf.format(dt);

        return sDateTime;
    }
}
