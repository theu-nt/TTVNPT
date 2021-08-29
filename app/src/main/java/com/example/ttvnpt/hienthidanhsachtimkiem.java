 package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import adapter.customadapter;
import adapter.dstimkiemAdapter;
import model.Article;
import model.website;

 public class hienthidanhsachtimkiem extends AppCompatActivity {
Spinner sp;
adapter.dstimkiemAdapter adapter;
RecyclerView recy;
TextView edsearch;
Toolbar toolbar;
     private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hienthidanhsachtimkiem);
        sp=findViewById(R.id.spdstk);
        edsearch=findViewById(R.id.tvkqtk);
        recy=findViewById(R.id.recydstk);
        toolbar=findViewById(R.id.toolbarht);

        ActionToolbar();

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recy.setLayoutManager(layoutManager);

        Intent intent=getIntent();
        String kw=intent.getStringExtra("keysearch");//.getString("keysearch");
        edsearch.setHint(kw);
        ArrayList<Article> articles= (ArrayList<Article>) intent.getSerializableExtra("list");
           // adapter=new dstimkiemAdapter(getApplicationContext(),articles);
          Toast.makeText(getApplicationContext(),articles.get(0).getPublishedAt().toString()+"",Toast.LENGTH_LONG).show();

//          recy.setHasFixedSize(true);
//            recy.setAdapter(adapter);
//            adapter.notifyDataSetChanged();


        String[]data={"Năm nay","2020","2019","2018"};
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,data);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.sp.setAdapter(arrayAdapter);

       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
     @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ArrayList<Article> temp = new ArrayList<>();
                String nam="";
                if(sp.getSelectedItem().toString().equals("Năm nay")){
                    nam="2021";
                }
                else nam=sp.getSelectedItem().toString();
                for (Article a : articles) {
                    String y = "";
                    for (int i = 0; i < 4; i++) {
                        y += String.valueOf(articles.get(0).getPublishedAt().toString().charAt(i));
                    }
                    if (y.equals(nam)) {
                        temp.add(a);

                    }
                }
                    adapter=new dstimkiemAdapter(getApplicationContext(),temp);

                    recy.setHasFixedSize(true);
                    recy.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                     RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
                     recy.addItemDecoration(itemDecoration);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                    Toast.makeText(getApplicationContext(),"hhhh",Toast.LENGTH_LONG).show();
            }
        } );


    }
     private void ActionToolbar() {
         setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayHomeAsUpEnabled(true);
         toolbar.setNavigationOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
                 Intent intent=new Intent(hienthidanhsachtimkiem.this,timkiem.class);
                 startActivity(intent);
             }
         });
     }
}