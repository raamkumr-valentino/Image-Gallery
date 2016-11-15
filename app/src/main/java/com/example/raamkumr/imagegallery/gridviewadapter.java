package com.example.raamkumr.imagegallery;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RaamKumr on 9/20/2016.
 */
public class gridviewadapter extends ArrayAdapter {
    private Context context;
    private int layoutresourceid;
    private ArrayList data=new ArrayList();

    public gridviewadapter(Context context,int layoutresourceid,ArrayList data)
    {
        super(context,layoutresourceid,data);
        this.layoutresourceid=layoutresourceid;
        this.context=context;
        this.data=data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        ViewHolder holder = null;
        if(row==null)
        {
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(layoutresourceid,parent,false);
            holder = new ViewHolder();
            holder.imageTitle=(TextView)row.findViewById(R.id.txt_id);
            holder.image=(ImageView)row.findViewById(R.id.img_id);
            row.setTag(holder);
        }else
        {
            holder=(ViewHolder)row.getTag();
        }
        ImageItem item= (ImageItem) data.get(position);
        holder.imageTitle.setText(item.getTitle());
        holder.image.setImageBitmap(item.getImage());
        return  row;
    }

    static class ViewHolder
    {
        TextView imageTitle;
        ImageView image;
    }
}
