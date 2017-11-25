package com.zgtech.funplay.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * PermissionUtils
 * 6.0以上系统获取权限的工具类
 * Created by Administrator on 2017/11/17.
 */

public class P {
    public static int REQUEST_CODE = 100;

    public static void initPerMissions(Activity act, String[] permissions) {
        /**检查还有哪些权限还没有授予*/
        List<String> permissionList = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(act, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permissions[i]);
            }
        }

        if (!permissionList.isEmpty()) {
            String[] permissionsNotGranted = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(act, permissionsNotGranted, REQUEST_CODE);
        }
    }
}
