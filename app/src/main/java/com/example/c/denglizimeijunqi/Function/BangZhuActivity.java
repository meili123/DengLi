package com.example.c.denglizimeijunqi.Function;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.c.denglizimeijunqi.MainActivity;
import com.example.c.denglizimeijunqi.R;
import com.sevenheaven.segmentcontrol.SegmentControl;

public class BangZhuActivity extends AppCompatActivity {
    private String[] data={"人生就像一盘棋，举棋容易扶择难；\n" +
            "人生就像一盘棋，观棋容易不语难；\n" +
            "人生就像一盘棋，下棋容易胜棋难；\n" +
            "人生就像一盘棋，识棋容易知棋难；\n" +
            "人生就像一盘棋，见棋容易爱棋难；\n" +
            "人生就像一盘棋，知棋容易解棋难；\n" +
            "人生就像一盘棋，漂泊之心在孤疑；\n" +
            "人生就像一盘棋，枫叶飘零随友真；\n" +
            "人生就像一盘棋，异地兄妹情谊深；\n" +
            "人生就像一盘棋，海阔天空心意诚；\n" +
            "人生就像一盘棋，众花绽放一朵红；\n" +
            "人生就像一盘棋，百花凋谢茶花存；\n" +
            "人生就像一盘棋，爱心之花最最纯；\n" +
            "人生就像一盘棋，漂泊之人真爱寻；\n" +
            "人生就像一盘棋，真爱难觅亦自求；\n" +
            "人生就像一盘棋，谁解漂泊之人心？\n" +
            "人生就像一盘棋，惟有星星仁爱真；\n" +
            "人生就像一盘棋，开弓没有回头箭；\n" +
            "人生就像一盘棋，勇往直前男子汉；\n" +
            "人生就像一盘棋，难走亦走结心友。\n" +
            "大有小调一句句，兄弟之情切切记。\n" +
            "眼前美景纵无限，有朝会见珠峰面。\n" +
            "屹立峰巅鸟瞰山，华夏娇容收眼前。\n" +
            "漆黑夜晚静谧美，炙热晴日真情现。\n" +
            "淅沥绵雨听星心，朗月高空爱意真。","苹果","水蜜桃","橘子","香蕉","苹果","水蜜桃","橘子","香蕉","苹果","水蜜桃","橘子","香蕉","苹果",
            "水蜜桃","橘子","香蕉","苹果","水蜜桃","橘子","香蕉","苹果","水蜜桃","橘子"};
    private  ListView zhunbeilistView;
    private  ListView shuominglistView;
    private  ListView zhuyilistView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_zhu);
        Button button=(Button)findViewById(R.id.bangzhu_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(BangZhuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(BangZhuActivity.this,android.R.layout.simple_list_item_1,data);
        zhunbeilistView=(ListView)findViewById(R.id.zhunbei_Listview);
        zhunbeilistView.setAdapter(adapter);

        shuominglistView=(ListView)findViewById(R.id.shuoming_Listview);
        shuominglistView.setAdapter(adapter);

        zhuyilistView=(ListView)findViewById(R.id.zhuyi_Listview);
        zhuyilistView.setAdapter(adapter);
        SegmentControl segmentControl_horizon=(SegmentControl)findViewById(R.id.segment_control);
        segmentControl_horizon.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                if (index==0){
                    zhunbeilistView.setVisibility(View.VISIBLE);
                    shuominglistView.setVisibility(View.GONE);
                    zhuyilistView.setVisibility(View.GONE);
                }else if (index==1){
                    zhunbeilistView.setVisibility(View.GONE);
                    shuominglistView.setVisibility(View.VISIBLE);
                    zhuyilistView.setVisibility(View.GONE);
                }else if (index==2){
                    zhunbeilistView.setVisibility(View.GONE);
                    shuominglistView.setVisibility(View.GONE);
                    zhuyilistView.setVisibility(View.VISIBLE);
                }

            }
        });

    }
}
