package com.zgtech.funplay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.HashMap;

/**
 * Created by zayin on 2016/4/4.
 * Time:04月04日   11:01
 */
public class SP {
    public static void setString(Context ctx, String key, String value) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        sp.edit().putString(key, value).commit();
    }

    public static String getString(Context ctx, String key, String defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }


    public static boolean getBoolean(Context ctx, String key, boolean defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void setBoolean(Context ctx, String key, boolean value) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, value).commit();
    }


    public static void setInt(Context ctx, String key, int value) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        sp.edit().putInt(key, value).commit();
    }

    public static int getInt(Context ctx, String key, int defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void setLong(Context ctx, String key, Long value) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        sp.edit().putLong(key, value).commit();
    }

    public static Long getLong(Context ctx, String key, Long defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("config",
                Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }


    public static String SceneList2String(HashMap<Integer, Boolean> hashmap) throws IOException {
        // 实例化一个ByteArrayOutputStream对象，用来装载压缩后的字节文件。
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // 然后将得到的字符数据装载到ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        // writeObject 方法负责写入特定类的对象的状态，以便相应的 readObject 方法可以还原它
        objectOutputStream.writeObject(hashmap);
        // 最后，用Base64.encode将字节文件转换成Base64编码保存在String中
        String SceneListString = new String(Base64.encode(byteArrayOutputStream.toByteArray(), Base64.DEFAULT));
        // 关闭objectOutputStream
        objectOutputStream.close();
        return SceneListString;
    }

    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Boolean> String2SceneList(
            String SceneListString) throws StreamCorruptedException,
            IOException, ClassNotFoundException {
        byte[] mobileBytes = Base64.decode(SceneListString.getBytes(),
                Base64.DEFAULT);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
                mobileBytes);
        ObjectInputStream objectInputStream = new ObjectInputStream(
                byteArrayInputStream);
        HashMap<Integer, Boolean> SceneList = (HashMap<Integer, Boolean>) objectInputStream
                .readObject();
        objectInputStream.close();
        return SceneList;
    }

    public static boolean putHashMap(Context context, String key, HashMap<Integer, Boolean> hashmap) {
        SharedPreferences settings = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        try {
            String liststr = SceneList2String(hashmap);
            editor.putString(key, liststr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return editor.commit();
    }

    public static HashMap<Integer, Boolean> getHashMap(Context context, String key) {
        SharedPreferences settings = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        String liststr = settings.getString(key, "");
        try {
            return String2SceneList(liststr);
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
