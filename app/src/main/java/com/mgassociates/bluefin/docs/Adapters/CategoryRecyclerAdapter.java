package com.mgassociates.bluefin.docs.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mgassociates.bluefin.docs.R;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/29/18.
 */

public class CategoryRecyclerAdapter extends RecyclerView.Adapter<CategoryRecyclerAdapter.ViewHolder> {
    private ArrayList<String> categoryNames=new ArrayList<>();
    private ArrayList<Integer> categoryImages=new ArrayList<>();
    Context context;

    public CategoryRecyclerAdapter(ArrayList<String> categoryNames, ArrayList<Integer> categoryImages, Context context) {
        this.categoryNames = categoryNames;
        this.categoryImages = categoryImages;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.category_title.setText(categoryNames.get(position));
        holder.image_category.setImageResource(categoryImages.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_category;
        TextView category_title;
        public ViewHolder(View itemView) {
            super(itemView);
            category_title=(TextView) itemView.findViewById(R.id.category_title);
            image_category=(ImageView)itemView.findViewById(R.id.category_image);

        }
    }
}
