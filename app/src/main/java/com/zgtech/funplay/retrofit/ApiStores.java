package com.zgtech.funplay.retrofit;

import com.zgtech.funplay.model.BaseResultModel;
import com.zgtech.funplay.model.ChargeModel;
import com.zgtech.funplay.model.CustomServeModel;
import com.zgtech.funplay.model.FriendTalkData;
import com.zgtech.funplay.model.LoginBackUserModel;
import com.zgtech.funplay.model.MineExternalModel;
import com.zgtech.funplay.model.MyInfoModel;
import com.zgtech.funplay.model.MyOrderModel;
import com.zgtech.funplay.model.MyPinTuanModel;
import com.zgtech.funplay.model.NearbyData;
import com.zgtech.funplay.model.NewsDetailModel;
import com.zgtech.funplay.model.NewsModel;
import com.zgtech.funplay.model.OrderDetailModel;
import com.zgtech.funplay.model.PinTuanTogetherModel;
import com.zgtech.funplay.model.QualityFoodDetailModel;
import com.zgtech.funplay.model.QualityFoodModel;
import com.zgtech.funplay.model.QualityScenicDetailModel;
import com.zgtech.funplay.model.QualityScenicModel;
import com.zgtech.funplay.model.QueryGuiderModel;
import com.zgtech.funplay.model.RecommendModel;
import com.zgtech.funplay.model.RecommendOther3Model;
import com.zgtech.funplay.model.RegistCodeModel;
import com.zgtech.funplay.model.SpaceOrderModel;
import com.zgtech.funplay.model.UpImgsModel;
import com.zgtech.funplay.model.UserDetailModel;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 * Retrofit ApiStores
 * Created by Administrator on 2017/6/2.
 */

public interface ApiStores {
    /*** baseUrl*/
//    String API_SERVER_URL = "http://192.168.188.196/";
//    String API_SERVER_URL = "http://192.168.188.71:8080/";
    String API_SERVER_URL = "http://122.114.240.121:8080/qwan-manager/";
//    String API_SERVER_URL = "http://192.168.188.70/";
//    String API_SERVER_URL = "http://www.azgyf.com/";
//    String API_SERVER_URL = "http://www.qwanapp.com/";





    /***通用模块*/
    @Multipart
    @POST("user/upimgs")
    Call<UpImgsModel> upImgs(@PartMap Map<String, RequestBody> params); //批量上传图片


    @POST("order/join")
    Call<ChargeModel> initCharge(@Query("orderId") String orderId);//获取支付的charge对象

    /***登录注册模块*/
    @POST("user/login")
    Call<LoginBackUserModel> doLogin(@Body RequestBody requestBody);//登录

    @GET("user/getRegisterVerifyCode")
    Call<RegistCodeModel> getRegisterVerifyCode(@Query("mobilPhone") String mobilPhone);//获取未注册时验证码

    @GET("user/getVerifyCode")
    Call<RegistCodeModel> getVerifyCode(@Query("mobilPhone") String mobilPhone);//获取已注册时验证码


    @POST("user/add")
    Call<BaseResultModel> doRegist(@Body RequestBody requestBody);//注册



    @POST("user/edit")
    Call<BaseResultModel> modifyPersonal(@Body RequestBody requestBody);//修改个人信息


    /***订单系统*/
    @GET("order/join")
    Call<BaseResultModel> joinOrder(@Query("orderId") String orderId);//报名,或者下单


    @GET("order/joinSuccess")
    Call<BaseResultModel> joinOrderSuccess(@Query("orderTransactionNo") String orderTransactionNo);//确认支付成功的回调


    /***首页模块*/
    @POST("order/queryByCondition")
    Call<QueryGuiderModel> queryGuiderData(@Body RequestBody requestBody);//筛选某一批导游

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

    @GET("order/queryGuide")
    Call<UserDetailModel> getUserDetailData(@Query("userId") String userId);//查询某个导游的详情数据

    /***消息模块*/





    /***中间红色按钮,，大厅模块，包含订单体系，玩赚地球体系*/
    @GET("order/queryOrder")
    Call<PinTuanTogetherModel> getPinTuanTogetherData(@Query("cursor") String cursor,@Query("more") String more);//一起拼团列表

    @GET("order/query")
    Call<OrderDetailModel> getOrderDetailData(@Query("orderId") String orderId);//获取某个订单的详情

    @POST("order/add")
    Call<BaseResultModel> pushNewOrder(@Body RequestBody requestBody);//发布新的拼团订单


    /***旅游圈模块*/
    @GET("user/space/queryList")
    Call<FriendTalkData> getFriendTalkData(@Query("cursor") String cursor,@Query("more") String more);//旅游圈最外边列表

    @POST("user/space/add")
    Call<BaseResultModel> pushTalk(@Body RequestBody requestBody);//发布说说

    @POST("user/space/good")
    Call<BaseResultModel> addZan(@Body RequestBody requestBody);//给某一个说说点赞

    @POST("user/space/goodCancel")
    Call<BaseResultModel> cancelZan(@Body RequestBody requestBody);//给某一个说说取消点赞


    @POST("user/space/commentAdd")
    Call<BaseResultModel> addComment(@Body RequestBody requestBody);//评论某一条说说


    @GET("user/space/getOrders")
    Call<SpaceOrderModel> getSpaceOrdersData();//旅游圈发布说说时，需要用到的订单列表

    /***个人中心模块*/
    @GET("user/info")
    Call<MyInfoModel> getMyInfoData();//获取我的个人信息

    @GET("user/space/queryUserSpace")
    Call<MineExternalModel> getMyExternalInfoData(@Query("isMe") String isMe, @Query("userKey") String userKey);//获取我的外部个人信息

    @GET("order/queryMe")
    Call<MyPinTuanModel> getMyPinTuanData(@Query("cursor") String cursor, @Query("more") String more);//查询我的拼团

    @GET("order/queryMeBuy")
    Call<MyOrderModel> getMyOrderData(@Query("cursor") String cursor, @Query("more") String more);//查询我的订单


    @POST("report/addReport")
    Call<BaseResultModel> pushReport(@Body RequestBody requestBody);//发出举报内容

    @POST("user/modifyPwd")
    Call<BaseResultModel> modifyPwd(@Body RequestBody requestBody);//修改密码

    @POST("user/loginOut")
    Call<BaseResultModel> logout(@Body RequestBody requestBody);//退出登录


    @POST("identity/apply")
    Call<BaseResultModel> doCertify(@Body RequestBody requestBody);//申请认证实名


    // ****************************************************** 分割线  增加的部分

    // 热门景点
    @POST("public/hotView")
    Call<QualityScenicModel> getQualityScenicData(@Body RequestBody requestBody);

    // 景点详情
    @POST("public/getView")
    Call<QualityScenicDetailModel> getScenicDetailData(@Query("id") String id);

    // 优质美食
    @POST("public/hotFood")
    Call<QualityFoodModel> getQualityFoodData(@Body RequestBody requestBody);

    // 美食详情
    @POST("public/getFood")
    Call<QualityFoodDetailModel> getFoodDetailData(@Query("id") String id);

    // 新闻资讯
    @POST("public/news")
    Call<NewsModel> getNewsData(@Body RequestBody requestBody);

    // 新闻详情
    @POST("public/getNews")
    Call<NewsDetailModel> getNewsDetailData(@Query("id") String id);

    // 系统公告
    @POST("msg/list")
    Call<NewsModel> getAnnouncementData(@Body RequestBody requestBody);

    // 热门陪游
    @POST("public/hotOrder")
    Call<NewsModel> getHotTravelAroundData();

    // 客服
    @POST("public/kefu")
    Call<CustomServeModel> getCustomServeData();

    //
}