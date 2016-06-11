package com.demo.baoxinbao.myleancloudapp;

import android.app.Application;

import com.avos.avoscloud.*;

/**
 * Created by baoxinbao on 6/10.
 */
public class MyLeanCloudApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this, "kthWupcr5OTKLkQR1yCwi8cV-gzGzoHsz", "pW3TFg7qIStTL0G0Hj6iGrsH");
    }
}
