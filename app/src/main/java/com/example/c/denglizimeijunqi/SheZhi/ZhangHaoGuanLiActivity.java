package com.example.c.denglizimeijunqi.SheZhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.nav_view.SheZhiActivity;

public class ZhangHaoGuanLiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang_hao_guan_li);
        Button button=(Button)findViewById(R.id.shezhi_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ZhangHaoGuanLiActivity.this,SheZhiActivity.class);
                startActivity(intent);
            }
        });
    }
}
