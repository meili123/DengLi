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

import java.util.ArrayList;
import java.util.List;

public class FaXianActivity extends AppCompatActivity {
    private  String[] data={"等离子灭菌器","产品信息","产品介绍","等离子灭菌器","产品信息","产品介绍","等离子灭菌器","产品信息","产品介绍",
            "等离子灭菌器","产品信息","产品介绍","等离子灭菌器","产品信息","产品介绍"};
    private ListView faxianListview;
    private List<ZeroImage> zeroImageList=new ArrayList<>();

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
        initFruits();
        ZeroAdapter zeroAdapter=new ZeroAdapter(FaXianActivity.this,R.layout.zerome_item,zeroImageList);
        faxianListview=(ListView)findViewById(R.id.faxian_listview);
        faxianListview.setAdapter(zeroAdapter);

//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(FaXianActivity.this,android.R.layout.simple_list_item_1,data);
//        faxianListview=(ListView)findViewById(R.id.faxian_listview);
//        faxianListview.setAdapter(adapter);
    }
    private void initFruits(){
        ZeroImage zeroImage=new ZeroImage(R.mipmap.shan);
        ZeroImage zeroImage2=new ZeroImage(R.mipmap.tedian);
        ZeroImage zeroImage3=new ZeroImage(R.mipmap.zero2);
        ZeroImage zeroImage4=new ZeroImage(R.mipmap.zero4);
        ZeroImage zeroImage5=new ZeroImage(R.mipmap.zero6);
        ZeroImage zeroImage6=new ZeroImage(R.mipmap.zero3);
        zeroImageList.add(zeroImage);
        zeroImageList.add(zeroImage2);
        zeroImageList.add(zeroImage3);
        zeroImageList.add(zeroImage4);
        zeroImageList.add(zeroImage5);
        zeroImageList.add(zeroImage6);

    }
}
