package net.better.hongqian.baseproject;


import net.better.hongqian.baseproject.bean.AccountRspModel;
import net.better.hongqian.baseproject.bean.BaseGsonBean;
import net.better.hongqian.baseproject.bean.LoginModel;
import net.better.hongqian.baseproject.bean.QuesEntity;
import net.better.hongqian.baseproject.bean.RegisterModel;
import net.better.hongqian.baseproject.bean.UserCard;
import net.better.hongqian.baseproject.bean.UserUpdateModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * 网络请求的所有的接口
 * Created by HongQian.Wang on 2017/9/21.
 */

public interface RemoteService {
    /**
     * 网络请求注册接口
     *
     * @param model 传入的是RegisterModel @Body的作用是把对象转换成需要的字符串发送到服务器
     * @return 返回的RspModel 是 AccountRspModel
     */
    @POST("account/register")
    Observable<RspModel<AccountRspModel>> accountRegisterModel(@Body RegisterModel model);

    /**
     * 登录接口
     *
     * @param model LoginModel
     * @return RspModel<AccountRspModel>
     */
    @POST("account/login")
    Call<RspModel<AccountRspModel>> accountLogin(@Body LoginModel model);

    /**
     * 绑定设备Id
     *
     * @param
     * @return RspModel<AccountRspModel>
     */
    @POST("account/bind/{pushId}")
    Call<RspModel<AccountRspModel>> accountBind(@Path(encoded = true, value = "pushId") String pushId);

    //     用户更新的接口
    @PUT("user")
    Call<RspModel<UserCard>> userUpdate(@Body UserUpdateModel modle);

    // 用户搜索的接口
    @GET("user/search/{name}")
    Call<RspModel<List<UserCard>>> userSearch(@Path("name") String name);

    // 用户关注接口
    @PUT("user/follow/{userId}")
    Call<RspModel<UserCard>> userFollow(@Path("userId") String userId);

    // 获取联系人列表
    @GET("user/contact")
    Call<RspModel<List<UserCard>>> userContacts();

    @GET("user/{userId}")
    Call<RspModel<UserCard>> userFind(@Path("userId") String userId);


    @GET("ques/category/type/{type}")
        //动态替换baseUrl
    Observable<BaseGsonBean<QuesEntity>> getType(@Path("type") int type);

    //    @GET
//    Observable<BaseGsonBean<QuesEntity>> getType(@Url String url); 还有这种写法
    @GET("my/courses")
    Observable<BaseGsonBean<String>> getCourse();
}
