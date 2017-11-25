package com.zgtech.funplay.retrofit;

import android.content.Context;

import com.google.gson.Gson;
import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.utils.SP;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * 发送给后台的数据类型封装，json
 * Created by Administrator on 2017/3/7.
 */

public class RequestBodyBuilder {

    public static RequestBody build(HashMap<Object, Object> map) {
        Context context = FunPlayApplication.getContext();
        String androidToken = SP.getString(context, "androidToken", "");

        map.put("androidToken",androidToken);

        Gson gson = new Gson();
        String toJson = gson.toJson(map);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), toJson);
        return body;
    }
}
