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
import android.widget.TextView;
import android.widget.Toast;
import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.shujuku.UserData;
import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
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
    private  boolean isRemember;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref=PreferenceManager.getDefaultSharedPreferences(this);

        accounteditText=(EditText)findViewById(R.id.yonghu);
        passwordeditText=(EditText)findViewById(R.id.mima);
        //检验箱
        rememberpass=(CheckBox)findViewById(R.id.remember);
        isRemember=pref.getBoolean("remember_password",false);
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
    public void qqDengLu(View view) {

        Platform qq = ShareSDK.getPlatform(QQ.NAME);
//回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
        qq.setPlatformActionListener(new PlatformActionListener() {
            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                // TODO Auto-generated method stub
                arg2.printStackTrace();
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                // TODO Auto-generated method stub
                //输出所有授权信息
                System.out.println(arg2);
                String name=(String)arg2.get("nickname");
                Log.d("年后",name);
                Intent intent5=new Intent(LoginActivity.this,MainActivity.class);
                intent5.putExtra("yonghuming",name);
                startActivity(intent5);

            }
            @Override
            public void onCancel(Platform arg0, int arg1) {
                // TODO Auto-generated method stub
            }
        });
        qq.removeAccount(true);
        qq.SSOSetting(false);
        //authorize与showUser单独调用一个即可
        //qq.authorize();//单独授权,OnComplete返回的hashmap是空的
        qq.showUser(null);//授权并获取用户信息

    }
    public void weiBoDengLu(View view){
        Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
        //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行
        weibo.setPlatformActionListener(new PlatformActionListener() {

            @Override
            public void onError(Platform arg0, int arg1, Throwable arg2) {
                // TODO Auto-generated method stub
                arg2.printStackTrace();
            }

            @Override
            public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
                // TODO Auto-generated method stub
                //输出所有授权信息
                System.out.println(arg2);
                String name1=(String)arg2.get("screen_name");
                Intent intent5=new Intent(LoginActivity.this,MainActivity.class);
                intent5.putExtra("yonghuming",name1);
                startActivity(intent5);
            }
            @Override
            public void onCancel(Platform arg0, int arg1) {

            }
        });
        weibo.SSOSetting(false);
        weibo.removeAccount(true);
        weibo.showUser(null);//执行登录，登录后在回调里面获取用户资料
    }

}



















