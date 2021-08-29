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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import model.cataModel;

public class danhmuc_adapter extends RecyclerView.Adapter<danhmuc_adapter.ItemHoler> {
    Context context;
    ArrayList<cataModel>danhmuc;
    public danhmuc_adapter(Context context,ArrayList<cataModel>danhmuc){
        this.context=context;
        this.danhmuc=danhmuc;

    }
    @NonNull
    @Override
    public ItemHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.danhmucadapter,null);
        ItemHoler itemHodel=new ItemHoler(v);
        return itemHodel;

    }

    @Override
    public void onBindViewHolder(@NonNull ItemHoler holder, int position) {
//        holder.tvdm.setBackground();
        holder.imgdm.setImageResource(danhmuc.get(position).getAnhDMuc());
        //Picasso.get().load(danhmuc.get(position).getAnhDMuc());
        holder.tvdm.setText(danhmuc.get(position).getTenDMuc());
    }

    @Override
    public int getItemCount() {
        return danhmuc.size();
    }

    public class ItemHoler extends RecyclerView.ViewHolder {
        public TextView tvdm;
        public ImageView imgdm;
        public ItemHoler(@NonNull View itemView) {
            super(itemView);
            //anh xa
            tvdm=itemView.findViewById(R.id.tvTendm);
            imgdm=itemView.findViewById(R.id.imAnhdm);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,tvdm.getText().toString(),Toast.LENGTH_SHORT).show();
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

