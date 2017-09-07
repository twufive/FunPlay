package com.zgtech.funplay.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 趣玩公用工具类
 * Created by Administrator on 2017/9/6.
 */

public class FunPlayUtils {

    /**
     * 将long值转换成时间的字符串值
     * */
    public static String long2str(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date dt = new Date(time);
        String sDateTime = sdf.format(dt);

        return sDateTime;
    }

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
     * 将星座的状态码转换成对应的星座字符串
     * */
    public static String code2StrConstellation(int constellationCode) {
        String str = "";
        switch (constellationCode){
            case 0:
                str = "未填写";
                break;
            case 1:
                str = "白羊座";
                break;
            case 2:
                str = "金牛座";
                break;
            case 3:
                str = "双子座";
                break;
            case 4:
                str = "巨蟹座";
                break;
            case 5:
                str = "狮子座";
                break;
            case 6:
                str = "处女座";
                break;
            case 7:
                str = "天秤座";
                break;
            case 8:
                str = "天蝎座";
                break;
            case 9:
                str = "射手座";
                break;
            case 10:
                str = "摩羯座";
                break;
            case 11:
                str = "水瓶座";
                break;
            case 12:
                str = "双鱼座";
                break;
        }
        return str;
    }


}
