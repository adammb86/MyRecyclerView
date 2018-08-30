package com.example.adammb.myrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardPresidentAdapter extends RecyclerView.Adapter<CardPresidentAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<President> listPresident;

    public CardPresidentAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<President> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }

    @NonNull
    @Override
    public CardPresidentAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_president,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardPresidentAdapter.CardViewHolder holder, int position) {
        President president=getListPresident().get(position);

        Glide.with(context)
                .load(president.getPhoto())
                .override(350,350)
                .into(holder.imgPhoto);

        holder.tvName.setText(president.getName());
        holder.tvRemarks.setText(president.getRemarks());

        holder.btnFavourite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallBack() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallBack() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListPresident().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnShare,btnFavourite;

        public CardViewHolder(View viewItem){
            super(viewItem);
            imgPhoto=(ImageView)viewItem.findViewById(R.id.img_item_photo);
            tvName=(TextView)viewItem.findViewById(R.id.tv_item_name);
            tvRemarks=(TextView)viewItem.findViewById(R.id.tv_item_remarks);
            btnShare=(Button)viewItem.findViewById(R.id.btn_set_share);
            btnFavourite=(Button)viewItem.findViewById(R.id.btn_set_favorite);
        }
    }
}
