package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import DAO.DatabaseNews;
import adapter.downloadAdapter;
import adapter.dstimkiemAdapter;
import adapter.favoriteAdapter;
import adapter.historyAdapter;
import adapter.saveAdapter;
import model.Article;
import model.DownloadModel;
import model.FavoritesModel;
import model.HistoryModel;
import model.SaveModel;

public class canhan extends AppCompatActivity {
RecyclerView xemganday,tindatai,tindaluu,tindathich;

TextView dshis,dsdown,dsfav,dssave;
Toolbar toolbar;
ImageView img;
//dstimkiemAdapter adapter;
//TextView loadhis,loaddown,loadfav,loadmark;
adapter.favoriteAdapter favoriteAdapter;
adapter.saveAdapter saveAdapter;
adapter.historyAdapter historyAdapter;
adapter.downloadAdapter downloadAdapter;
    private RecyclerView.LayoutManager layoutManager,layoutManager1,layoutManager2,layoutManager3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canhan);

        xemganday=findViewById(R.id.recytinganday);
        tindatai=findViewById(R.id.recytindatai);
        tindaluu=findViewById(R.id.recytindaluu);
        tindathich=findViewById(R.id.recytindathich);

        dshis=findViewById(R.id.dshis);
        dsdown=findViewById(R.id.dsdown);
        dssave=findViewById(R.id.dssave);
        dsfav=findViewById(R.id.dsfav);

        dsdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(canhan.this, com.example.ttvnpt.tindatai.class);
                intent.putExtra("kieu","Tin đã tải");
                startActivity(intent);

            }
        });
        dshis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(canhan.this, com.example.ttvnpt.tindatai.class);
                intent.putExtra("kieu","Tin đã xem");
                startActivity(intent);

            }
        });
        dssave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(canhan.this, com.example.ttvnpt.tindatai.class);
                intent.putExtra("kieu","Tin đã lưu");
                startActivity(intent);

            }
        });
        dsfav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(canhan.this, com.example.ttvnpt.tindatai.class);
                intent.putExtra("kieu","Tin đã thích");
                startActivity(intent);

            }
        });




        img=findViewById(R.id.imgsetting);

        toolbar=findViewById(R.id.toolbarCanhan);
        ActionToolbar();



        layoutManager=new LinearLayoutManager(getApplicationContext());
        xemganday.setLayoutManager(layoutManager);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),caidat.class);
                startActivity(intent);
            }
        });


        //tin da xem gan day
        ArrayList<HistoryModel>historyModels= (ArrayList<HistoryModel>) DatabaseNews.getInstance(this).daoNews().getListHistory();
        if(historyModels.size()>0){
            Collections.reverse(historyModels);
            historyAdapter=new historyAdapter(getApplicationContext(),historyModels);
            xemganday.setHasFixedSize(true);
            xemganday.setAdapter(historyAdapter);
            historyAdapter.notifyDataSetChanged();
        }

        //tin da tai
            layoutManager1=new LinearLayoutManager(getApplicationContext());
            tindatai.setLayoutManager(layoutManager1);
            ArrayList<DownloadModel> downloadModels = (ArrayList<DownloadModel>) DatabaseNews.getInstance(this).daoNews().getListDownload();
            if(downloadModels.size()>0) {
                Collections.reverse(downloadModels);
            downloadAdapter = new downloadAdapter(getApplicationContext(), downloadModels);
            tindatai.setHasFixedSize(true);
            tindatai.setAdapter(downloadAdapter);
            downloadAdapter.notifyDataSetChanged();
        }

        //tin da thich
        layoutManager2=new LinearLayoutManager(getApplicationContext());
        tindathich.setLayoutManager(layoutManager2);
        ArrayList<FavoritesModel>favoritesModels= (ArrayList<FavoritesModel>) DatabaseNews.getInstance(this).daoNews().getListFavorite();
            if(favoritesModels.size()>0) {
                Collections.reverse(favoritesModels);
                favoriteAdapter = new favoriteAdapter(getApplicationContext(), favoritesModels);
                tindathich.setAdapter(favoriteAdapter);
                tindathich.setHasFixedSize(true);
                favoriteAdapter.notifyDataSetChanged();
            }
        //tin da luu
        layoutManager3=new LinearLayoutManager(getApplicationContext());
        tindaluu.setLayoutManager(layoutManager3);
        ArrayList<SaveModel>saveModels= (ArrayList<SaveModel>) DatabaseNews.getInstance(this).daoNews().getListSave();
            if(saveModels.size()>0) {
                Collections.reverse(saveModels);
                saveAdapter = new saveAdapter(getApplicationContext(), saveModels);
                tindaluu.setHasFixedSize(true);
                tindaluu.setAdapter(saveAdapter);
                saveAdapter.notifyDataSetChanged();
            }





       // adapter=new dstimkiemAdapter(getApplicationContext(),historyModels.get())

    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(canhan.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}