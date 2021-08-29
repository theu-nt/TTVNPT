package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttvnpt.R;
import com.example.ttvnpt.chitietTin;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;

import DAO.DatabaseNews;
import model.Article;
import model.DownloadModel;
import model.FavoritesModel;
import model.HistoryModel;
import model.SaveModel;
import model.Utils;

public class dsTinAdapter extends RecyclerView.Adapter<dsTinAdapter.ItemHoler> {
        Context context;
        ArrayList<String> dsNgay;
        String kieu;

        downloadAdapter downloadAdapter;
        RecyclerView.LayoutManager layoutManager;

        historyAdapter historyAdapter;
        saveAdapter saveAdapter;
        favoriteAdapter favoriteAdapter;



        // ArrayList<DownloadModel> downloadModels;
       // ArrayList<DownloadModel> downloadModels;
        //downloadAdapter downloadAdapter;
public dsTinAdapter(Context context, ArrayList<String> dsNgay,String kieu) {
        this.context = context;
        this.dsNgay = dsNgay;
        this.kieu=kieu;
        }

@NonNull
@Override
public dsTinAdapter.ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.dstin_adapter,null);
        ItemHoler itemHoler=new ItemHoler(v);
        return itemHoler;
        }

@Override
public void onBindViewHolder(@NonNull dsTinAdapter.ItemHoler holder, int position) {

    String d = dsNgay.get(position);
    if (d.equals(Utils.currentDate())) {
        holder.tvngaydsTin.setText("Hôm nay");
    } else {
        if (d.equals(Utils.Yesterday())) {
            holder.tvngaydsTin.setText("Hôm qua");
        } else holder.tvngaydsTin.setText(d);
    }
    if (kieu.equals("Tin đã tải")) {
        ArrayList<DownloadModel> downloadModels = (ArrayList<DownloadModel>) DatabaseNews.getInstance(context).daoNews().getListDownloadTime(d);
        Collections.reverse(downloadModels);
        layoutManager = new LinearLayoutManager(context);
        holder.recydstin.setLayoutManager(layoutManager);
        downloadAdapter = new downloadAdapter(context, downloadModels);
        holder.recydstin.setAdapter(downloadAdapter);

        holder.xoaToanbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseNews.getInstance(context).daoNews().deleteAllDown(d);
                holder.recydstin.setVisibility(View.INVISIBLE);
//                ArrayList<DownloadModel> downloadModels = new ArrayList<>();
//
//                layoutManager = new LinearLayoutManager(context);
//                holder.recydstin.setLayoutManager(layoutManager);
//
//
//                downloadAdapter = new downloadAdapter(context, downloadModels);
//                holder.recydstin.setAdapter(downloadAdapter);
            }
        });
    }

///////////////////////////
    if (kieu.equals("Tin đã xem")) {
        ArrayList<HistoryModel> historyModels = (ArrayList<HistoryModel>) DatabaseNews.getInstance(context).daoNews().getListHistoryTime(d);
        Collections.reverse(historyModels);
        layoutManager = new LinearLayoutManager(context);
        holder.recydstin.setLayoutManager(layoutManager);


        historyAdapter= new historyAdapter(context, historyModels);
        holder.recydstin.setAdapter(historyAdapter);

        holder.xoaToanbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseNews.getInstance(context).daoNews().deleteAllHis(d);
                holder.recydstin.setVisibility(View.INVISIBLE);
//                ArrayList<HistoryModel> hisModels = new ArrayList<>();
//
//                layoutManager = new LinearLayoutManager(context);
//                holder.recydstin.setLayoutManager(layoutManager);
//
//
//                historyAdapter = new historyAdapter(context, hisModels);
//                holder.recydstin.setAdapter(historyAdapter);
            }
        });

    }

    /////////////////
    if(kieu.equals("Tin đã lưu")) {
        ArrayList<SaveModel> saveModels = (ArrayList<SaveModel>) DatabaseNews.getInstance(context).daoNews().getListSaveTime(d);
        Collections.reverse(saveModels);
        layoutManager = new LinearLayoutManager(context);
        holder.recydstin.setLayoutManager(layoutManager);


        saveAdapter = new saveAdapter(context, saveModels);
        holder.recydstin.setAdapter(saveAdapter);

        holder.xoaToanbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseNews.getInstance(context).daoNews().deleteAllSave(d);

                holder.recydstin.setVisibility(View.INVISIBLE);
//                ArrayList<SaveModel> saveModels1 = new ArrayList<>();
//
//                layoutManager = new LinearLayoutManager(context);
//                holder.recydstin.setLayoutManager(layoutManager);
//
//
//                saveAdapter = new saveAdapter(context, saveModels1);
//                holder.recydstin.setAdapter(saveAdapter);
            }
        });
    }

    ////////////////////////////
    if(kieu.equals("Tin đã thích")) {
        ArrayList<FavoritesModel> FavoritesModels = (ArrayList<FavoritesModel>) DatabaseNews.getInstance(context).daoNews().getListFavoriteTime(d);
        Collections.reverse(FavoritesModels);
        layoutManager = new LinearLayoutManager(context);
        holder.recydstin.setLayoutManager(layoutManager);


        favoriteAdapter = new favoriteAdapter(context, FavoritesModels);
        holder.recydstin.setAdapter(favoriteAdapter);

        holder.xoaToanbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseNews.getInstance(context).daoNews().deleteAllFav(d);
                holder.recydstin.setVisibility(View.INVISIBLE);
//                ArrayList<FavoritesModel> FavoritesModels = new ArrayList<>();
//
//                layoutManager = new LinearLayoutManager(context);
//                holder.recydstin.setLayoutManager(layoutManager);
//
//
//                favoriteAdapter = new favoriteAdapter(context, FavoritesModels);
//                holder.recydstin.setAdapter(favoriteAdapter);
            }
        });
    }
}

@Override
public int getItemCount() {
        return dsNgay.size();
        }
public class ItemHoler extends RecyclerView.ViewHolder{
    TextView tvngaydsTin,xoaToanbo;
    RecyclerView recydstin;

    public ItemHoler(@NonNull View itemView) {
        super(itemView);

        recydstin=itemView.findViewById(R.id.recyDsTin);
        tvngaydsTin=itemView.findViewById(R.id.ngayDSTin);
        xoaToanbo=itemView.findViewById(R.id.XoaToanBoDsTin);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "hahahahehehe", Toast.LENGTH_SHORT).show();
//                Intent intent=new Intent(context, chitietTin.class);
//                intent.putExtra("thongtintin",downloadModels.get(getAdapterPosition()).getArticleDownload());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        });

    }
}
}
