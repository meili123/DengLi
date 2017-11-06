package com.example.c.denglizimeijunqi.FaXian;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.denglu.LoginActivity;
import java.util.ArrayList;
import java.util.List;

public class FaXianActivity extends AppCompatActivity {
    private List<ZeroImage> zeroImageList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fa_xian);
        Button button=(Button)findViewById(R.id.faxian_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FaXianActivity.this, MainActivity.class));
                finish();
            }
        });
        initFruits();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.faxianRecyler);
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        ZeroAdapter zeroAdapter=new ZeroAdapter(zeroImageList);
        recyclerView.setAdapter(zeroAdapter);

    }
    private void initFruits(){
        ZeroImage zeroImage=new ZeroImage("百度");
        ZeroImage zeroImage2=new ZeroImage("等离子灭菌器简介");
        ZeroImage zeroImage3=new ZeroImage("医疗器械产品视频");
        ZeroImage zeroImage4=new ZeroImage("医学博物馆");
        zeroImageList.add(zeroImage);
        zeroImageList.add(zeroImage2);
        zeroImageList.add(zeroImage3);
        zeroImageList.add(zeroImage4);

    }
}
