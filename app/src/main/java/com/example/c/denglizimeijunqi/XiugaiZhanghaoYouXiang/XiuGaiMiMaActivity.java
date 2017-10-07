package com.example.c.denglizimeijunqi.XiugaiZhanghaoYouXiang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.SheZhi.ZhangHaoGuanLiActivity;

public class XiuGaiMiMaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu_gai_mi_ma);
        Button button=(Button)findViewById(R.id.xiugaimima_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(XiuGaiMiMaActivity.this,ZhangHaoGuanLiActivity.class);
                startActivity(intent);
            }
        });
    }
}
