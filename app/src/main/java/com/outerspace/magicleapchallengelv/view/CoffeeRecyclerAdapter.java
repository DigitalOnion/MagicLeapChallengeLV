package com.outerspace.magicleapchallengelv.view;

import java.util.List;

import com.bumptech.glide.Glide;
import com.outerspace.magicleapchallengelv.R;
import com.outerspace.magicleapchallengelv.api.CoffeeMenu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CoffeeRecyclerAdapter extends RecyclerView.Adapter<CoffeeRecyclerAdapter.CoffeeViewHolder> {
    private List<CoffeeMenu> menuList;
    private Context parentContext;

    public CoffeeRecyclerAdapter(List<CoffeeMenu> menuList) {
        this.menuList = menuList;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        parentContext = parent.getContext();
        View view =  LayoutInflater.from(parentContext).inflate(R.layout.coffee_holder, parent);
        CoffeeViewHolder holder = new CoffeeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        CoffeeMenu coffee = menuList.get(position);
        holder.holderId.setText(coffee.id);
        holder.holderDescription.setText(coffee.desc);
        Glide.with(parentContext)
                .load(coffee.imageUrl)
                .into(holder.holderImage);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public static class CoffeeViewHolder extends RecyclerView.ViewHolder {
        public TextView holderId;
        public TextView holderDescription;
        public ImageView holderImage;

        public CoffeeViewHolder(View itemView) {
            super(itemView);
            holderId = itemView.findViewById(R.id.holder_name);
            holderDescription = itemView.findViewById(R.id.holder_description);
            holderImage = itemView.findViewById(R.id.holder_image);
        }
    }
}
