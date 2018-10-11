package com.example.shreeyanshi.authenticationexample;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shreeyanshi.authenticationexample.Model.Category;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context mContext;
    Dialog myDialog;
    List<Category> categories;

    //Constructor

    public RecyclerViewAdapter(Context mContext, List<Category> categories) {
        this.mContext = mContext;
        this.categories=categories;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.pet_list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        //if the 1st pet item is displayed no divider should be there on the top so removing the first viewline

        if (position == 0){
            holder.divideLine.setVisibility(View.INVISIBLE);
        }

        //to set the details in the fragment of browsing pets

        Picasso
                .with(mContext)
                .load(categories.get(position).getImage())
                .centerCrop()
                .into(holder.image);
        //holder.image.setImageResource(categories.get(position).getImage());
        holder.category.setText(categories.get(position).getName());
        holder.breed.setText("test");
        holder.weight.setText("test");
        holder.age.setText("test");
        holder.price.setText("test");

        //setting the new dialog for click items

        myDialog = new Dialog(mContext);
        myDialog.setContentView(R.layout.pet_dialog);

        //setting the click listener

     /*   holder.petListItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //finding views to display the details of Pets on clicking on each pet item

                ImageView dialogImage = (ImageView) myDialog.findViewById(R.id.dialog_image_id);
                TextView dialogCategory = (TextView) myDialog.findViewById(R.id.dialog_category_id);
                TextView dialogBreed = (TextView) myDialog.findViewById(R.id.dialog_breed_id);
                TextView dialogWeight = (TextView) myDialog.findViewById(R.id.dialog_weight_id);
                TextView dialogAge = (TextView) myDialog.findViewById(R.id.dialog_age_id);
                TextView dialogPrice = (TextView) myDialog.findViewById(R.id.dialog_price_id);
                Button buyButton = (Button) myDialog.findViewById(R.id.buy_pet_id);

                //setting the information to dialog box

                dialogImage.setImageResource(mData.get(holder.getAdapterPosition()).getImage());
                dialogCategory.setText(mData.get(holder.getAdapterPosition()).getCategory());
                dialogBreed.setText(mData.get(holder.getAdapterPosition()).getBreed());
                dialogWeight.setText(mData.get(holder.getAdapterPosition()).getWeight());
                dialogAge.setText(mData.get(holder.getAdapterPosition()).getAge());
                dialogPrice.setText(mData.get(holder.getAdapterPosition()).getPrice());
                buyButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "Buy Pet Clicked!", Toast.LENGTH_SHORT).show();
                    }
                });

                Toast.makeText(mContext, "Item Clicked " + String.valueOf(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
                myDialog.show();
            }
        });
*/
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        protected View divideLine;
        private LinearLayout petListItem;
        private ImageView image;
        private TextView category;
        private TextView breed;
        private TextView weight;
        private TextView age;
        private TextView price;

        public MyViewHolder(View itemView) {
            super(itemView);

            //elements of recycler view

            image = (ImageView) itemView.findViewById(R.id.pet_imageView);
            category = (TextView) itemView.findViewById(R.id.pet_category_name);
            breed = (TextView) itemView.findViewById(R.id.pet_breed_name);
            weight = (TextView) itemView.findViewById(R.id.pet_weights);
            age = (TextView) itemView.findViewById(R.id.pet_age_no_);
            price = (TextView) itemView.findViewById(R.id.pet_price_textView);
            petListItem = (LinearLayout) itemView.findViewById(R.id.parentLayout);
            divideLine = (View) itemView.findViewById(R.id.viewLine);

        }
    }
}
