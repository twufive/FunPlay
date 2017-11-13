package com.zgtech.funplay.utils;

import android.util.Base64;
import android.util.Log;



import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Create by zayin on 2016/06/04
 * TIME 15:04
 */
public class MgqUtils {

    public static String toURLEncoded(String paramString) {
        if (paramString == null || paramString.equals("")) {
//            LogD("toURLEncoded error:"+paramString);
            Log.i("TAG", "toURLEncoded error01:" + paramString);
            return "";
        }

        try {
            String str = new String(paramString.getBytes(), "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
            return str;
        } catch (Exception localException) {
//            LogE("toURLEncoded error:"+paramString, localException);
            Log.i("TAG", "toURLEncoded error02:" + paramString, localException);
        }

        return "";
    }


    public static String GetTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String str = df.format(new Date());
        return str;
    }

    public static String ApiSecurity(String secret, String message) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);

            String hash = Base64.encodeToString(sha256_HMAC.doFinal(message.getBytes()), Base64.NO_WRAP);
            return hash;
        } catch (Exception e) {
            return "";
        }
    }
}
