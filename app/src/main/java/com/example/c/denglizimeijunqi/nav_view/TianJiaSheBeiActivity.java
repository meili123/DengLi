package com.example.c.denglizimeijunqi.nav_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;

public class TianJiaSheBeiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tian_jia_she_bei);
        Button button=(Button)findViewById(R.id.tianjiashebee_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TianJiaSheBeiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
