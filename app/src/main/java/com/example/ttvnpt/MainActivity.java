package com.example.ttvnpt;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import DAO.DatabaseNews;
import adapter.customadapter;
import adapter.testAdapter;
import api.ApiClient;
import api.ApiInterface;
import model.Article;
import model.News;
import model.NewsModel;
import model.Utils;
import model.item;
import model.website;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button b1, dm,b2;
    ImageView img;
    TextView tv, tv1;
    ListView lv;
    ArrayList<website> arrayList;
    customadapter customadapter;
    //public static final String apiKey ="3d30621d12254ce5864d0bad40094a88";
//private RecyclerView recyclerView;
RecyclerView recyclerView;
  private RecyclerView recy;
    private RecyclerView.LayoutManager layoutManager;
   // private ArrayList<Article> arciles = new ArrayList<>();
    private ArrayList<model.item> item = new ArrayList<>();

    private customadapter adapter;
    private String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recy);
        recy = findViewById(R.id.recy);
        b1=findViewById(R.id.bttk);
        b2=findViewById(R.id.canhan);

//        layoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);

//        ArrayList<String>arr=new ArrayList<>();
//        arr.add("Covid");
//        arr.add("aadff");
//        arr.add("ha noi");
//        arr.add("BTS");
//        arr.add("Jin");
//        arr.add("RM");
//        arr.add("Suga");
//        arr.add("Jhope");
//        arr.add("Jimin");
//        arr.add("Taehyung");
//        arr.add("JK");
//        arr.add("Covid");

//        Calendar calendar=Calendar.getInstance();
//        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy", Locale.CHINA);
//        String currentDate=dateFormat.format(calendar.getTime());
//        //Toast.makeText(getApplicationContext(),currentDate,Toast.LENGTH_LONG).show();
//
//        calendar.setTime(Calendar.getInstance().getTime());
//        calendar.add(Calendar.DAY_OF_MONTH,-1);
//        String yesterday=dateFormat.format(calendar.getTime());


//        ArrayList<String> a= (ArrayList<String>) DatabaseNews.getInstance(getApplicationContext()).daoNews().getTimeDown();
//        for(int i=0;i<a.size();i++){
//            Toast.makeText(getApplicationContext(),"Thoi gian da xem"+a.get(i),Toast.LENGTH_LONG).show();
//        }
       //





//        testAdapter testAdapter=new testAdapter(getApplicationContext(),arr);
//        //recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
//
//        recyclerView.setAdapter(testAdapter);
//        testAdapter.notifyDataSetChanged();


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,timkiem.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,canhan.class);
                startActivity(intent);
            }
        });

//        layoutManager = new LinearLayoutManager(getApplicationContext());
//        recy.setLayoutManager(layoutManager);
//        LoadJson();

    }

    public void LoadJson() {
//        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
//        //Call<News> call;
//        Call<NewsModel> call;
//       // final String ct = Utils.getCountry();
//        call=apiInterface.getNewByUrl("https://vnexpress.net/rss/tin-moi-nhat.rss");
//       // call = apiInterface.getNews("us","business", apiKey);
//        call.enqueue(new Callback<NewsModel>() {
//                         @Override
//                         public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
//                             if (response.isSuccessful() && response.body().getItems() != null) {
////                    if(!item.isEmpty()){
////                        item.clear();
////                    }
//                                 item = (ArrayList<model.item>) response.body().getItems();
//                                 adapter = new customadapter(getApplicationContext(), item);
//                                 recy.setHasFixedSize(true);
//                                 recy.setAdapter(adapter);
//                                 adapter.notifyDataSetChanged();
//
//                             } else {
//                                 Toast.makeText(MainActivity.this, "No result", Toast.LENGTH_LONG).show();
//                             }
//                         }
//
//                         @Override
//                         public void onFailure(Call<NewsModel> call, Throwable t) {
//
//                         }
//                     });
    }
}

   //\\\\==============\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\/////////////////////////////// =========================================================
//            @Override
//            public void onResponse(Call<News> call, Response<News> response) {
//                if (response.isSuccessful() && response.body().getArticles()!= null) {
//                    if (!item.isEmpty()) {
//                       item.clear();
//                    }
//                    arciles = (ArrayList<Article>) response.body().getArticles();
//                    adapter = new customadapter(arciles,getApplicationContext());
//                    // recy.setHasFixedSize(true);
//                    // recy.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
//
//                    recy.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
//
//                    //}
////                else{
////            Toast.makeText(MainActivity.this,"No result",Toast.LENGTH_LONG).show();
////                }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<News> call, Throwable t) {
//
//            }
//        });
//    }
//}


     //   lv=findViewById(R.id.lv);
//        img=findViewById(R.id.img);
//
      //  arrayList=new ArrayList<website>();

     //   b1 = findViewById(R.id.bt);
//        tv = findViewById(R.id.tv);
//        tv1 = findViewById(R.id.tvtinh);
//        dm = findViewById(R.id.danhmuc);
//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//           //     Toast.makeText(MainActivity.this, "hahaha", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(MainActivity.this,timkiem.class);
//                startActivity(intent);
//            }
//        });
//        tv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, timkiem.class);
//                startActivity(intent);
//            }
//        });
//
//        dm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, danhmuc.class);
//                startActivity(intent);
//            }
//        });
//        runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                new readData().execute("https://vnexpress.net/rss/kinh-doanh.rss");
//            }
//        });
//    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
//            intent.putExtra("link",arrayList.get(position).link);
//            startActivity(intent);
//        }
//    });
//    }
//        class readData extends AsyncTask<String, Integer, String> {
//
//            @Override
//            protected String doInBackground(String... strings) {
//                return docNoiDung_Tu_URL(strings[0]);
//            }
//
//            @Override
//            protected void onPostExecute(String s) {
//                super.onPostExecute(s);
//                XMLDOMParser parser=new XMLDOMParser();
//                Document document=parser.getDocument(s);
//                NodeList nodeList=document.getElementsByTagName("item");
//                //Node node=document.getElementsByTagName("chanel");
//                NodeList nodeListDescription=document.getElementsByTagName("description");
//                String title="",link="",hinhanh="",description="",pdate="",chanel="vnexpress";
//
//                for(int i=0;i<nodeList.getLength();i++){
//
//                    String cData=nodeListDescription.item(i+1).getTextContent();
//                    Pattern p=Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
//                    Matcher matcher=p.matcher(cData);
//                    if(matcher.find()){
//                        hinhanh=matcher.group(1);
//
//                    }
//                    Element element=(Element) nodeList.item(i);
//                  //  Element el=(Element) node;//.item(0);//.item(0);
//
//
//                    title=parser.getValue(element,"title");
//                    link=parser.getValue(element,"link");
//                    description=parser.getValue(element,"description");
//                    pdate=parser.getValue(element,"pubDate");
//                   // chanel=parser.getValue(el,"generator");
//
//                    arrayList.add(new website(title,link,hinhanh,pdate,description,chanel));
//
////                    Log.d("link",link);
////                    Toast.makeText(MainActivity.this,title,Toast.LENGTH_LONG).show();
//
//                }
//                customadapter=new customadapter(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
//                lv.setAdapter(customadapter);
//
//        //        Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
//            }
//        }
//
//        ///////////////////////////////////////////////////
//        private String docNoiDung_Tu_URL(String theUrl){
//            StringBuilder content = new StringBuilder();
//            try    {
//                // create a url object
//                URL url = new URL(theUrl);
//
//                // create a urlconnection object
//                URLConnection urlConnection = url.openConnection();
//
//                // wrap the urlconnection in a bufferedreader
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//                String line;
//
//                // read from the urlconnection via the bufferedreader
//                while ((line = bufferedReader.readLine()) != null){
//                    content.append(line + "\n");
//                }
//                bufferedReader.close();
//            }
//            catch(Exception e)    {
//                e.printStackTrace();
//            }
//            return content.toString();

