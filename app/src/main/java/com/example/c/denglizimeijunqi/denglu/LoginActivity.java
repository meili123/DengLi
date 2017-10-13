package com.example.c.denglizimeijunqi.denglu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.shujuku.UserData;
import com.example.c.denglizimeijunqi.shujuku.UserDataMangerActivity;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginActivity extends BaseActivity {
    private EditText accounteditText;
    private EditText passwordeditText;
    private TextView textView;
    private Button login;
    private Button zhuce;
    private List<UserData> list=new ArrayList<>();
    private String password;
    private String user;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private CheckBox rememberpass;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref=PreferenceManager.getDefaultSharedPreferences(this);

        accounteditText=(EditText)findViewById(R.id.yonghu);
        passwordeditText=(EditText)findViewById(R.id.mima);
        //检验箱
        rememberpass=(CheckBox)findViewById(R.id.remember);
        boolean isRemember=pref.getBoolean("remember_password",false);
        //如果上次选了记住密码，那进入登录页面也自动勾选记住密码，并填上用户名和密码
        if (isRemember){
            //将账号和密码设置到文本框中
            String account=pref.getString("account","");
            String pass=pref.getString("pasword","");
            accounteditText.setText(account);
            passwordeditText.setText(pass);
            rememberpass.setChecked(true);
        }
        login=(Button)findViewById(R.id.Button1);
        textView=(TextView)findViewById(R.id.change_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,XiuGaiMiMaActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user=accounteditText.getText().toString();
                password=passwordeditText.getText().toString();
//                获取用户名字符串
                list= DataSupport.findAll(UserData.class);
                for (UserData person:list)

                {
                    Log.d("用户名", "nihao name is " + person.getUserName());
                    Log.d("密码", "nihao author is " + person.getUserPwd());
                    if(person.getUserName().equals(user)&&person.getUserPwd().equals(password)
                            &&(user.length()>0)&&(password.length()>0))
                    {
                        editor=pref.edit();
                        if (rememberpass.isChecked()){//检查复选框是否被选中
                            editor.putBoolean("remember_password",true);
                            editor.putString("account",user);
                            editor.putString("pasword",password);
                        }else {
                            editor.clear();
                        }
                        editor.apply();

                        Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
                        intent1.putExtra("yonghuming",user);
                        intent1.putExtra("mima",password);
                        startActivity(intent1);
                        Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        break;
                    } else  if ((password.length()<=0)||(user.length()<=0)) {
                    Toast.makeText(LoginActivity.this,"登录失败",Toast.LENGTH_SHORT).show();break;}
                }


//                (!(person.getUserName().equals(user)))||(!person.getUserPwd().equals(password))
            }
        });

        zhuce=(Button)findViewById(R.id.btn_register);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, ZhuCeActivity.class);
                startActivity(intent);

            }
        });

    }

}




































//public class LoginActivity extends BaseActivity {
//    private EditText accounteditText;
//    private EditText passwordeditText;
//    private Button login;
//    private Button zhuce;
//    private List<UserData> list=new ArrayList<>();
//
//    //    记住密码
//    private SharedPreferences pref;
//    private  SharedPreferences.Editor editor;
//    private CheckBox rememberpass;
//    @Override
//    protected void onCreate(final Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        Connector.getDatabase();
//////        获取当前存储器
//        pref= PreferenceManager.getDefaultSharedPreferences(this);
//        accounteditText=(EditText)findViewById(R.id.yonghu);
//        passwordeditText=(EditText)findViewById(R.id.mima);
////        检验箱
//        rememberpass=(CheckBox)findViewById(R.id.remember);
//        boolean isRemember=pref.getBoolean("记住密码",false);
//        if(isRemember){
//            //将账号和密码设置到文本框中
//            String account=pref.getString("account","");
//            String password=pref.getString("password","");
//            accounteditText.setText(account);
//            passwordeditText.setText(password);
//            rememberpass.setChecked(true);
//        }
//        login=(Button)findViewById(R.id.Button1);
//
//
////        list= DataSupport.findAll(UserData.class);
////        Iterator<UserData> it=list.iterator();
////        for (UserData p:list)
////        {
////            if(p.getUserName().equals(accounteditText)&&p.getUserPwd().equals(passwordeditText))
////            {
////                Intent intent1=new Intent(LoginActivity.this,MainActivity.class);
////                startActivity(intent1);
////                Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
////                break;
////            }
////            else
////            {
////                Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
////            }
////        }
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                获取用户名字符串
//                String accout=accounteditText.getText().toString();
//                String password=passwordeditText.getText().toString();
////                如果账号admin且密码是123456，就认为是登录成功
//                if(accout.equals("admin")&&password.equals("123456")){
//                    editor=pref.edit();
//                    if (rememberpass.isChecked()){
//                        editor.putBoolean("记住密码",true);
//                        editor.putString("account",accout);
//                        editor.putString("password",password);
//                    }else {
//                        editor.clear();
//                    }
//                    editor.apply();
//                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                    startActivity(intent);
//                }else {
//                    Toast.makeText(LoginActivity.this,"密码不正确", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        zhuce=(Button)findViewById(R.id.btn_register);
//        zhuce.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Intent intent=new Intent(LoginActivity.this, UserDataMangerActivity.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//}





