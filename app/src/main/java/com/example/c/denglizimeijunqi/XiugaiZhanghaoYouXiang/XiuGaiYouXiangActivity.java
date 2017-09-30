package com.example.c.denglizimeijunqi.XiugaiZhanghaoYouXiang;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.Function.RunActivity;
import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.SheZhi.ZhangHaoGuanLiActivity;

public class XiuGaiYouXiangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu_gai_you_xiang);
        Button button=(Button)findViewById(R.id.xiugai_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(XiuGaiYouXiangActivity.this,ZhangHaoGuanLiActivity.class);
                startActivity(intent);
            }
        });
    }
}
