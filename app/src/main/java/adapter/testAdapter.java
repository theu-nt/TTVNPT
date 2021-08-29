package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttvnpt.R;
import com.example.ttvnpt.hienthidanhsachtimkiem;
import com.example.ttvnpt.timkiem;

import java.util.ArrayList;
import java.util.Date;

import DAO.DatabaseNews;
import api.ApiClient;
import api.ApiInterface;
import model.Article;
import model.KeySearch;
import model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class testAdapter extends RecyclerView.Adapter<testAdapter.ItemHoler> {
    public static final String apiKey ="3d30621d12254ce5864d0bad40094a88";
    Context context;
    ArrayList<String> search;
public testAdapter(Context context,ArrayList<String>search){
        this.context=context;
        this.search=search;

        }
@NonNull
@Override
public ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.test_fragment,null);
        ItemHoler itemHodel=new ItemHoler(v);
        return itemHodel;

        }

@Override
public void onBindViewHolder(@NonNull ItemHoler holder, int position) {
//        holder.tvdm.setBackground();
        holder.tvs.setText(search.get(position).toString());
        }

@Override
public int getItemCount() {
        return search.size();
        }

public class ItemHoler extends RecyclerView.ViewHolder {
    public TextView tvs;

    public ItemHoler(@NonNull View itemView) {
        super(itemView);
        //anh xa
        tvs = itemView.findViewById(R.id.tvsear);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, tvs.getText().toString(), Toast.LENGTH_SHORT).show();
                LoadJson(search.get(getAdapterPosition()));

                KeySearch keySearch = new KeySearch(search.get(getAdapterPosition()), new Date().getTime());

//                ArrayList<KeySearch> dsSearch= (ArrayList<KeySearch>) DatabaseNews.getInstance(context).daoNews().checkKeySearch(search.get(getAdapterPosition()));
//                if (dsSearch.size()>0){
//                    for(KeySearch k:dsSearch) {
//                        DatabaseNews.getInstance(context).daoNews().deleteKeySearch(k);
//                    }
//                }

                DatabaseNews.getInstance(context).daoNews().deleteKeySearch(search.get(getAdapterPosition()));

                DatabaseNews.getInstance(context).daoNews().insertKeySearch(keySearch);

            }
        });

    }
}
    public void LoadJson(String keyword) {
        ApiInterface apiInterface = ApiClient.getInstance().getClient2().create(ApiInterface.class);
        Call<News> call;

        call=apiInterface.getNews(keyword,"vi","vnexpress.net",apiKey);
        // call = apiInterface.getNews("us","business", apiKey);
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if(response.isSuccessful()&&response.body().getArticles()!=null){
                    ArrayList<Article> arciles= (ArrayList<Article>) response.body().getArticles();
                    Intent intent = new Intent(context, hienthidanhsachtimkiem.class);// intent.putExtra("keysearch",keyword);
                    intent.putExtra("keysearch", keyword);
                    intent.putExtra("list", arciles);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);


                }
                else{
                    Toast.makeText(context,"No result",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });

    }

}


