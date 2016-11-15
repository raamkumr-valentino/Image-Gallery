package com.example.raamkumr.imagegallery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class detailedactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailedactivity);
        int[] arrays={R.drawable.img0,R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
        String title=getIntent().getStringExtra("title");
        int position=getIntent().getIntExtra("pos",0);
        TextView titletext=(TextView)findViewById(R.id.title_id);
        titletext.setText(title);
        ImageView imageView=(ImageView)findViewById(R.id.image);
        imageView.setImageResource(arrays[position]);

    }
}
