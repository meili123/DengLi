package com.example.c.denglizimeijunqi.Function;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.example.c.denglizimeijunqi.R;

import java.util.List;

/**
 * Created by C on 2017/10/13.
 */

public class ZeroAdapter extends ArrayAdapter<ZeroImage> {
    private int resourceID;
    public ZeroAdapter(Context context, int textresourceID, List<ZeroImage> objects) {
        super(context, textresourceID,objects);
        resourceID=textresourceID;
    }
    @Override
    public View getView(int positon, View convertView, ViewGroup parent){
        ZeroImage zeroImage=getItem(positon);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView zermImageview=(ImageView)view.findViewById(R.id.zeroImage);
        zermImageview.setImageResource(zeroImage.getImageId());
        return view;
    }
}
