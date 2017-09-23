package com.example.c.denglizimeijunqi;

import android.graphics.drawable.Drawable;
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
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;


public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private Functionall[] fruits={
            new Functionall("开关",R.drawable.kaiguan),
            new Functionall("灭菌时间显示",R.drawable.shijian),
            new Functionall("报警信息",R.drawable.baojing)};
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
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
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
