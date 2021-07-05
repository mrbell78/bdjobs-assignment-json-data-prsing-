package com.nurhossen.bdjosbnurassignment.view;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.nurhossen.bdjosbnurassignment.R;
import com.nurhossen.bdjosbnurassignment.service.model.Datum;
import com.nurhossen.bdjosbnurassignment.service.repository.BdjosbdataRepository;
import com.nurhossen.bdjosbnurassignment.viewmodel.MainActivityViewmodel;

import java.util.ArrayList;
import java.util.List;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;


import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    List<Datum> orgdata;
    MainActivityViewmodel viewmodel;
    BdjosbdataRepository data = new BdjosbdataRepository();

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        recyclerView=findViewById(R.id.recylerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        viewmodel = new ViewModelProvider(this).get(MainActivityViewmodel.class);
        viewmodel.getdata().observe(this, new Observer<List<Datum>>() {
            @Override
            public void onChanged(List<Datum> data) {
                Log.d(TAG, "onChanged: this is the returned data "+ data.size());
                Log.d(TAG, "onChanged: this is the returned data "+ data.get(1).getJobTitle());

                AdapterView adpter = new AdapterView(data,MainActivity.this );
                recyclerView.setAdapter(adpter);


            }
        });
        //Log.d(TAG, "onCreate: tAche data is "+ orgdata.get(1).getJobTitle());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}