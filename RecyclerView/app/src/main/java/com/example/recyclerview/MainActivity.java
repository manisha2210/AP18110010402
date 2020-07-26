package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int image[]={R.drawable.alpha,R.drawable.beta,R.drawable.cupcake,R.drawable.donut,R.drawable.eclair,R.drawable.froyo,R.drawable.gingerbread,R.drawable.honeycomb,R.drawable.icecreamsandwich,R.drawable.jellybean,R.drawable.kitkat,
            R.drawable.lollipop,R.drawable.marshmallow,R.drawable.nougat,R.drawable.oreo,R.drawable.pie,R.drawable.q};
    String names[]={"Alpha","Beta","Cupcake","Donut","Eclair","Froyo","Gingerbread","Honeycomb","Ice Cream Sandwich","Jelly Bean","KitKat","Lollipop","Marshmallow","Nougat","Oreo","Pie","Q"};
    String version[]={"1.0","1.1","1.5","1.6","2.0-2.1","2.2-2.2.3","2.3-2.3.7","3.0-3.2.6","4.0-4.0.4","4.1-4.3.1","4.4-4.4.4","5-5.1","6","7-7.1","8-8.1","9","10"};
    String api[]={"API level 1","API level 2","API level 3","API level 4","API level 7","API level 8","API level 10","API level 13","API level 15","API level 18","API level 20","API level 22","API level 23","API level 25","API level 27","API level 28","API level 29"};
    String release[]={"September 23, 2008","February 9, 2009","April 27, 2009","September 15, 2009","October 26, 2009","May 20, 2010",
            "December 6, 2010","February 22, 2011","October 18, 2011","July 9, 2012","October 31, 2013","November 12, 2014","October 5, 2015",
            "October 4, 2016","December 5, 2017","August 6, 2018","September 3, 2019"};
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv=findViewById(R.id.recycler);
        rv.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter obj=new MyAdapter(this,image,names,version,api,release);
        rv.setAdapter(obj);

    }
}