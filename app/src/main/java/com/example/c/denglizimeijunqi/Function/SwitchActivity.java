package com.example.c.denglizimeijunqi.Function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;

public class SwitchActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        Button button=(Button)findViewById(R.id.switch_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SwitchActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button button1=(Button)findViewById(R.id.on_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SwitchActivity.this,"你点击了开按钮,舱门打开",
                        Toast.LENGTH_SHORT).show();
            }
        });

        Button button2=(Button)findViewById(R.id.off_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SwitchActivity.this,"你点击了关按钮,舱门关闭",Toast.LENGTH_SHORT).show();
            }
        });
        Button button3=(Button)findViewById(R.id.stop_button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SwitchActivity.this,"你点击了停止按钮,舱门停止运行",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
