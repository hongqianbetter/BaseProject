package com.hongqian.net.mvvm;


/**
 * Created by 王少岩 on 2016/11/9.
 */



import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

/**
 * retrofit 以注解的方式访问接口
 * <p>
 * post请求方式如下
 *
 * @FormUrlEncoded
 * @POST(url) Observable<T> method(@FieldMap Map<String, String> params);
 */
public interface RequestApi {
    //登录
    @FormUrlEncoded
    @POST(HttpPath.login)
    Observable<LoginBean> login(@FieldMap Map<String, String> stringStringMap);
//    //注册
//    @FormUrlEncoded
//    @POST(HttpPath.register)
//    Observable<HttpResult> register(@FieldMap Map<String, String> stringStringMap);
//    //首页
//    @POST(HttpPath.mainOrderIndex)
//    Observable<HttpResult<MainOrderIndexBean>> mainOrderIndex();
//
//    //统计
//    @POST(HttpPath.orderStatistics)
//    Observable<HttpResult<StatisticsBean>> orderStatistics();
//    //账号与安全
//    @POST(HttpPath.getUserDetail)
//    Observable<HttpResult<UserBetailBean>> getUserDetail();
//
//    @POST(HttpPath.getGoodsProperty)
//    Observable<HttpResult<GoodsPropertyBean>> getGoodsProperty();
//
//    @FormUrlEncoded
//    @POST(HttpPath.listProductByLevel)
//    Observable<HttpResult<ArrayList<GoodsCategoryBean>>> listProductByLevel(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.listProductBykeyWords)
//    Observable<HttpResult<ArrayList<GoodsCategoryBean>>> listProductBykeyWords(@FieldMap Map<String, String> params);
//
//    @Multipart
//    @POST(HttpPath.uploadImage)
//    Observable<HttpResult<ImageUploadBean>> imageUpload(@PartMap Map<String, RequestBody> imgs);
//
//    @Multipart
//    @POST(HttpPath.uploadDetailImage)
//    Observable<HttpResult<ImageDetailUploadBean>> uploadDetailImage(@PartMap Map<String, RequestBody> imgs);
//
//    @FormUrlEncoded
//    @POST(HttpPath.deleteImage)
//    Observable<HttpResult> deleteImage(@FieldMap Map<String, String> params);
//
//    @POST(HttpPath.listWareHouses)
//    Observable<HttpResult<ArrayList<GoodsWareHouseBean>>> listWareHouses();
//
//    @FormUrlEncoded
//    @POST(HttpPath.listBrand)
//    Observable<HttpResult> listBrand(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.listCarLogo)
//    Observable<HttpResult> listCarLogo(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.listCarSeries)
//    Observable<HttpResult<ArrayList<CarModelOneBean>>> listCarSeries(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.listCarYear)
//    Observable<HttpResult<CarYearBean>> listCarYear(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.listCarModel)
//    Observable<HttpResult<ArrayList<CarModelBean>>> listCarModel(@FieldMap Map<String, String> params);
//
//
//
//    @FormUrlEncoded
//    @POST(HttpPath.showAskPriceOrderList)
//    Observable<HttpResult<InquiryListBean>> showAskPriceOrderList(@FieldMap Map<String, String> params);
//
//
//    @FormUrlEncoded
//    @POST(HttpPath.orderLists)
//    Observable<HttpResult<OrderResultBean>> orderLists(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.orderReturnLists)
//    Observable<HttpResult<OrderResultBean>> orderReturnLists(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.orderView)
//    Observable<HttpResult<OrderDetailBean>> orderView(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.orderReturnView)
//    Observable<HttpResult<OrderDetailBean>> orderReturnView(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.goodsList)
//    Observable<HttpResult<GoodsManagerBean>> goodsList(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.detailGoods)
//    Observable<HttpResult<GoodsDetailResult>> detailGoods(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.updateGoodsStatus)
//    Observable<HttpResult> updateGoodsStatus(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.underBatchGoods)
//    Observable<HttpResult> underBatchGoods(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.orderDelivery)
//    Observable<HttpResult> orderDelivery(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.confirmReceipt)
//    Observable<HttpResult> confirmReceipt(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.saveGoods)
//    Observable<HttpResult> saveGoods(@FieldMap Map<String, String> params);
//
//    @FormUrlEncoded
//    @POST(HttpPath.showDetail)
//    Call<HttpResult<DetailBean>> showDetail(@Field("askPriceOrderId") String id);
//
//    @FormUrlEncoded
//    @POST(HttpPath.quotedPriceAdd)
//    Call<HttpResult<DetailBean>> quotedPriceAdd(@Field("askPriceOrderId") String id);
//
////    @FormUrlEncoded
//    @POST(HttpPath.listWareHouses)
//    Call<WareHouseBean> listWareHouse();
//
//
//    //0.1.	检查更新
//    @GET(HttpPath.mobileCheckupdateUrl)
//    Call<CheckUpdateBean> mobileCheckupdate(@QueryMap Map<String, String> params);

}
