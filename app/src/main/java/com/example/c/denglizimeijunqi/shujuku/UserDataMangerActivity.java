package com.example.c.denglizimeijunqi.shujuku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.c.denglizimeijunqi.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class UserDataMangerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data_manger);
        Button addData = (Button) findViewById(R.id.Add_data_buttton);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserData userData = new UserData();
                userData.setUserId(1);
                userData.setUserName("小明");
                userData.setUserPwd("xyz123");
                userData.save();//从DataSupport类中继承的方法，其中提供了丰富的CRUD方法
            }
        });
////更新数据
        Button updateData = (Button) findViewById(R.id.Updata_data_button);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //第一种方法更新数据
                UserData userData = new UserData();
                userData.setUserId(2);
                userData.setUserName("小红");
                userData.setUserPwd("xyz456");
                userData.save();//从DataSupport类中继承的方法，其中提供了丰富的CRUD方法
                userData.setUserId(3);
                userData.save();
//
////第二种方法更新数据
//                Book book = new Book();
////                全部更新
//                book.setPrice(14.95);
//                book.setPress("Anchor");
//                book.updateAll("name = ? and author = ?", "The Lost Symbol", "Dan Brown");
            }
        });
////        删除数据
//
        Button deleteData = (Button) findViewById(R.id.Delete_data_button);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DataSupport.deleteAll(UserData.class, " UserId= ?", "1");//不指定约束条件，则删除所有数据
            }
        });
////        查询数据
        Button queryData = (Button) findViewById(R.id.query_data_button);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<UserData> books = DataSupport.findAll(UserData.class);
                for (UserData book : books){
                    Log.d("MainActivity", "book name is " + book.getUserName());
                    Log.d("MainActivity", "book author is " + book.getUserPwd());
                    Log.d("MainActivity", "book pages is " + book.getUserId());
                }
            }
        });

    }
}
