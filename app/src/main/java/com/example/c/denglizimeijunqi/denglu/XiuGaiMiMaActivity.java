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
import org.litepal.crud.DataSupport;
import java.util.ArrayList;
import java.util.List;
public class XiuGaiMiMaActivity extends AppCompatActivity {
    private EditText userName, oldPassword,newPassword,newNewPasword;
    private List<UserData> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiu_gai_mi_ma);
        Button xiugaimima=(Button)findViewById(R.id.xiugaimima_button);
        xiugaimima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(XiuGaiMiMaActivity.this, LoginActivity.class));
                finish();
            }
        });
        Button quxiao=(Button)findViewById(R.id.quxiaocan_btn);
        quxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(XiuGaiMiMaActivity.this, LoginActivity.class));
            finish();


            }
        });
        userName=(EditText)findViewById(R.id.ueser_text);
        oldPassword=(EditText)findViewById(R.id.jiu_text);
        newPassword=(EditText)findViewById(R.id.xin_text);
        newNewPasword=(EditText)findViewById(R.id.zuixin_text);
        Button xiugaiButtton=(Button)findViewById(R.id.xiugaiqueding_button);
        xiugaiButtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=userName.getText().toString();
                String old=oldPassword.getText().toString();
                String newP=newPassword.getText().toString();
                String newNew=newNewPasword.getText().toString();
                list= DataSupport.findAll(UserData.class);

                for (UserData person:list)

                {
                    Log.d("用户名", "zuimei name is " + person.getUserName());
                    Log.d("密码", "zuimei author is " + person.getUserPwd());

                    if(person.getUserName().equals(user)&&person.getUserPwd().equals(old)
                            &&(user.length()>0)&&(old.length()>0)&&(newP.equals(newNew)
                            &&(newNew.length()>0)&&(newP.length()>0)))
                    {
                        person.setUserPwd(newP);
                        person.save();
                        Intent intent1=new Intent(XiuGaiMiMaActivity.this,LoginActivity.class);
                        startActivity(intent1);
                        Toast.makeText(XiuGaiMiMaActivity.this,"修改成功",Toast.LENGTH_SHORT).show();
                        break;
                    } else if ((old.length()<=0)||(user.length()<=0)||(newP.length()<=0)||(newNew.length()<=0)){
                        Toast.makeText(XiuGaiMiMaActivity.this,"修改失败",Toast.LENGTH_SHORT).show();break;}
                }
            }
        });
    }
}
