package com.example.c.denglizimeijunqi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.nav_view.SheZhiActivity;
import com.example.c.denglizimeijunqi.nav_view.TianJiaSheBeiActivity;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Functionall[] fruits={
            new Functionall("设备运行状态",R.drawable.yunxing),
            new Functionall("帮助",R.drawable.bangzhu),
            new Functionall("发现",R.drawable.faxian),
            new Functionall("包装",R.drawable.baozhuang)};
    private List<Functionall> functionalist=new ArrayList<>();
    private FunctionAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 左侧的navview
         */

        NavigationView navigationView=(NavigationView)findViewById(R.id.nav_view);
        View headview=navigationView.inflateHeaderView(R.layout.nav_header);

        ImageView head_iv= (ImageView) headview.findViewById(R.id.xiaogou);

        head_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TuiChuZhangHaoActivity.class);
                startActivity(intent);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.shezhi:
                        Intent intent=new Intent(MainActivity.this, SheZhiActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.tianjiashebei:
                        Intent intent1=new Intent(MainActivity.this, TianJiaSheBeiActivity.class);
                        startActivity(intent1);
                        break;
                    default:
                }
                return true;
            }
        });
        /**
         * 自定义ToorBar
         */
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**
         * 左侧菜单
         */
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.selected_buton);
            actionBar.setDisplayShowCustomEnabled(true);
        }
        /**
         * 初始化数据
         */
        ininFruits();
        /**
         * 创建瀑布流
         */
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new FunctionAdapter(functionalist);
        recyclerView.setAdapter(adapter);



    }

    /**
     * 加载菜单布局
     */
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//       getMenuInflater().inflate(R.menu.toolbar,menu);
//        return true;
//    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        setIconEnable(menu,true);
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }
    private void setIconEnable(Menu menu, boolean enable)
    {
        try
        {
            Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");
            Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);
            m.setAccessible(true);
            //下面传入参数
            m.invoke(menu, enable);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * 实现菜单点击事件
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"你点击了添加按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"你点击了删除按钮",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

/**
 * 添加数据
 */
private void ininFruits(){
    for (int i=0;i<fruits.length;i++){
        functionalist.add(fruits[i]);
    }
}


}
