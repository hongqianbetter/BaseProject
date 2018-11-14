package com.hongqian.net.mvvm;

/**
 * Created by 王少岩 on 2016/9/19.
 */
public class HttpPath {
    public final static String login= "/api/manage/login";//登录
    public final static String register= "/api/manage/supplier/user/register";//注册
    public final static String mainOrderIndex= "/api/manage/supplier/order/orderIndex";//首页
    public final static String orderStatistics= "/api/manage/supplier/statistics/orderStatistics";//统计
    public final static String getUserDetail= "/api/manage/supplier/user/getUserDetail";//供应商用户信息
    public final static String showAskPriceOrderList= "/api/manage/supplier/askPrice/showAskPriceOrderList";//询价单列表
    public final static String getGoodsProperty = "/api/manage/supplier/goods/common/getGoodsProperty";//供应商商品属性列表
    public final static String listProductByLevel = "/api/manage/supplier/product/listProductByLevel";//获取分类列表
    public final static String orderLists = "/api/manage/supplier/order/lists";//订单列表
    public final static String orderView = "/api/manage/supplier/order/view";//订单详情
    public final static String orderDelivery = "/api/manage/supplier/order/orderDelivery";//供应商发货
    public final static String orderReturnLists = "/api/manage/supplier/order/lists";//供应商退单列表
    public final static String orderReturnView = "/api/manage/supplier/refund/view";//供应商退单详情
    public final static String confirmReceipt = "/api/manage/supplier/refund/confirmReceipt";//供应商退单详情

    public final static String goodsList = "/api/manage/supplier/goods/list";//商品列表
    public final static String detailGoods = "/api/manage/supplier/goods/detailGoods";//商品 详情
    public final static String updateGoodsStatus = "/api/manage/supplier/goods/updateGoodsStatus";//商品上架下架删除
    public final static String underBatchGoods = "/api/manage/supplier/goods/underBatchGoods";//商品批量上架
    public final static String saveGoods = "/api/manage/supplier/goods/saveGoods";//供应商商品保存

    public final static String listProductBykeyWords = "/api/manage/supplier/product/listProductBykeyWords";//根据关键字获取分类列表
    public final static String uploadImage = "/api/manage/supplier/goods/uploadImage";//商品图片上传
    public final static String uploadDetailImage = "/api/manage/supplier/goods/uploadDetailImage";//商品详情图片上传
    public final static String deleteImage = "/api/manage/supplier/goods/deleteImage";//商品图片删除
    public final static String listWareHouses = "/api/manage/supplier/wms/listWareHouses";//仓库列表
    public final static String listBrand = "/api/manage/supplier/brand/listBrand";//品牌
    public final static String listCarLogo = "/api/manage/supplier/carModel/listCarLogo";//车型
    public final static String listCarSeries = "/api/manage/supplier/carModel/listCarSeries";//车系
    public final static String listCarYear = "/api/manage/supplier/carModel/listCarYear";//年款排量
    public final static String listCarModel = "/api/manage/supplier/carModel/listCarModel";//根据车系及年款获取所有车型获取车型
    public final static String listCarModelByCapacity = "/api/manage/supplier/carModel/listCarModelByCapacity";//根据车系及排量获取所有车型获取车型


    public final static String showDetail="/api/manage/supplier/askPrice/showDetail"; //询价 查看产品详情
    public final static String quotedPriceAdd="/api/manage/supplier/askPrice/quotedPriceAdd";

    public final static String mobileCheckupdateUrl="api.php"; //检查是否需要更新
}
