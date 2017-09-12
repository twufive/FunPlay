package com.zgtech.funplay.retrofit;

import android.content.Context;
import android.support.annotation.NonNull;

import com.zgtech.funplay.FunPlayApplication;
import com.zgtech.funplay.utils.NetConditionUtils;
import com.zgtech.funplay.utils.SPUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    private static String androidToken;

    public final static int CONNECT_TIMEOUT = 15;
    public final static int READ_TIMEOUT = 30;
    public final static int WRITE_TIMEOUT = 30;

    public static ApiStores initApiStores() {
        Context context = FunPlayApplication.getContext();
        androidToken = SPUtils.getString(context, "androidToken", "");

        //缓存机制
        final File chachefile = new File(FunPlayApplication.getContext().getExternalCacheDir(), "HttpCache");
        final Cache cache = new Cache(chachefile, 1024 * 1024 * 50);//缓存文件
        Interceptor cacheInterceptor = initCacheSystem();

        //公共参数
        Interceptor addQueryParameterInterceptor = initPublicParams();

        OkHttpClient client = initOkHttpClient(cache, cacheInterceptor, addQueryParameterInterceptor);


        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiStores.API_SERVER_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        mApiStores = mRetrofit.create(ApiStores.class);

        return mApiStores;
    }

    @NonNull
    private static OkHttpClient initOkHttpClient(Cache cache, Interceptor cacheInterceptor, Interceptor addQueryParameterInterceptor) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(addQueryParameterInterceptor)
                .addInterceptor(cacheInterceptor)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)//设置连接超时时间
                .cache(cache)
//                .addNetworkInterceptor()
                .build();

        return okHttpClient;
    }

    @NonNull
    private static Interceptor initPublicParams() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Request request;
                String method = originalRequest.method();
                Headers headers = originalRequest.headers();
                HttpUrl modifiedUrl = originalRequest.url().newBuilder()
                        // Provide your custom parameter here
                        .addQueryParameter("androidToken", androidToken)
                        //                        .addQueryParameter("version", "1.0.0")
                        .build();
                request = originalRequest.newBuilder().url(modifiedUrl).build();
                return chain.proceed(request);
            }
        };
    }

    @NonNull
    private static Interceptor initCacheSystem() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (!NetConditionUtils.isConnected(FunPlayApplication.getContext())) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)
                            .build();
                }
                Response response = chain.proceed(request);
                if (NetConditionUtils.isConnected(FunPlayApplication.getContext())) {
                    int maxAge = 0;

                    // 有网络时 设置缓存超时时间0个小时
                    response.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")// 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                            .build();
                } else {
                    //无网络时，设置超时为4周
                    int maxStale = 60 * 60 * 24 * 28;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }

                return response;
            }
        };
    }
}
