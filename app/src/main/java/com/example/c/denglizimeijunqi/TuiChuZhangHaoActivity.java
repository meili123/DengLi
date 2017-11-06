package com.example.c.denglizimeijunqi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.c.denglizimeijunqi.denglu.BaseActivity;
public class TuiChuZhangHaoActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tui_chu_zhang_hao);

        Button button=(Button)findViewById(R.id.guanli_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TuiChuZhangHaoActivity.this,MainActivity.class));
                finish();
            }
        });

        Button button1=(Button)findViewById(R.id.tui123_Button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.c.denglizimeijunqi.denglu.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
