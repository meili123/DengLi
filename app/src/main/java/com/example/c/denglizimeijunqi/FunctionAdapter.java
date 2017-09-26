package com.example.c.denglizimeijunqi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by C on 2017/9/21.
 */

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder> {

    private Context mcontext;

    private List<Functionall> mFunctialList;

    /**
     * 定义view持有者这个类
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
        View view;
        /**
         * 获取View里面的布局实例
         */
        public ViewHolder(View itemView) {
            super(itemView);
            view=itemView;
            fruitImage=(ImageView)itemView.findViewById(R.id.function_image);
            fruitName=(TextView)itemView.findViewById(R.id.textview_name);
        }
    }



    /**
     * 把要展示的数据源传进来
     */
    public FunctionAdapter(List<Functionall>functionalList){
        mFunctialList=functionalList;
    }
    /**
     *  必须重写onCreatViewHolder onBindViewHolder getItemCount三个方法
     *   创造ViewHolder实例
     */


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcontext==null){
            mcontext=parent.getContext();
        }
    /**
    * 加载fruit_item布局
    */
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.functional_item,parent,false);
        /**
         *把加载的布局viewc传入holder
         */

        final ViewHolder holder=new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *获取当前位置
                 */
                int position=holder.getAdapterPosition();
                /**
                 *拿到fruit实例
                 */
                Functionall fruit=mFunctialList.get(position);
                if(fruit.getName().equals("设备运行状态")){
                    Intent intent=new Intent(mcontext,RunActivity.class);
                    mcontext.startActivity(intent);
                }else if (fruit.getName().equals("帮助")){
                    Intent intent=new Intent(mcontext,BangZhuActivity.class);
                    mcontext.startActivity(intent);

                }else if (fruit.getName().equals("发现")){
                    Intent intent=new Intent(mcontext,FaXianActivity.class);
                    mcontext.startActivity(intent);

                }else if(fruit.getName().equals("包装")){
                    Intent intent=new Intent(mcontext,BaoZhuangActivity.class);
                    mcontext.startActivity(intent);
                }

            }
        });
        return holder;

    }
    /**
     * 对ViewHjolder进行赋值，滚动时候执行
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /**
         *获取当前实例
         */
        Functionall fruit=mFunctialList.get(position);
        /**
         *设置数据
         */
        holder.fruitName.setText(fruit.getName());
        Glide.with(mcontext).load(fruit.getImageId()).into(holder.fruitImage);

    }
    /**
     *返回长度
     */
    @Override
    public int getItemCount() {

        return mFunctialList.size();
    }



}
