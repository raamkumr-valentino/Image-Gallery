package com.example.raamkumr.imagegallery;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class gridpage extends AppCompatActivity {
    private GridView gridView;
    private gridviewadapter gridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridpage);
        gridView=(GridView)findViewById(R.id.grid_id);
        gridViewAdapter=new gridviewadapter(this,R.layout.grid_item,getData());
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageItem item=(ImageItem)parent.getItemAtPosition(position);
                Intent intent=new Intent(gridpage.this,detailedactivity.class);
                int hash=item.hashCode();
               // intent.putExtra("hashcode",hash);
                intent.putExtra("title",item.getTitle());
                //intent.putExtra("image",item.getImage());
                intent.putExtra("pos",position);
                startActivity(intent);
            }
        });
    }
    private ArrayList<ImageItem> getData()
    {
        final ArrayList<ImageItem> imageItems=new ArrayList<>();
        TypedArray imgs=getResources().obtainTypedArray(R.array.image_ids);
        String[] names=getResources().getStringArray(R.array.names);
        for(int i=0;i<imgs.length();i++)
        {
            Bitmap bitmap= BitmapFactory.decodeResource(getResources(),imgs.getResourceId(i,-1));
            imageItems.add(new ImageItem(bitmap,names[i]));
        }
        return imageItems;
    }
}
