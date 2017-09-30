package com.example.c.denglizimeijunqi.SheZhi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.XiugaiZhanghaoYouXiang.XiuGaiYouXiangActivity;
import com.example.c.denglizimeijunqi.nav_view.SheZhiActivity;
import com.example.c.denglizimeijunqi.nav_view.SheZhiAdapter;

import java.util.ArrayList;
import java.util.List;
public class ZhangHaoGuanLiActivity extends AppCompatActivity {
    private ListView listView;
    private ZhanhaoAdapter adapter;
    private List<ZhangHao> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhang_hao_guan_li);

        listView = (ListView) findViewById(R.id.zhanghao_listView);
        initdata();
        adapter = new ZhanhaoAdapter(this, users);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ZhangHao zhangHao=users.get(i);
                if(i==0){
                    Toast.makeText(ZhangHaoGuanLiActivity.this,zhangHao.getItem1_str(),Toast.LENGTH_SHORT).show();
                }else if (i == 1) {
                    LayoutInflater layoutInflater=LayoutInflater.from(ZhangHaoGuanLiActivity.this);
                    View mTitlrView= layoutInflater.inflate(R.layout.zhangtitle,null);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(ZhangHaoGuanLiActivity.this);
//                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    });
//                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//
//                        }
//                    });
                    dialog.setCustomTitle(mTitlrView);
                    dialog.show();
                } else if (i == 2) {
                    Intent intent=new Intent(ZhangHaoGuanLiActivity.this, XiuGaiYouXiangActivity.class);
                    startActivity(intent);

                } else if (i == 3) {
                    Toast.makeText(ZhangHaoGuanLiActivity.this, zhangHao.getItem3_str(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ZhangHaoGuanLiActivity.this, zhangHao.getItem4_str(), Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button button=(Button)findViewById(R.id.shezhi_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ZhangHaoGuanLiActivity.this,SheZhiActivity.class);
                startActivity(intent);
            }
        });



    }
    private void initdata() {
        users = new ArrayList<ZhangHao>();
        users.add(new ZhangHao("头像", null, null,null));
        users.add(new ZhangHao(null, "昵称", null,null));
        users.add(new ZhangHao(null, null, "修改账号邮箱",null));
        users.add(new ZhangHao(null, null, "修改密码",null));
        users.add(new ZhangHao(null,null,null,"退出当前登录"));

    }

}
