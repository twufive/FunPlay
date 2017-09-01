package com.zgtech.funplay.retrofit;

import com.zgtech.funplay.model.LoginModel;
import com.zgtech.funplay.model.NearbyData;
import com.zgtech.funplay.model.PinTuanTogetherModel;
import com.zgtech.funplay.model.RecommendModel;
import com.zgtech.funplay.model.RecommendOther3Model;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Retrofit ApiStores
 * Created by Administrator on 2017/6/2.
 */

public interface ApiStores {
    /*** baseUrl*/
    String API_SERVER_URL = "http://192.168.188.196/";
//    String API_SERVER_URL = "http://192.168.188.70/";
//    String API_SERVER_URL = "http://www.azgyf.com/";

    /***登录注册模块*/
    @POST("user/login")
    Call<LoginModel> doLogin(@Body RequestBody requestBody);//登录




    /***首页模块*/
    @GET("order/queryRecommend")
    Call<RecommendModel> getRecommendData();//查询推荐

    @POST("order/queryNew")
    Call<RecommendOther3Model> getNewPersonData(@Body RequestBody requestBody);//查询新人

    @POST("order/queryNew")
    Call<RecommendOther3Model> getHighBeautyData(@Body RequestBody requestBody);//查询高颜值

    @POST("order/queryNearby")
    Call<NearbyData> getNearbyData(@Body RequestBody requestBody);//查询附近

    @POST("order/queryIdent")
    Call<RecommendOther3Model> getCertifyData(@Body RequestBody requestBody);//查询已认证




    /***消息模块*/




    /***中间红色按钮*/
    @GET("order/queryOrder")
    Call<PinTuanTogetherModel> getPinTuanTogetherData(@Query("cursor") String cursor,@Query("more") String more);//一起拼团列表




    /***旅游圈模块*/



    /***个人中心模块*/

}