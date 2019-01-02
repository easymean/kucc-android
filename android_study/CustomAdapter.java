package com.example.easymean.android_study;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import java.text.SimpleDateFormat;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<Memo> itemList;
//    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");

    public CustomAdapter(List<Memo> itemList){
        this.itemList = itemList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent,int viewType){

        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position){
        Memo item = itemList.get(position);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.memoView.setText(item.getText());
//        holder.dateView.setText(dateFormat.format(item.getDate().getTime()));
    }

    @Override
    public int getItemCount(){
        return itemList.size();
    }

    public int increaseCount() {
        int itemCount = itemList.size();
        return itemCount++;
    }


}
