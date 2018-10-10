package com.example.shreeyanshi.authenticationexample.ViewHolder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shreeyanshi.authenticationexample.R;
import com.squareup.picasso.Picasso;

public class MenuViewHolder extends RecyclerView.ViewHolder {


    public TextView nameTextview;
    public ImageView imageTextView;
    View mView;

    public MenuViewHolder(View itemView) {
        super(itemView);
        mView = itemView;

        nameTextview = (TextView) itemView.findViewById(R.id.menu_name);
        imageTextView = (ImageView) itemView.findViewById(R.id.menu_image);

    }

    public void setMenuName(String nameView) {
        nameTextview = mView.findViewById(R.id.menu_name);
        nameTextview.setText(nameView);
        Log.v("MenuView Holder class: ", "name fetched from firebase");
    }

    public void setMenuImage(Context context, String imageView) {
        imageTextView = mView.findViewById(R.id.menu_image);
        Picasso.with(context).load(imageView).into(imageTextView);
        Log.v("Menu View Holder: " , "image fetched from firebase");
    }


}
