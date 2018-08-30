package com.example.adammb.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridPresidentAdapter extends RecyclerView.Adapter<GridPresidentAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<President> listPresident;

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    public GridPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridPresidentAdapter.GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_president, parent,false);
        GridViewHolder gridViewHolder=new GridViewHolder(view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .override(350,350)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;

        public GridViewHolder(View itemView){
            super(itemView);
            imgPhoto=(ImageView)itemView.findViewById(R.id.img_view_photo);
        }
    }
}
