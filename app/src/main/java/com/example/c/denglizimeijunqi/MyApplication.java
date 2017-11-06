package com.example.c.denglizimeijunqi;

import com.mob.MobApplication;

import org.litepal.LitePal;

/**
 * Created by C on 2017/10/31.
 */

public class MyApplication extends MobApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
