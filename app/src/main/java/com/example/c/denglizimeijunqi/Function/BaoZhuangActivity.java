package com.example.c.denglizimeijunqi.Function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;

public class BaoZhuangActivity extends AppCompatActivity {
   private  String[] data={"包装信息","包装流程","包装规格","包装信息",
           "包装流程","包装规格","包装信息","包装流程","包装规格","包装信息","包装流程","包装规格","包装信息",
           "包装流程","包装规格","包装信息","包装流程","包装规格"};
    private ListView baozhuangListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_zhuang);
        Button button=(Button)findViewById(R.id.baozhuang_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BaoZhuangActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(BaoZhuangActivity.this,android.R.layout.simple_list_item_1,data);
        baozhuangListview=(ListView)findViewById(R.id.baozhuang_listview);
        baozhuangListview.setAdapter(adapter);


    }
}
