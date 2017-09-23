package com.example.c.denglizimeijunqi.TimeDisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.Function.SwitchActivity;
import com.example.c.denglizimeijunqi.Function.TimeActivity;
import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;

public class BiaoMianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biao_mian);
        Button button=(Button)findViewById(R.id.switch_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BiaoMianActivity.this,TimeActivity.class);
                startActivity(intent);
            }
        });
        Button button1=(Button)findViewById(R.id.kaishi_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(BiaoMianActivity.this,"表面灭菌程序开始",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
