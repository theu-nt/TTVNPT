package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import DAO.DatabaseNews;
import adapter.dsTinAdapter;

public class tindatai extends AppCompatActivity {
TextView tv;
RecyclerView recyclerView;
Toolbar toolbar;
ArrayList<String>arrNgay;
adapter.dsTinAdapter dsTinAdapter;
RecyclerView.LayoutManager layoutManager;
ImageView anhtrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tindatai);
        recyclerView=findViewById(R.id.recylichsu);

        toolbar=findViewById(R.id.toolbardsTin);
        anhtrong=findViewById(R.id.anhtrong);

        tv=findViewById(R.id.tenls);

        ActionToolbar();

        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        Intent intent=getIntent();
        String kieu=intent.getStringExtra("kieu");
        tv.setText(kieu);
        ///////////////////////////////////////////
        if(kieu.equals("Tin đã tải")) {
        arrNgay= (ArrayList<String>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getTimeDown();
        if(arrNgay.size()>0){
            Collections.reverse(arrNgay);
            anhtrong.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);

                dsTinAdapter = new dsTinAdapter(getApplicationContext(), arrNgay,kieu);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(dsTinAdapter);
                dsTinAdapter.notifyDataSetChanged();
        }
        else{
            anhtrong.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        }

        }

        ////////////////////////////////
        if(kieu.equals("Tin đã xem")) {
            arrNgay= (ArrayList<String>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getTimehis();
            if(arrNgay.size()>0){
                Collections.reverse(arrNgay);
                anhtrong.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

                dsTinAdapter = new dsTinAdapter(getApplicationContext(), arrNgay,kieu);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(dsTinAdapter);
                dsTinAdapter.notifyDataSetChanged();
            }
            else{
                anhtrong.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
            }

        }
        //////////////////////////////
        if(kieu.equals("Tin đã lưu")) {

            arrNgay= (ArrayList<String>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getTimeSave();
            if(arrNgay.size()>0){
                Collections.reverse(arrNgay);
                anhtrong.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

                dsTinAdapter = new dsTinAdapter(getApplicationContext(), arrNgay,kieu);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(dsTinAdapter);
                dsTinAdapter.notifyDataSetChanged();
            }
            else{
                anhtrong.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
            }

        }
        //////////////////////
        if(kieu.equals("Tin đã thích")) {
            arrNgay= (ArrayList<String>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getTimeFav();
            if(arrNgay.size()>0){
                Collections.reverse(arrNgay);
                anhtrong.setVisibility(View.INVISIBLE);
                recyclerView.setVisibility(View.VISIBLE);

                dsTinAdapter = new dsTinAdapter(getApplicationContext(), arrNgay,kieu);
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(dsTinAdapter);
                dsTinAdapter.notifyDataSetChanged();
            }
            else{
                anhtrong.setVisibility(View.VISIBLE);
                recyclerView.setVisibility(View.INVISIBLE);
            }

        }


    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(tindatai.this,canhan.class);
                startActivity(intent);
            }
        });
    }
}