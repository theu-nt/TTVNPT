package adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.DataSource;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.bumptech.glide.load.engine.GlideException;
//import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
//import com.bumptech.glide.request.RequestListener;
//import com.bumptech.glide.request.RequestOptions;
//import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.ttvnpt.MainActivity;
import com.example.ttvnpt.R;
import com.example.ttvnpt.chitietTin;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import DAO.DatabaseNews;
import model.Article;
import model.HistoryModel;
import model.NewsModel;
import model.Utils;
import model.item;
import model.website;
public class customadapter extends RecyclerView.Adapter<customadapter.ItemHoler> {
    Context context;
    ArrayList<item> items;
    ArrayList<Article>articles=new ArrayList<>();

    public customadapter(Context context, ArrayList<item> item) {
        this.context = context;
        this.items =item;

    }

    @NonNull
    @Override
    public ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dstimkiem_adapter, null);
        ItemHoler itemHodel = new ItemHoler(v);

        return itemHodel;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHoler holder, int position) {
        item model = items.get(position);
//        RequestOptions requestOptions = new RequestOptions();
//        requestOptions.placeholder(Utils.getRandomDrawbleColor());
//        requestOptions.error(Utils.getRandomDrawbleColor());
//        requestOptions.diskCacheStrategy(DiskCacheStrategy.ALL);
//        requestOptions.centerCrop();
//
//        Glide.with(context)
//                .load(model.getThumbnail())
//                .apply(requestOptions)
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        return false;
//                    }
//                }).transition(DrawableTransitionOptions.withCrossFade()).into(holder.img);
        if(!model.getThumbnail().isEmpty()){
            Picasso.get().load(model.getThumbnail()).into(holder.img);
        }
//
        holder.tieude.setText(model.getTitle());
        holder.tgian.setText(Utils.DateFormat(model.getPubDate()));
        holder.tenbao.setText("vn express");
      //  holder.socmt.setText(" \u2022" + Utils.DateToTimeFormat(model.getPublishedAt()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemHoler extends RecyclerView.ViewHolder {
        //public TextView tvdm;
        ImageView img;
        TextView tenbao, tgian, tieude, socmt;

        public ItemHoler(@NonNull View itemView) {
            super(itemView);
            //anh xa
            /////////////////
//            for(item a:items){
//                Article article=new Article("",a.getTitle(),a.getDescription(),a.getLink(),a.getThumbnail(),a.getPubDate(),a.getContent());
//                articles.add(article);
//            }
            tgian = itemView.findViewById(R.id.tvtgiandstk);
            tieude = itemView.findViewById(R.id.tvtieudedstk);
            tenbao = itemView.findViewById(R.id.tvtenbaodstk);
            img = itemView.findViewById(R.id.imgdstk);
            socmt = itemView.findViewById(R.id.socmt);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int i=0;i<items.size();i++){
                        Article article=new Article("",items.get(i).getTitle(),items.get(i).getDescription(),items.get(i).getLink(),items.get(i).getThumbnail(),items.get(i).getPubDate(),items.get(i).getContent());
                        articles.add(article);
                    }
                    Intent intent=new Intent(context, chitietTin.class);
                    intent.putExtra("thongtintin",articles.get(getAdapterPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);

                    HistoryModel historyModel=new HistoryModel(articles.get(getAdapterPosition()).getUrl(),articles.get(getAdapterPosition()),Utils.currentDate());
                    DatabaseNews.getInstance(context).daoNews().deletelsxem(Utils.currentDate(),articles.get(getAdapterPosition()).getUrl());

                    // Toast.makeText(context,historyModel.getTimeHistory()+"",Toast.LENGTH_LONG).show();
                    DatabaseNews.getInstance(context).daoNews().insertHistory(historyModel);
//                     Toast.makeText(context, "hahahahehehe", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(context, chitietTin.class);
//                    intent.putExtra("thongtinsanpham",articles.get(getAdapterPosition()));
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//
//                    HistoryModel historyModel=new HistoryModel(articles.get(getAdapterPosition()).getUrl(),articles.get(getAdapterPosition()),Utils.currentDate());
//                    DatabaseNews.getInstance(context).daoNews().deletelsxem(Utils.currentDate(),articles.get(getAdapterPosition()).getUrl());
//
//                    //Toast.makeText(context,historyModel.getTimeHistory()+"",Toast.LENGTH_LONG).show();
//                    DatabaseNews.getInstance(context).daoNews().insertHistory(historyModel);
                }
            });

        }
    }
}


//public class customadapter extends RecyclerView.Adapter<customadapter.MyViewHolder> {
//    //private List<Article> articles;
//    private List<item> item;
//    private Context context;
//    private onItemClickListener onItemClickListener;
//
//    public customadapter(List<item> articles, Context context) {
//        this.item = articles;
//        this.context = context;
//    }
//
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(context).inflate(R.layout.dstimkiem_adapter, parent, false);
//        return new MyViewHolder(view, onItemClickListener);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holders, int position) {
//        final MyViewHolder holder = holders;
//        item model = item.get(position);
//
////        Picasso.get().load(model.getThumbnail()).into(holder.img);
//        holder.tieude.setText(model.getTitle());
//        holder.tgian.setText(Utils.DateFormat(model.getPubDate()));
//        holder.tenbao.setText("vn express");
//        //holder.socmt.setText(" \u2022"+Utils.DateToTimeFormat(model.getPublishedAt()));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return item.size();
//    }
//
//    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
//        this.onItemClickListener = onItemClickListener;
//    }
//
//    public interface onItemClickListener {
//        void onItemClick(View view, int positon);
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        ImageView img;
//        TextView tenbao, tgian, tieude;//, socmt;
//        onItemClickListener onItemClickListener;
//
//        public MyViewHolder(@NonNull View itemView, onItemClickListener onItemClickListener) {
//            super(itemView);
//            itemView.setOnClickListener(this);
//
//            tgian = itemView.findViewById(R.id.tvtgiandstk);
//            tieude = itemView.findViewById(R.id.tvtieudedstk);
//            tenbao = itemView.findViewById(R.id.tvtenbaodstk);
//          //  img = itemView.findViewById(R.id.imgdstk);
//           // socmt = itemView.findViewById(R.id.socmt);
//            this.onItemClickListener = onItemClickListener;
//            //TextView t1=view.findViewById(R.id.tvtgiandstk);
//            //   Picasso.get().load(p.hinhanh).into(img);
//
//        }
//
//        @Override
//        public void onClick(View v) {
//             onItemClickListener.onItemClick(v, getAdapterPosition());
//            Toast.makeText(context,"hahaha",Toast.LENGTH_LONG).show();
//
//        }
//    }
//}

//public class customadapter extends ArrayAdapter<Article> {
//
//    Context context;
//    ArrayList<Article> articles;
//    public customadapter(Context context,int c,ArrayList<Article>articles){
//        this.context=context;
//        this.articles=articles;
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        View view = convertView;
//        if (view == null) {
//            LayoutInflater inflater = LayoutInflater.from(getContext());
//            view =  inflater.inflate(R.layout.dstimkiem_adapter, null);
//        }
//        website p = getItem(position);
//        if (p != null) {
//            // Anh xa + Gan gia tri
//            //TextView txt = (TextView) view.findViewById(R.id.tvmota);
//            TextView t1=view.findViewById(R.id.tvtgiandstk);
//            TextView t2=view.findViewById(R.id.tvtieudedstk);
//            TextView t3=view.findViewById(R.id.tvtenbaodstk);
//            //TextView t1=view.findViewById(R.id.tvtgiandstk);
//            t1.setText(p.pdate);
//
//
//            ImageView img=view.findViewById(R.id.imgdstk);
//            t2.setText(p.title);
//            t3.setText(p.chanel);
//
//            Picasso.get().load(p.hinhanh).into(img);
//
//
//
//
//
//
//        }
//        return view;
//    }

//}
