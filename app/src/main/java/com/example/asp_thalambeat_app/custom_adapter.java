package com.example.asp_thalambeat_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class custom_adapter extends RecyclerView.Adapter<custom_adapter.viewHolder> {
    ArrayList<help_data> helpData;

    public custom_adapter(ArrayList<help_data> helpData) {
        this.helpData = helpData;
    }

    public static class viewHolder extends RecyclerView.ViewHolder{
        TextView heading, body;
        ImageView img;
        LinearLayout lin;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.heading_tv);
            body = itemView.findViewById(R.id.body_tv);
            img = itemView.findViewById(R.id.help_img_tv);
            lin = itemView.findViewById(R.id.itemlist);
        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inf = LayoutInflater.from(viewGroup.getContext());
        return  new viewHolder(inf.inflate(R.layout.items, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {
        TextView head, bod;
        ImageView img;
        head = viewHolder.heading;
        bod = viewHolder.body;
        img = viewHolder.img;

        head.setText(helpData.get(i).getHeading());
        bod.setText(helpData.get(i).getBody());
        img.setImageResource(helpData.get(i).getImage_id());
    }

    @Override
    public int getItemCount() {
        return helpData.size();
    }
}
