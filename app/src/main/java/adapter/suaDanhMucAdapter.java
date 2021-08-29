package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ttvnpt.R;

import java.util.ArrayList;

import DAO.DatabaseNews;
import model.cataModel;

public class suaDanhMucAdapter extends RecyclerView.Adapter<suaDanhMucAdapter.ItemHoler> {
    Context context;
    ArrayList<cataModel> danhmuc;
    public suaDanhMucAdapter(Context context,ArrayList<cataModel>danhmuc){
        this.context=context;
        this.danhmuc=danhmuc;

    }
    @NonNull
    @Override
    public suaDanhMucAdapter.ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.suachuyenmuc_dapter,null);
        suaDanhMucAdapter.ItemHoler itemHodel=new suaDanhMucAdapter.ItemHoler(v);
        return itemHodel;

    }

    @Override
    public void onBindViewHolder(@NonNull suaDanhMucAdapter.ItemHoler holder, int position) {
//        holder.tvdm.setBackground();
        holder.imganh.setImageResource(danhmuc.get(position).getAnhDMuc());
        //Picasso.get().load(danhmuc.get(position).getAnhDMuc());
        holder.tvten.setText(danhmuc.get(position).getTenDMuc());
//        holder.imganh.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DatabaseNews.getInstance(context).daoNews().deleteDM(danhmuc.get(position));
//
//                Toast.makeText(context,"Đã xóa"+danhmuc.get(position).getTenDMuc(),Toast.LENGTH_SHORT).show();
//                danhmuc.remove(holder.getAdapterPosition());
  //              notifyItemRemoved(holder.get.getAdapterPosition());
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return danhmuc.size();
    }

    public class ItemHoler extends RecyclerView.ViewHolder {
        public TextView tvten;
        public ImageView imganh,imgitemsuacm;
        public ItemHoler(@NonNull View itemView) {
            super(itemView);
            //anh xa
            tvten=itemView.findViewById(R.id.tvtenscm);
            imganh=itemView.findViewById(R.id.imganhsuacm);
            imgitemsuacm=itemView.findViewById(R.id.itemsuacm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgitemsuacm.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DatabaseNews.getInstance(context).daoNews().deleteDM(danhmuc.get(getAdapterPosition()));

                            Toast.makeText(context,"Đã xóa"+danhmuc.get(getAdapterPosition()).getTenDMuc(),Toast.LENGTH_SHORT).show();
                            danhmuc.remove(danhmuc.get(getAdapterPosition()));
                            notifyItemRemoved(getAdapterPosition());

                        }
                    });
//                    Toast.makeText(context,tvdm.getText().toString(),Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(context, ChiTietSanPhamActivity.class);
//                    intent.putExtra("thongtinsanpham",arraysanpham.get(getAdapterPosition()));
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    checkconnect.showToast_Short(context,arraysanpham.get(getAdapterPosition()).getTensp());
//                    context.startActivity(intent);
                }
            });

        }
    }
}
