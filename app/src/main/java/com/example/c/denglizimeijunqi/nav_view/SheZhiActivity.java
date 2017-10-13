package com.example.c.denglizimeijunqi.nav_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.SheZhi.GuanYuActivity;
import com.example.c.denglizimeijunqi.denglu.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class SheZhiActivity extends BaseActivity {
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
                 if (shezhitu.getName().equals("关于")){
                    Intent intent=new Intent(SheZhiActivity.this, GuanYuActivity.class);
                    startActivity(intent);
                }else if(shezhitu.getName().equals("检测新版本")){
                     Toast.makeText(SheZhiActivity.this,"已经是最新版本",Toast.LENGTH_LONG).show();
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
        Button button1=(Button)findViewById(R.id.tuichu_Button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.c.denglizimeijunqi.denglu.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });

    }
    private void  inintFruits(){
                Shezhitu zhanhaoguali=new Shezhitu("按键震动",R.drawable.zhendong);
                shezhituList.add(zhanhaoguali);
                Shezhitu tuisongtongzhi=new Shezhitu("推送通知",R.drawable.tuisong);
                shezhituList.add(tuisongtongzhi);
                Shezhitu jiancexinbanben=new Shezhitu("检测新版本",R.drawable.jiance);
                shezhituList.add(jiancexinbanben);
                Shezhitu shezhitu=new Shezhitu("关于",R.drawable.about);
                shezhituList.add(shezhitu);


    }
}
