package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import DAO.DatabaseNews;
import adapter.danhmuc_adapter;
import adapter.suaDanhMucAdapter;
import model.cataModel;

public class  danhmuc extends AppCompatActivity {
    RecyclerView recy,recyclerViewThayDoiCM;
    RecyclerView.LayoutManager layoutManager,layoutManager1;
    TextView TVthaydoiCM,TVthemCM;
    Toolbar toolbar;
    ArrayList<cataModel> arr=new ArrayList<>();
    danhmuc_adapter adapter;
    int size;
    suaDanhMucAdapter suaDanhMucAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhmuc);

        TVthaydoiCM=findViewById(R.id.TVthaydoichuyenmuc);
        TVthemCM=findViewById(R.id.TVthemchuyenmuc);
        recy=findViewById(R.id.rcvdanhmuc);
        recyclerViewThayDoiCM=findViewById(R.id.recyThaydoiCM);
        toolbar=findViewById(R.id.toolbarchuyenmuc);

        ActionToolbar();

        layoutManager=new LinearLayoutManager(getApplicationContext());
        recy.setLayoutManager(layoutManager);


        arr= (ArrayList<cataModel>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getListDM();
        size=arr.size();
        if(arr.size()>0) {
            adapter = new danhmuc_adapter(getApplicationContext(), arr);
            recy.setHasFixedSize(true);
            recy.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
            recy.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }

        layoutManager1=new LinearLayoutManager(getApplicationContext());
        recyclerViewThayDoiCM.setLayoutManager(layoutManager1);

        suaDanhMucAdapter=new suaDanhMucAdapter(getApplicationContext(),arr);
      //  suaDanhMucAdapter.notifyDataSetChanged();

        //if (TVthaydoiCM.getText().toString().equals("Thay đổi")) {
           TVthaydoiCM.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(getApplicationContext(),TVthaydoiCM.getText().toString(),Toast.LENGTH_SHORT).show();

                   if (TVthaydoiCM.getText().toString().equals("Thay đổi")){
                       TVthaydoiCM.setText("Xong");
                       recy.setVisibility(View.INVISIBLE);
                       recyclerViewThayDoiCM.setVisibility(View.VISIBLE);
                       recyclerViewThayDoiCM.setHasFixedSize(true);
                       recyclerViewThayDoiCM.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                       recyclerViewThayDoiCM.setAdapter(suaDanhMucAdapter);
                       return;
                   }
                   if (TVthaydoiCM.getText().toString().equals("Xong")) {
                       setData();
                       TVthaydoiCM.setText("Thay đổi");
                       recyclerViewThayDoiCM.setVisibility(View.INVISIBLE);
                       recy.setVisibility(View.VISIBLE);
                       adapter = new danhmuc_adapter(getApplicationContext(), arr);
                       recy.setHasFixedSize(true);
                       recy.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                       recy.setAdapter(adapter);
                       return;
                   }
               }
               });

        TVthemCM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(danhmuc.this,themchuyenmuc.class);
               // intent.putExtra("dschuyenmuc",arr);
                startActivity(intent);
            }
        });



    }

    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(danhmuc.this,caidat.class);
                startActivity(intent);
            }
        });
    }
    public void setData(){
         arr= (ArrayList<cataModel>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getListDM();

    }
}