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

public class FaXianActivity extends AppCompatActivity {
    private  String[] data={"等离子灭菌器","产品信息","产品介绍","等离子灭菌器","产品信息","产品介绍","等离子灭菌器","产品信息","产品介绍",
            "等离子灭菌器","产品信息","产品介绍","等离子灭菌器","产品信息","产品介绍"};
    private ListView faxianListview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_xian);
        Button button=(Button)findViewById(R.id.faxian_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FaXianActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(FaXianActivity.this,android.R.layout.simple_list_item_1,data);
        faxianListview=(ListView)findViewById(R.id.faxian_listview);
        faxianListview.setAdapter(adapter);
    }
}
