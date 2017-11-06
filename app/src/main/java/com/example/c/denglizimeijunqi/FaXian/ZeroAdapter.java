package com.example.c.denglizimeijunqi.FaXian;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.c.denglizimeijunqi.R;
import java.util.List;
/**
 * Created by C on 2017/10/13.
 */

public class ZeroAdapter extends RecyclerView.Adapter<ZeroAdapter.ViewHolder> {
    private List<ZeroImage> zeroImageList;
    private Context mcontext;


    static class ViewHolder extends RecyclerView.ViewHolder{
        View newView;
        TextView textView;
        public ViewHolder(View view){
            super(view);
            newView=view;
            textView=(TextView)view.findViewById(R.id.textView123);
        }
    }

    public ZeroAdapter(List<ZeroImage> imageList){
        zeroImageList=imageList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mcontext==null){
            mcontext=parent.getContext();
        }
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.zerome_item,parent,false);
      final ViewHolder viewHolder=new ViewHolder(view);
        viewHolder.newView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position=viewHolder.getAdapterPosition();
                ZeroImage zeroImage=zeroImageList.get(position);
                if (zeroImage.getName().equals("百度")){
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.baidu.com"));
                    mcontext.startActivity(intent);
                }else if(zeroImage.getName().equals("等离子灭菌器简介")){
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.tuoren.com/html/cn/products97pcon1515.html"));
                    mcontext.startActivity(intent);
                }else if (zeroImage.getName().equals("医疗器械产品视频")){
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.tuoren.com/html/cn/products77.html"));
                    mcontext.startActivity(intent);
                }else if (zeroImage.getName().equals("医学博物馆")){
                    Intent intent=new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.tuoren.com/html/cn/sale.html"));
                    mcontext.startActivity(intent);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ZeroImage zeroImage=zeroImageList.get(position);
        holder.textView.setText(zeroImage.getName());
    }

    @Override
    public int getItemCount() {
        return zeroImageList.size();
    }



}
