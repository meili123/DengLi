package com.example.c.denglizimeijunqi.SheZhi;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.XiugaiZhanghaoYouXiang.XiuGaiMiMaActivity;
import com.example.c.denglizimeijunqi.XiugaiZhanghaoYouXiang.XiuGaiYouXiangActivity;
import com.example.c.denglizimeijunqi.denglu.BaseActivity;
import com.example.c.denglizimeijunqi.nav_view.SheZhiActivity;
import com.example.c.denglizimeijunqi.nav_view.SheZhiAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.c.denglizimeijunqi.R.id.view;

public class ZhangHaoGuanLiActivity extends BaseActivity {
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
                    final  View mTitlrView= getLayoutInflater().inflate(R.layout.zhangtitle,null);
                    final EditText uname = (EditText)mTitlrView.findViewById(R.id.tixingedit);
                    AlertDialog.Builder dialog = new AlertDialog.Builder(ZhangHaoGuanLiActivity.this);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String input = uname.getText().toString();
                            Log.d("ZhangHaoGuanLiActivity1",input);
                        }

                    });
                    dialog.setNegativeButton("取消", null);
//                    dialog.setCustomTitle(mTitlrView);
                    dialog.setView(mTitlrView);
                    dialog.show();
                } else if (i == 2) {
                    Intent intent=new Intent(ZhangHaoGuanLiActivity.this, XiuGaiYouXiangActivity.class);
                    startActivity(intent);

                } else if (i == 3) {
                    Intent intent=new Intent(ZhangHaoGuanLiActivity.this, XiuGaiMiMaActivity.class);
                    startActivity(intent);
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

        Button button1=(Button)findViewById(R.id.zhanghaoguanli_button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("com.example.c.denglizimeijunqi.denglu.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });


    }
    private void initdata() {
        users = new ArrayList<ZhangHao>();
        users.add(new ZhangHao("头像", null, null,null));
        users.add(new ZhangHao(null, "昵称", null,null));
        users.add(new ZhangHao(null, null, "修改账号邮箱",null));
        users.add(new ZhangHao(null, null, "修改密码",null));

    }

}
