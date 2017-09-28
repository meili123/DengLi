package com.example.c.denglizimeijunqi.nav_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.Function.BangZhuActivity;
import com.example.c.denglizimeijunqi.Function.RunActivity;
import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.SheZhi.GuanYuActivity;
import com.example.c.denglizimeijunqi.SheZhi.ZhangHaoGuanLiActivity;

import java.util.ArrayList;
import java.util.List;

public class SheZhiActivity extends AppCompatActivity {
    private List<Shezhitu> shezhituList=new ArrayList<>();

   private ListView shezhilistView;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_she_zhi);
        inintFruits();
        SheZhiAdapter adapter=new SheZhiAdapter(SheZhiActivity.this,R.layout.shezhitu_item,shezhituList);
        shezhilistView=(ListView)findViewById(R.id.shezhi_listview);
        shezhilistView.setAdapter(adapter);
        shezhilistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Shezhitu shezhitu=shezhituList.get(i);
                if (shezhitu.getName().equals("账号管理")){
                    Intent intent=new Intent(SheZhiActivity.this, ZhangHaoGuanLiActivity.class);
                    startActivity(intent);
                }else if (shezhitu.getName().equals("关于")){
                    Intent intent=new Intent(SheZhiActivity.this, GuanYuActivity.class);
                    startActivity(intent);
                }
            }
        });

        Button button=(Button)findViewById(R.id.shezhi_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SheZhiActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void  inintFruits(){
                Shezhitu zhanhaoguali=new Shezhitu("账号管理",R.drawable.zhanhaoguanli);
                shezhituList.add(zhanhaoguali);
                Shezhitu shezhitu=new Shezhitu("关于",R.drawable.guanyu);
                shezhituList.add(shezhitu);


    }
}
