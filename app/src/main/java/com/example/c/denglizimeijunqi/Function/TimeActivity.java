package com.example.c.denglizimeijunqi.Function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.TimeDisplay.BiaoMianActivity;
import com.example.c.denglizimeijunqi.TimeDisplay.BiaoZhunActivity;
import com.example.c.denglizimeijunqi.TimeDisplay.GaoJiActivity;
import com.example.c.denglizimeijunqi.TimeDisplay.YuReActivity;
import com.example.c.denglizimeijunqi.TimeDisplay.ZiJianActivity;

public class TimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        Button button=(Button)findViewById(R.id.time_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Button button1=(Button)findViewById(R.id.zijian_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimeActivity.this,ZiJianActivity.class);
                startActivity(intent);
            }
        });
        Button button2=(Button)findViewById(R.id.biaomian_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimeActivity.this,BiaoMianActivity.class);
                startActivity(intent);
            }
        });

        Button button3=(Button)findViewById(R.id.gaoji_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimeActivity.this,GaoJiActivity.class);
                startActivity(intent);
            }
        });
        Button button4=(Button)findViewById(R.id.yure_button);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimeActivity.this,YuReActivity.class);
                startActivity(intent);
            }
        });
        Button button5=(Button)findViewById(R.id.biaozhun_button);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TimeActivity.this,BiaoZhunActivity.class);
                startActivity(intent);
            }
        });


    }
}
