package net.better.hongqian.baseproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import net.better.hongqian.baseproject.bean.AccountRspModel;
import net.better.hongqian.baseproject.bean.User;


/**
 * Created by HongQian.Wang on 2018/2/26.
 */

public class Account {
    private static final String KEY_PUSH_ID = "KEY_PUSH_ID";
    private static final String KEY_IS_BIND = "KEY_IS_BIND";
    private static final String KEY_TOKEN = "KEY_TOKEN";
    private static final String KEY_USER_ID = "KEY_USER_ID";
    private static final String KEY_ACCOUNT = "KEY_ACCOUNT";


    private static String pushId; //设备推送Id
    private static boolean isBind; //设备Id是否绑定到了推送服务器


    private static String token;
    // 登录的用户ID
    private static String userId;
    // 登录的账户
    private static String account;

    public static String getPushId() {
        return pushId;
    }
    public static String getUserId() {
        return getUser().getId();
    }
    public static String getToken() {
        return token;
    }

    public static void setPushId(String pushId) {
        Account.pushId = pushId;
        Account.save(Factory.app());
    }

    //设定绑定状态
    public static void setBind(boolean isBind) {
        Account.isBind = isBind;
        Account.save(App.getInstance());
    }

    public static boolean isBind() {
        return isBind;
    }

    public static boolean isLogin() {
        // 用户Id 和 Token 不为空
        return !TextUtils.isEmpty(userId) && !TextUtils.isEmpty(token);
    }

    /**
     * 是否已经完善了用户信息
     *
     * @return True 是完成了
     */
    public static boolean isComplete() {
        // 首先保证登录成功
        if (isLogin()) {
            User self = getUser();
            return !TextUtils.isEmpty(self.getDesc()) && !TextUtils.isEmpty(self.getPortrait()) && self.getSex() != 0;
        }
        // 未登录返回信息不完全
        return false;
    }

    /**
     * 进行数据加载
     */
    public static void load(Context context) { //app创建的时候进行账户信息加载
        SharedPreferences sp = context.getSharedPreferences(Account.class.getName(), Context.MODE_PRIVATE);
        pushId = sp.getString(KEY_PUSH_ID, "");
        isBind = sp.getBoolean(KEY_IS_BIND, false);
        token = sp.getString(KEY_TOKEN, "");
        userId = sp.getString(KEY_USER_ID, "");
        account = sp.getString(KEY_ACCOUNT, "");
    }

    //数据存储到xml ,持久化
    private static void save(Context context) {
        // 获取数据持久化的SP
        SharedPreferences sp = context.getSharedPreferences(Account.class.getName(), Context.MODE_PRIVATE);
        // 存储数据
        sp.edit().putString(KEY_PUSH_ID, pushId).putBoolean(KEY_IS_BIND, isBind).putString(KEY_TOKEN, token).putString(KEY_USER_ID, userId).putString(KEY_ACCOUNT, account).apply();
    }

    //保存自己信息到xml中
    public static void login(AccountRspModel model) {
        //存储当前登录的token,用户id,方便从数据库中查询我的信息
        Account.token = model.getToken();
        Account.account = model.getAccount();
        Account.userId = model.getUser().getId();
        save(Factory.app());
    }

    /**
     * 获取当前登录的用户信息
     *
     * @return User
     */
    public static User getUser() {
        // 如果为null返回一个new的User，其次从数据库查询
//        return TextUtils.isEmpty(userId) ? new User() : SQLite.select()
//                .from(User.class)
//                .where(User_Table.id.eq(userId))
//                .querySingle();

        return new User();

    }


}
