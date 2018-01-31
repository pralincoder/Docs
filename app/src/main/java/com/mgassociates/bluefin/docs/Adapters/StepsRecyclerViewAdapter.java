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
 * Created by reddevil on 1/28/18.
 */

public class StepsRecyclerViewAdapter extends RecyclerView.Adapter<StepsRecyclerViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> steps=new ArrayList<>();

    public StepsRecyclerViewAdapter(Context context, ArrayList<String> steps) {
        this.context = context;
        this.steps = steps;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.steps_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.stepNumber.setText(String.valueOf(position+1));
        holder.stepDescription.setText(steps.get(position));

    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView stepNumber,stepDescription;
        public MyViewHolder(View itemView) {
            super(itemView);
            stepNumber=(TextView)itemView.findViewById(R.id.stepNumber);
            stepDescription=(TextView)itemView.findViewById(R.id.stepTExtView);
        }
    }
}
