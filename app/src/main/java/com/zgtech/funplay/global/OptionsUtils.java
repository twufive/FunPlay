package com.zgtech.funplay.global;

import android.content.Context;
import android.view.View;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * 各种条件选择器的工具类,并将选择后的结果回调到UI界面，一供页面显示，二供提交使用。
 * Created by Administrator on 2017/3/15.
 */

public class OptionsUtils {
    public static OptionsPickerView pvOptions;

    public interface OptionsCallback {
        void onSelectComleted(String result);
    }

    public interface OptionsLocCallback {
        void onSelectComleted(String strProvince, String strCity, String strArea, String strCodeProvince, String strCodeCity, String strCodeArea);
    }


    /**
     * 性别，男1女2
     */
    public static void showSexOptions(Context context, final OptionsCallback optionsCallback) {
        final ArrayList<String> sexList = new ArrayList<>();
        sexList.add("男");
        sexList.add("女");

        pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                String strStature = String.valueOf(sexList.get(options1));
                if (optionsCallback != null) {
                    optionsCallback.onSelectComleted(strStature);
                }
            }
        })
                .setSelectOptions(0)
                .setCancelText("取消")
                .setSubmitText("确认")
                .build();
        pvOptions.setPicker(sexList);
        pvOptions.show();
    }


    /**
     * 性别，男1女2
     */
    public static void showConstellationOptions(Context context, final OptionsCallback optionsCallback) {
        final ArrayList<String> constellationList = new ArrayList<>();
        constellationList.add("白羊座");
        constellationList.add("金牛座");
        constellationList.add("双子座");
        constellationList.add("巨蟹座");
        constellationList.add("狮子座");
        constellationList.add("处女座");
        constellationList.add("天秤座");
        constellationList.add("天蝎座");
        constellationList.add("射手座");
        constellationList.add("摩羯座");
        constellationList.add("水瓶座");
        constellationList.add("双鱼座");

        pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
//                String strStature = String.valueOf(sexList.get(options1));
                int constellationCode = options1 + 1;
                String strStature = String.valueOf(constellationList.get(options1) + "," + constellationCode);
                if (optionsCallback != null) {
                    optionsCallback.onSelectComleted(strStature);
                }
            }
        })
                .setSelectOptions(0)
                .setCancelText("取消")
                .setSubmitText("确认")
                .build();
        pvOptions.setPicker(constellationList);
        pvOptions.show();
    }


    /**
     * 年龄显示，从18岁到99岁
     */
    public static void showAgeOptions(Context context, final OptionsCallback optionsCallback) {
        final ArrayList<Integer> statureList = new ArrayList<>();
        for (int i = 18; i < 100; i++) {
            statureList.add(i);
        }
        pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                String strStature = String.valueOf(statureList.get(options1));
                if (optionsCallback != null) {
                    optionsCallback.onSelectComleted(strStature);
                }
            }
        })
                .setSelectOptions(1)
                .setCancelText("取消")
                .setSubmitText("确认")
                .build();
        pvOptions.setPicker(statureList);
        pvOptions.show();
    }

    /**
     * 身高显示从130cm，到210cm
     */
    public static void showStatureOptions(Context context, final OptionsCallback optionsCallback) {
        final ArrayList<Integer> statureList = new ArrayList<>();
        for (int i = 130; i < 211; i++) {
            statureList.add(i);
        }
        pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                String strStature = String.valueOf(statureList.get(options1));
                if (optionsCallback != null) {
                    optionsCallback.onSelectComleted(strStature);
                }
            }
        })
                .setSelectOptions(40)
                .setTitleText("单位：cm")
                .setCancelText("取消")
                .setSubmitText("确认")
                .build();
        pvOptions.setPicker(statureList);
        pvOptions.show();
    }


    /**
     * 体重显示，从25kg到200kg
     */
    public static void showWeightOptions(Context context, final OptionsCallback optionsCallback) {
        final ArrayList<Integer> statureList = new ArrayList<>();
        for (int i = 25; i < 200; i++) {
            statureList.add(i);
        }
        pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                String strStature = String.valueOf(statureList.get(options1));
                if (optionsCallback != null) {
                    optionsCallback.onSelectComleted(strStature);
                }
            }
        })
                .setSelectOptions(25)
                .setTitleText("单位：kg")
                .setCancelText("取消")
                .setSubmitText("确认")
                .build();
        pvOptions.setPicker(statureList);
        pvOptions.show();
    }

    /**
     * 生日显示从1900，到2017
     */
    public static void showBirthOptions(Context context, final OptionsCallback optionsCallback) {
        //时间选择器
        Calendar selectedDate = Calendar.getInstance();
        selectedDate.set(1998, 1, 1);
        Calendar startDate = Calendar.getInstance();
        startDate.set(1900, 1, 1);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2015, 12, 12);

        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String strBirthday = sdf.format(date);
                if (optionsCallback != null) {
                    optionsCallback.onSelectComleted(strBirthday);
                }
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setRangDate(startDate, endDate)//起始终止年月日设定
                .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
                .setCancelText("取消")
                .setSubmitText("确认")
                .build();
        pvTime.show();
    }

}
