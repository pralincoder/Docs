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

public class RequiredDocumentsRecyclerAdapter extends RecyclerView.Adapter<RequiredDocumentsRecyclerAdapter.MyViewHolder> {
    Context context;
    ArrayList<String> docs=new ArrayList<>();

    public RequiredDocumentsRecyclerAdapter(Context context, ArrayList<String> docs) {
        this.context = context;
        this.docs = docs;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.required_document_items,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.image.setImageResource(R.drawable.document_icon);
        holder.docname.setText(docs.get(position));

    }

    @Override
    public int getItemCount() {
        return docs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView docname;
        public MyViewHolder(View itemView) {
            super(itemView);
            image=(ImageView)itemView.findViewById(R.id.docImageView);
            docname=(TextView)itemView.findViewById(R.id.docName);
        }
    }
}
