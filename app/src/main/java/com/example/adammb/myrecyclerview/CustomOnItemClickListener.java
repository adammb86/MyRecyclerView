package com.example.adammb.myrecyclerview;

import android.view.View;
import android.widget.AdapterView;

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallBack onItemClickCallBack;

    public CustomOnItemClickListener(int position, OnItemClickCallBack onItemClickCallBack) {
        this.position = position;
        this.onItemClickCallBack = onItemClickCallBack;
    }

    @Override
    public void onClick(View view) {
        onItemClickCallBack.onItemClicked(view,position);
    }

    interface OnItemClickCallBack{
        void onItemClicked(View view,int position);
    }
}
