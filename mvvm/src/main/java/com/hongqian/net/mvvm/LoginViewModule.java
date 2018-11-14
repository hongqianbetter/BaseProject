package com.hongqian.net.mvvm;

import android.view.View;
import android.widget.Toast;

/**
 * Create by HongQian.better on ${DATA}
 **/
public class LoginViewModule {
  public   String userName = "";
 public    String pwd = "";


    public void login(View view) {
       Toast.makeText(App.getInstance(), userName+" "+pwd, Toast.LENGTH_SHORT).show();
    }

}
