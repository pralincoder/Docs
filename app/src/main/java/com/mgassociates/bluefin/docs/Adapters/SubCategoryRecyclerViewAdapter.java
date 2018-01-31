package com.mgassociates.bluefin.docs.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.R;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/27/18.
 */

public class SubCategoryRecyclerViewAdapter extends RecyclerView.Adapter<SubCategoryRecyclerViewAdapter.MyViewHolder> {
    Context context;
    Category office;
    ClickListener clickListener;

    public SubCategoryRecyclerViewAdapter(Context context, Category office, ClickListener clickListener) {
        this.context = context;
        this.office = office;
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sub_category_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        holder.heading.setText(office.getSubCategories().get(position));
        holder.viewHolderCategory=office;
        holder.image.setImageResource(R.drawable.passport_icon);


    }

    @Override
    public int getItemCount() {
        return office.getSubCategories().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView heading;
        RelativeLayout relativeLayout;
        Category viewHolderCategory;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.subCategoryImage);
            heading = (TextView) itemView.findViewById(R.id.subCategoryName);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.subCategoryRL);
            relativeLayout.setOnClickListener(this);



        }


        @Override
        public void onClick(View view) {
            if (clickListener != null) {
                clickListener.onItemClick(viewHolderCategory,getAdapterPosition());

            }
        }
    }

    public interface ClickListener {
        void onItemClick(Category clickedCategory,int position);
    }
}
