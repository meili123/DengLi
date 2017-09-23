package com.example.c.denglizimeijunqi.TimeDisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.Function.TimeActivity;
import com.example.c.denglizimeijunqi.R;

public class YuReActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_re);
        Button button=(Button)findViewById(R.id.switch_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(YuReActivity.this,TimeActivity.class);
                startActivity(intent);
            }
        });
    }
}
