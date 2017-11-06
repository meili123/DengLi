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
public class BaoZhuangActivity extends AppCompatActivity {
   private  String[] data={
           "1.包装的名牌\n" +
                   "    1)有产品的名称及型号；\n" +
                   "    2）有制造商的名称和商标；\n" +
                   "    3)使用的电源电压、频率和功率；\n" +
                   "    4）出厂日期（年、月）或出厂编号；\n" +
                   "    5）制造商生产许可文号和产品许可文号；\n" +
                   "    6）包装的名牌在机器的后下方位置，用户可以随时去查看。\n",
           "2.包装箱上的标志\n" +
                   "    1）制造商名称和厂址；\n" +
                   "    2）产品名称和型号；\n" +
                   "    3）商标；\n" +
                   "    4）净重及毛重，这个我们写在包装箱外面；\n" +
                   "    5）体积（长X宽X高）；\n" +
                   "    6)制造年月或生产批号；\n" +
                   "    7)包装上有“向上”、“小心装卸”等标志，符合GBT/191及YY0466的规定。\n",
           "3.包装\n" +
                   "    1）包装先用加厚版蜂窝箱进行初次包装，可以防潮，结实；\n" +
                   "    2）外有塑料薄膜，可以进一步防潮，保护灭菌器；\n",
           "4.包装的随机文件:\n" +
                   "    1）装箱单；\n" +
                   "    2）随机配件、配件及配件清单；\n" +
                   "    3）保修单；\n" +
                   "    4）检验合格证；\n" };
    private ListView baozhuangListview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_zhuang);
        Button button=(Button)findViewById(R.id.baozhuang_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaoZhuangActivity.this,MainActivity.class));
                finish();
            }
        });

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(BaoZhuangActivity.this,android.R.layout.simple_list_item_1,data);
        baozhuangListview=(ListView)findViewById(R.id.baozhuang_listview);
        baozhuangListview.setAdapter(adapter);


    }
}
