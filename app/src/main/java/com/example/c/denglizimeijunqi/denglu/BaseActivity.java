package com.example.c.denglizimeijunqi.denglu;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.c.denglizimeijunqi.R;

/**
 * Created by C on 2017/10/8.
// */
//活动窗口的基类
public class BaseActivity extends AppCompatActivity {
    private ForceOfflineReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        添加此活动窗口
        ActivityCollector.addActivity(this);
    }

//接收消息
    @Override
    protected void onResume(){
        super.onResume();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.c.denglizimeijunqi.denglu.FORCE_OFFLINE");
        receiver=new ForceOfflineReceiver();
        registerReceiver(receiver,intentFilter);
    }
    @Override

//    注册和取消注册
   protected   void onPause(){
        super.onPause();
        if (receiver!=null){
            unregisterReceiver(receiver);
            receiver=null;
        }
    }
    @Override
    protected  void onDestroy(){
        super.onDestroy();
//        销毁此活动窗口
        ActivityCollector.removeActivity(this);
    }
}

class ForceOfflineReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(final Context context, Intent intent) {
//            创建一个警告框
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("提示");
        builder.setMessage("确认退出登录吗？");
//            设置为不可取消
        builder.setCancelable(false);
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ActivityCollector.finishAll();//销毁所有活动
                Intent intent=new Intent(context,LoginActivity.class);
                context.startActivity(intent);//从新启动LoginActivity
            }
        });
        builder.setNegativeButton("取消",null);
        builder.show();

    }
}