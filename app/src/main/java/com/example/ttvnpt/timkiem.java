 package com.example.ttvnpt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

import DAO.DatabaseNews;
import adapter.testAdapter;
import api.ApiClient;
import api.ApiInterface;
import model.Article;
import model.KeySearch;
import model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class timkiem extends AppCompatActivity {
    Toolbar toolbar;
    EditText ed1;
    ImageView bt;
    RecyclerView recytuhot,recytimkiemganday;

    private RecyclerView.LayoutManager layoutManager1,layoutManager2;

    public static final String apiKey ="3d30621d12254ce5864d0bad40094a88";
    private ArrayList<Article> arciles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timkiem);
        toolbar = findViewById(R.id.toolbarsearch);
        ed1 = findViewById(R.id.edtk);
        bt = findViewById(R.id.imgsearch);

        recytuhot=findViewById(R.id.recytukhoahot);
        recytimkiemganday=findViewById(R.id.recytimkiemganday);

        layoutManager1 = new LinearLayoutManager(getApplicationContext());
        recytuhot.setLayoutManager(layoutManager1);

        layoutManager2 = new LinearLayoutManager(getApplicationContext());
        recytimkiemganday.setLayoutManager(layoutManager2);

        ArrayList<String>arr=new ArrayList<>();
        arr.add("Covid");
        arr.add("Việt Nam covid");
        arr.add("Virus");
        arr.add("Prime");
        arr.add("Anthony Fauci");
        arr.add("Breakdown");
        arr.add("Wisconsin");
        arr.add("Washington");
        arr.add("Coronavirus");
        arr.add("Taehyung");
        arr.add("Nepal");
        arr.add("Animal");
        testAdapter testAdapter=new testAdapter(getApplicationContext(),arr);
        //recyclerView.setHasFixedSize(true);
        recytuhot.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        recytuhot.setAdapter(testAdapter);
        testAdapter.notifyDataSetChanged();

        ArrayList<String>arr1=new ArrayList<>();
        ArrayList<KeySearch> keySearches= (ArrayList<KeySearch>) DatabaseNews.getInstance(this).daoNews().getListKeySearch();
        if (keySearches.size()>0) {
            for (KeySearch keySearch : keySearches) {
                arr1.add(keySearch.getKey());
            }
            testAdapter testAdapter1 = new testAdapter(getApplicationContext(), arr1);
            recytimkiemganday.setAdapter(testAdapter1);
            recytimkiemganday.setHasFixedSize(true);
            recytimkiemganday.setLayoutManager(new GridLayoutManager(getApplicationContext(), 3));
            testAdapter1.notifyDataSetChanged();
        }

        ActionToolbar();

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk=ed1.getText().toString();
                LoadJson(tk);
                KeySearch keySearch=new KeySearch(ed1.getText().toString(),new Date().getTime());

                DatabaseNews.getInstance(getApplicationContext()).daoNews().deleteKeySearch(tk);

                DatabaseNews.getInstance(getApplicationContext()).daoNews().insertKeySearch(keySearch);
            }
        });


    }
    private void ActionToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(timkiem.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
    public void LoadJson(final String keyword) {
        ApiInterface apiInterface = ApiClient.getInstance().getClient2().create(ApiInterface.class);
        Call<News> call;

        call=apiInterface.getNews(keyword,"vi","vnexpress.net",apiKey);
        // call = apiInterface.getNews("us","business", apiKey);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful()&&response.body().getArticles()!=null){
                    arciles= (ArrayList<Article>) response.body().getArticles();
                    Intent intent=new Intent(timkiem.this,hienthidanhsachtimkiem.class);// intent.putExtra("keysearch",keyword);
                    intent.putExtra("keysearch",keyword);
                    intent.putExtra("list",arciles);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(timkiem.this,"No result",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }
}

