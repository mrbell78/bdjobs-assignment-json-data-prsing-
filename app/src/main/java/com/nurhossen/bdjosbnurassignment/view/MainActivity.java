package com.nurhossen.bdjosbnurassignment.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.nurhossen.bdjosbnurassignment.R;
import com.nurhossen.bdjosbnurassignment.service.model.Datum;
import com.nurhossen.bdjosbnurassignment.service.repository.BdjosbdataRepository;
import com.nurhossen.bdjosbnurassignment.viewmodel.MainActivityViewmodel;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    List<Datum> orgdata;
    MainActivityViewmodel viewmodel;
    BdjosbdataRepository data = new BdjosbdataRepository();

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
}