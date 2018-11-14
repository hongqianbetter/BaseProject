package com.hongqian.net.mvvm;

/**
 * 王少岩 在 2017/3/24 创建了它
 */

public class Constants {
    /**
     * 存放常量字符串
     */
    public static final String sServer = "server";
    public static final String sServerTest = "server_test";
    public static final String sUser_pwd = "pwd";
    public static final String sUser_account = "account";

    /**
     * sharespreferences相关
     */
    public static final String sUser_loginFlag = "login_flag";
    public static final String sUser_userid = "userid";
    public static final String sUser_useraccount= "useraccount";
    public static final String sUser_username = "username";
    public static final String sUser_pic = "userpic";
    public static final String sUser_token = "token";
    public static final String sUser_partyName = "partyName";
    public static final String sUser_partyId = "partyId";
    public static final String sUser_userId = "userId";
    public static final String sUser_phone = "phone";
    public static final String sUser_email = "email";


    /**
     * 订单相关状态
     */
    public static final String Fragment_OrderType = "orderType";

    public static final int OrderType_0 = 0;//全部   , 商品全部
    public static final int OrderType_1 = 1;//待发货  ，商品上架
    public static final int OrderType_2 = 2;//已完成  ，售罄 退单完成 ，商品下架
    public static final int OrderType_3 = 3;// 商品售罄 退单完成
    public static final int OrderType_5 = 5;//
    public static final int OrderType_6 = 6;//退货中


    public static final int AdapterType_0 = 0;//订单类型
    public static final int AdapterType_1 = 1;//退单类型

    //接口通用参数
    public static final String sRequest_params_time = "time";
    public static final String sRequest_params_timeCheckValue = "timeCheckValue";
    public static final String sRequest_params_token = "token";
    public static final String sRequest_params_tokenCheckValue = "tokenCheckValue";
    public static final String sRequest_params_sourceType = "sourceType";
    public static final String sRequest_params_projectId = "projectId";
    public static final String sTime = "7cf1f0263ef39091dc48604aac8c8f9a";
    public static final String sToken = "d0468866ee36c1995563e8f8c6063a14";
    public static final String sSourceType_android = "1";//来自Android客户端
    public static final String sProjectId = "1040";//来自车福联盟

    public static final String Param_code = "code";
    public static final String Param_id = "id";

    //检查版本更新对应的状态码
    public static final int IsCurrentVersion=0;
    public static final int NeedUpdate=1;
    public static final int ForceUpdate=9;
}
