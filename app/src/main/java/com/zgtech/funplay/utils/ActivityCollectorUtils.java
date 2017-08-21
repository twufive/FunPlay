package com.zgtech.funplay.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zayin on 2016/05/03
 * TIME 10:00
 */
public class ActivityCollectorUtils {

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public static void finishAll(){
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
