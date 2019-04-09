package com.example.skeleton;

import android.app.Application;

public class SkeletonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitManager.getInstance().init("https://api.github.com/users/");
    }
}
