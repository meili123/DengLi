package com.example.c.denglizimeijunqi.nav_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.c.denglizimeijunqi.Function.BangZhuActivity;
import com.example.c.denglizimeijunqi.Function.RunActivity;
import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;

public class SheZhiActivity extends AppCompatActivity {
    private String[] data={"账号管理","关于"};
   private ListView shezhilistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        Button button=(Button)findViewById(R.id.shezhi_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SheZhiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(SheZhiActivity.this,android.R.layout.simple_list_item_1,data);
        shezhilistView=(ListView)findViewById(R.id.shezhi_listview);
        shezhilistView.setAdapter(adapter);




    }
}
