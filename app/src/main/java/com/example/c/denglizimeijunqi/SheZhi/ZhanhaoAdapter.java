package com.example.c.denglizimeijunqi.SheZhi;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c.denglizimeijunqi.R;
import com.example.c.denglizimeijunqi.nav_view.SheZhiAdapter;
import com.example.c.denglizimeijunqi.nav_view.Shezhitu;

import java.util.List;

import static android.R.id.candidatesArea;
import static android.R.id.list;

/**
 * Created by C on 2017/9/29.
 */


public class ZhanhaoAdapter extends BaseAdapter {

    //定义常用的参数
    private Context ctx;
    private int resourceId;
    private List<ZhangHao> zhangHaos;
    private LayoutInflater inflater;
    //为三种布局定义一个标识
    private final int TYPE1 = 0;
    private final int TYPE2 = 1;
    private final int TYPE3 = 2;
    private final int TYPE4 = 3;

    public ZhanhaoAdapter(Context context, List<ZhangHao> objects) {
        this.ctx = context;
        this.zhangHaos = objects;
        //别忘了初始化inflater
        inflater = LayoutInflater.from(ctx);
    }

    @Override
    public int getCount() {
        return zhangHaos.size();
    }

    @Override
    public ZhangHao getItem(int position) {
        return zhangHaos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     *
     * 这个方法必须重写，它返回了有几种不同的布局
     */
    @Override
    public int getViewTypeCount() {
        return 4;
    }

    /**
     *
     * 每个convertView都会调用此方法，获得当前应该加载的布局样式
     */
    @Override
    public int getItemViewType(int position) {
        //获取当前布局的数据
        ZhangHao u = zhangHaos.get(position);
        //哪个字段不为空就说明这是哪个布局
        //比如第一个布局只有item1_str这个字段，那么就判断这个字段是不是为空，
        //如果不为空就表明这是第一个布局的数据
        //根据字段是不是为空，判断当前应该加载的布局
        Log.i("LHD", u.toString());
        Log.i("LHD", "第一个返回值" + u.getItem1_str());
        Log.i("LHD", "第二个返回值" + u.getItem2_str());
        Log.i("LHD", "第三个返回值" + u.getItem3_str());
        Log.i("LHD", "第四个个返回值" + u.getItem3_str());
        if (u.getItem1_str() != null) {
            return TYPE1;
        } else if (u.getItem2_str() != null) {
            return TYPE2;
        } else if (u.getItem3_str() != null) {
            return TYPE3;
        }else {//如果前三个个字段都为空，那就一定是加载第四个布局啦。
            return TYPE4;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //初始化每个holder
        ViewHolder1 holder1 = null;
        ViewHolder2 holder2 = null;
        ViewHolder3 holder3 = null;
        ViewHolder4 holder4 = null;
        int type = getItemViewType(position);
        /**
         * 为每个convertiView添加不同类型的布局
         * 如果该内容为空就添加
         * 如果不为空就取出
         */
        if (convertView == null) {
            switch (type) {
                case TYPE1:
                    convertView = inflater.inflate(R.layout.oneitemlayout, null, false);
                    holder1 = new ViewHolder1();
                    holder1.item1_tv = (TextView) convertView.findViewById(R.id.item1);
                    convertView.setTag(holder1);
                    break;
                case TYPE2:
                    convertView = inflater.inflate(R.layout.twoitemlayout, null, false);
                    holder2 = new ViewHolder2();
                    holder2.item2_tv = (TextView) convertView.findViewById(R.id.item2);
                    convertView.setTag(holder2);
                    break;
                case TYPE3:
                    convertView = inflater.inflate(R.layout.threeitemlayout, null, false);
                    holder3 = new ViewHolder3();
                    holder3.item3_tv = (TextView) convertView.findViewById(R.id.item3);
                    convertView.setTag(holder3);
                    break;
                case TYPE4:
                    convertView=inflater.inflate(R.layout.fouritemlayout,null,false);
                    holder4=new ViewHolder4();
                    holder4.item4_tv=(TextView)convertView.findViewById(R.id.item4);
                    convertView.setTag(holder4);
                default:
                    break;
            }
        } else {
            switch (type) {
                case TYPE1:
                    holder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE2:
                    holder2 = (ViewHolder2) convertView.getTag();
                    break;
                case TYPE3:
                    holder3 = (ViewHolder3) convertView.getTag();
                    break;
                case TYPE4:
                    holder4=(ViewHolder4) convertView.getTag();
            }
        }
        //为布局设置数据
        switch (type) {
            case TYPE1:
                holder1.item1_tv.setText(zhangHaos.get(position).getItem1_str());
                break;
            case TYPE2:
                holder2.item2_tv.setText(zhangHaos.get(position).getItem2_str());
                break;
            case TYPE3:
                holder3.item3_tv.setText(zhangHaos.get(position).getItem3_str());
                break;
            case TYPE4:
                holder4.item4_tv.setText(zhangHaos.get(position).getItem4_str());
        }

        return convertView;
    }

    //为每种布局定义自己的ViewHolder
    public class ViewHolder1 {
        TextView item1_tv;
    }

    public class ViewHolder2 {
        TextView item2_tv;
    }

    public class ViewHolder3 {
        TextView item3_tv;
    }
    public class ViewHolder4 {
        TextView item4_tv;
    }

}