package com.example.c.denglizimeijunqi.nav_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.c.denglizimeijunqi.R;

import java.util.List;

/**
 * Created by C on 2017/9/27.
 */

/**
 * 设置图的适配器
 */
public class SheZhiAdapter extends ArrayAdapter<Shezhitu> {
    private int resourceId;
    /**
     * @param context 上下文
     * @param textViewResourceId 资源id
     * @param objects 数据
     */
    public SheZhiAdapter(Context context, int textViewResourceId, List<Shezhitu> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }
    @Override
    public View getView(int postion, View conterView, ViewGroup parent){
        Shezhitu shezhitu=getItem(postion);
        /**
         * 如果为空，则使用ConterView加载布局，如果不为空则直接对conterView进行重用；
         */
        View view;
        ViewHolder viewHolder;
        if (conterView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            /**
             * 获取实例
             */
            viewHolder=new ViewHolder();
            viewHolder.shezhituImage=(ImageView)view.findViewById(R.id.shezhi_imageview);
            viewHolder.sehzhituName=(TextView)view.findViewById(R.id.shezhi_textView);
            view.setTag(viewHolder);

        }else {
            view=conterView;
            /**
             * 重新获取实例
             */
            viewHolder=(ViewHolder)view.getTag();
        }
        /**
         * 添加实物
         */
        viewHolder.shezhituImage.setImageResource(shezhitu.getImageId());
        viewHolder.sehzhituName.setText(shezhitu.getName());
        /**
         * 废弃方法
         * ImageView shezhituImage=(ImageView)view.findViewById(R.id.shezhi_imageview);
         *  TextView sehzhituName=(TextView)view.findViewById(R.id.shezhi_textView);
         *   shezhituImage.setImageResource(shezhitu.getImageId());
         *   sehzhituName.setText(shezhitu.getName());
         *
         */
        return  view;
    }
    class ViewHolder{
        ImageView shezhituImage;
        TextView sehzhituName;
    }

}
