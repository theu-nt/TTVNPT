package com.example.ttvnpt;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

import adapter.IClickListener;
import adapter.tinhAdapter;

import static android.content.Context.MODE_PRIVATE;

public class chonDPBottomSheet extends BottomSheetDialogFragment {
    ArrayList<String> arrayList;
    IClickListener iClickListener;
   // String data="";
    tinhAdapter tinhAdapter;

    public chonDPBottomSheet(ArrayList<String> arrayList, IClickListener iClickListener) {

        this.arrayList = arrayList;
        this.iClickListener = iClickListener;
    }
//    public void setData(String data1){
//        data=data1;
//
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        BottomSheetDialog bottomSheetDialog= (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view= LayoutInflater.from(getContext()).inflate(R.layout.chondiaphuong_fragment,null);
        bottomSheetDialog.setContentView(view);

        RecyclerView recyclerView=view.findViewById(R.id.recytindiap);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

//        SharedPreferences sharedPreferences=getSharedPreferences("tindp",MODE_PRIVATE);
//        String dp=sharedPreferences.getString("diaphuongchon","");
//        if(!data.equals("")) {
//            tinhAdapter.setCheck(data);
//        }
        tinhAdapter=new tinhAdapter(arrayList, new IClickListener() {
            @Override
            public void clickIem(String string) {

                iClickListener.clickIem(string);
            }
        });
        recyclerView.setAdapter(tinhAdapter);
        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        return bottomSheetDialog;
    }
}

