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
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttvnpt.R;
import com.example.ttvnpt.chitietTin;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.Article;
import model.HistoryModel;
import model.Utils;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.ItemHoler> {
    Context context;
    ArrayList<HistoryModel>historyModels;

    public historyAdapter(Context context, ArrayList<HistoryModel> historyModels) {
        this.context = context;
        this.historyModels = historyModels;
    }

    @NonNull
    @Override
    public historyAdapter.ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.dstimkiem_adapter,null);
        ItemHoler itemHoler=new ItemHoler(v);
        return itemHoler;
    }

    @Override
    public void onBindViewHolder(@NonNull historyAdapter.ItemHoler holder, int position) {
        Article model=historyModels.get(position).getArticleHistory();
        Picasso.get().load(model.getUrlToImage()).into(holder.img);
        holder.tieude.setText(model.getTitle());
        holder.tgian.setText(Utils.DateFormat(model.getPublishedAt()));
        holder.tenbao.setText("vnexpress");
    }

    @Override
    public int getItemCount() {
        return historyModels.size();
    }
    public class ItemHoler extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tenbao, tgian, tieude, socmt;
        public ItemHoler(@NonNull View itemView) {
            super(itemView);
            tgian = itemView.findViewById(R.id.tvtgiandstk);
            tieude = itemView.findViewById(R.id.tvtieudedstk);
            tenbao = itemView.findViewById(R.id.tvtenbaodstk);
            img = itemView.findViewById(R.id.imgdstk);
            socmt = itemView.findViewById(R.id.socmt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "hahahahehehe", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context, chitietTin.class);
                    intent.putExtra("thongtintin",historyModels.get(getAdapterPosition()).getArticleHistory());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }
    }
}
