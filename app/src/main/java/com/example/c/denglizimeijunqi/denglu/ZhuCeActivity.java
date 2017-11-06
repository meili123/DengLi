package com.example.c.denglizimeijunqi.denglu;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.shujuku.UserData;
import org.litepal.tablemanager.Connector;
public class ZhuCeActivity extends AppCompatActivity {
    private EditText account,password,twoPassWord;
    private Button save;
    private  String usernaeme,userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        account=(EditText)findViewById(R.id.resetpwd_edit_name);
        password=(EditText)findViewById(R.id.resetpwd_edit_pwd_old);
        twoPassWord=(EditText)findViewById(R.id.resetpwd_edit_pwd_new);
        save=(Button)findViewById(R.id.queding_btn);
        Connector.getDatabase();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData userData=new UserData();
                String username=account.getText().toString();
                String onePasword=password.getText().toString();
                String twoPasword=twoPassWord.getText().toString();
                userData.setUserName(username);
                userData.setUserPwd(onePasword);
//                userData.setUsertwoPwd(twoPasword);
                userData.save();
                Log.d("用户名",account.getText().toString());
                Log.d("密码",password.getText().toString());
                Log.d("第二次输入你的密码",twoPassWord.getText().toString());

                if ((onePasword.equals(twoPasword))&&(username.length()>0)&&(onePasword.length()>0)&&(twoPasword.length()>0)){
                    Toast.makeText(ZhuCeActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(ZhuCeActivity.this,LoginActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(ZhuCeActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
                }


            }
        });
             Button cancel=(Button)findViewById(R.id.quxioa_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ZhuCeActivity.this, LoginActivity.class));
                finish();
            }
        });
        Button quxioa=(Button)findViewById(R.id.zhuce_button);
        quxioa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ZhuCeActivity.this, LoginActivity.class));
                finish();

            }
        });
//        Button delete=(Button)findViewById(R.id.delete_btn);
//        delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DataSupport.deleteAll(UserData.class, "userPwd= ?", "");
//
//            }
//        });

    }
}
