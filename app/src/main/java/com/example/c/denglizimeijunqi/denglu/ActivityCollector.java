package com.example.c.denglizimeijunqi.denglu;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C on 2017/10/8.
 */

public class ActivityCollector  {
//    创建一个活动窗口数组
    public  static List<Activity> activities=new ArrayList<>();
//    添加活动窗口
    public static void addActivity(Activity activity){
        activities.add(activity);
    }
//    删除活动窗口
    public  static  void  removeActivity(Activity activity){
        activities.remove(activity);
    }
//    关闭所有的活动窗口
    public static  void finishAll(){
        for (Activity activity:activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
