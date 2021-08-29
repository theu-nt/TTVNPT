package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import DAO.DatabaseNews;
import adapter.themCMAdapter;
import model.Utils;
import model.cataModel;

public class themchuyenmuc extends AppCompatActivity {
RecyclerView recyclerView;
RecyclerView.LayoutManager layoutManager;
Toolbar toolbar;
EditText edtimCM;
    themCMAdapter themCMAdapter;
    ArrayList<cataModel> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themchuyenmuc);

        recyclerView=findViewById(R.id.recythemCM);
        toolbar=findViewById(R.id.toolbarThemCM);
        edtimCM=findViewById(R.id.edtimchuyenmuc);

        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        ActionToolbar();

        arr=new ArrayList<>();

        arr.add(new cataModel("Xu hướng",R.drawable.danhmuc));
        arr.add(new cataModel("Xã hội",R.drawable.xahoi));
        arr.add(new cataModel("Sức Khỏe",R.drawable.sk));
        arr.add(new cataModel("Văn hóa",R.drawable.danhmuc));
        arr.add(new cataModel("Giải trí",R.drawable.xahoi));
        arr.add(new cataModel("Giáo dục",R.drawable.danhmuc));
        arr.add(new cataModel("Thể thao",R.drawable.danhmuc));
        arr.add(new cataModel("Tâm sự",R.drawable.tamsu));
        arr.add(new cataModel("Truyện đọc",R.drawable.danhmuc));
        arr.add(new cataModel("Bảng tin",R.drawable.danhmuc));
        arr.add(new cataModel("Công nghệ",R.drawable.congnghe));
        arr.add(new cataModel("Đời sống",R.drawable.doisong));


        ArrayList<cataModel> DMucChon= (ArrayList<cataModel>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getListDM();
        //Toast.makeText(getApplicationContext(),"DM chon roi "+DMucChon.size()+"",Toast.LENGTH_LONG).show();
        for(int i=0;i<arr.size();i++){
            for(int j=0;j<DMucChon.size();j++){
                if(arr.get(i).getTenDMuc().equals(DMucChon.get(j).getTenDMuc())){
                    arr.remove(arr.get(i));
                }

        }
        }
        //arr.
     //   Toast.makeText(getApplicationContext(),arr.size()+"",Toast.LENGTH_LONG).show();


        themCMAdapter=new themCMAdapter(getApplicationContext(),arr);
        recyclerView.setAdapter(themCMAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
        recyclerView.setHasFixedSize(true);
        themCMAdapter.notifyDataSetChanged();

        edtimCM.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    String keysearch=edtimCM.getText().toString();
                    for(int i=0;i<arr.size();i++){
                    if(arr.get(i).getTenDMuc().equals(keysearch)){
                        cataModel cataModel=arr.get(i);
                        arr=new ArrayList<>();
                        arr.add(cataModel);//= (ArrayList<cataModel>) DatabaseNews.getInstance(getApplicationContext()).daoNews().checkDM(keysearch);

                        themCMAdapter=new themCMAdapter(getApplicationContext(),arr);
                        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 1));
                        recyclerView.setAdapter(themCMAdapter);
                        recyclerView.setHasFixedSize(true);
                    }
                    }

                }

                return false;
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
                Intent intent=new Intent(themchuyenmuc.this,danhmuc.class);
                startActivity(intent);
            }
        });
    }
}