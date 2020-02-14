package com.e.loaddata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialComponent();


        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();

            }
        });
    }

    public void getData(){
        InputStream jsonFile = getResources().openRawResource(R.raw.data_diri);
        SimpleAsyncTask simpleAsyncTask = new SimpleAsyncTask(getApplicationContext(), recyclerView);
        simpleAsyncTask.execute(jsonFile);

    }

    public void initialComponent(){
        btnLoad = findViewById(R.id.btnLoad);
        recyclerView = findViewById(R.id.rv_cardview);
    }
}
