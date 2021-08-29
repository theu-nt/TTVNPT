package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

import DAO.DataLocalManager;
import adapter.IClickListener;
import adapter.dstimkiemAdapter;
import api.ApiClient;
import api.ApiInterface;
import model.Article;
import model.News;
import model.diaphuong;
import model.tinhModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class caidat extends AppCompatActivity {
TextView tvtindp,tvchuyenMuc,tvtinDPChon,tvdieukhoan;
Toolbar toolbar;
//ArrayList<String> arrayList=new ArrayList<>();



//SharedPreferences sharedPreferences;
chonDPBottomSheet chonDPBottomSheet;
ArrayList<String> arrayList1=new ArrayList<>();
ArrayList<tinhModel>tinhModels=new ArrayList<>();
    String dp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caidat);

        tvtindp=findViewById(R.id.tvtindiaphuong);
        toolbar=findViewById(R.id.toolbarcaidat);
        tvchuyenMuc=findViewById(R.id.chuyenmuc);
        tvtinDPChon=findViewById(R.id.tvdiaphuong);
        tvdieukhoan=findViewById(R.id.dieukhoan);

        if(DataLocalManager.getFirstInstall()!=null){
            dp=DataLocalManager.getFirstInstall();
            tvtinDPChon.setText(dp);

            //DataLocalManager.setFirstInstall("aa");
        }
        else{
            tvtinDPChon.setText("");
        }

        tvdieukhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(caidat.this,dieukhoan.class);
                startActivity(intent);

            }
        });

//        sharedPreferences=getSharedPreferences("tindp",MODE_PRIVATE);
//        dp=sharedPreferences.getString("diaphuongchon","");
//        tvtinDPChon.setText(dp);
//        if(!dp.equals("")) {
//            chonDPBottomSheet.setData(dp);
//        }


        tvchuyenMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(caidat.this,danhmuc.class);
                startActivity(intent);
            }
        });


//        arrayList.add("Thái Bình");
//        arrayList.add("Hà Nội");
//        arrayList.add("Hải Phòng");
//        arrayList.add("Quảng Ninh");
//        arrayList.add("Đà Nẵng");
//        arrayList.add("Bắc Giang");
//        arrayList.add("Quảng Nam");
//        arrayList.add("Bình Dương");
//        arrayList.add("Nghệ An");
//        arrayList.add("Nam Định");
//        arrayList.add("Hòa Bình");



        ActionToolbar();
        LoadJson();

        tvtindp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chonDPBottomSheet=new chonDPBottomSheet(arrayList1, new IClickListener() {
                    @Override
                    public void clickIem(String string) {
                        Toast.makeText(caidat.this,string,Toast.LENGTH_LONG).show();
                        DataLocalManager.setFirstInstall(string);
                        //SharedPreferences.Editor editor=sharedPreferences.edit();
//                        editor.putString("diaphuongchon",string);
//                        editor.commit();

                        dp=DataLocalManager.getFirstInstall();
                        tvtinDPChon.setText(dp);

                    }
                });
                chonDPBottomSheet.show(getSupportFragmentManager(),chonDPBottomSheet.getTag());

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
                Intent intent=new Intent(caidat.this,canhan.class);
                startActivity(intent);
            }
        });
    }
    public void LoadJson() {//ApiClient.getInstance().getClient();
        ApiInterface apiInterface = ApiClient.getInstance().getClient().create(ApiInterface.class);
        Call<diaphuong> call;

        call=apiInterface.getTinh();//.getNews(keyword,"vi",);
        call.enqueue(new Callback<diaphuong>() {
            @Override
            public void onResponse(Call<diaphuong> call, Response<diaphuong> response) {
                if(response.isSuccessful()&&response.body()!=null){
                    tinhModels= (ArrayList<tinhModel>) response.body().getLtsItem();
                    for(tinhModel tinhModel:tinhModels){
                        arrayList1.add(tinhModel.getTitle());

                    }
                    arrayList1.remove(arrayList1.size()-1);

                }
                else{
                    Toast.makeText(caidat.this,"No result",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<diaphuong> call, Throwable t) {

            }
        });

    }
}