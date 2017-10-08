package com.example.c.denglizimeijunqi.denglu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;

public class LoginActivity extends BaseActivity {
    private EditText accounteditText;
    private EditText passwordeditText;
    private Button login;

//    记住密码
    private SharedPreferences pref;
    private  SharedPreferences.Editor editor;
    private CheckBox rememberpass;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        获取当前存储器
        pref= PreferenceManager.getDefaultSharedPreferences(this);

        accounteditText=(EditText)findViewById(R.id.yonghu);
        passwordeditText=(EditText)findViewById(R.id.mima);
//        检验箱
        rememberpass=(CheckBox)findViewById(R.id.remember);
        boolean isRemember=pref.getBoolean("记住密码",false);
        if(isRemember){
            //将账号和密码设置到文本框中
            String account=pref.getString("account","");
            String password=pref.getString("password","");
            accounteditText.setText(account);
            passwordeditText.setText(password);
            rememberpass.setChecked(true);
        }
        login=(Button)findViewById(R.id.Button1);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                获取用户名字符串
                String accout=accounteditText.getText().toString();
                String password=passwordeditText.getText().toString();
//                如果账号admin且密码是123456，就认为是登录成功
                if(accout.equals("admin")&&password.equals("123456")){
                    editor=pref.edit();
                    if (rememberpass.isChecked()){
                        editor.putBoolean("记住密码",true);
                        editor.putString("account",accout);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"密码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
