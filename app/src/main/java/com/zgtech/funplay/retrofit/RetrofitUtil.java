package com.zgtech.funplay.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Retrofit网络请求通用基础类
 * Created by Administrator on 2017/6/2.
 */

public class RetrofitUtil {
    private static Retrofit mRetrofit;
    private static ApiStores mApiStores;


    public static ApiStores initApiStores() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiStores.API_SERVER_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mApiStores = mRetrofit.create(ApiStores.class);
        return mApiStores;
    }
}
