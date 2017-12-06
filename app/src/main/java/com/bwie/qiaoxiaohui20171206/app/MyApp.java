package com.bwie.qiaoxiaohui20171206.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by 乔晓慧 on 2017/12/6.
 * 初始化加载图片的Fresco
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
