package com.example.reimbursementclaims;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private MyList[] listdata;

    // RecyclerView recyclerView;
    public RecyclerAdapter(MyList[] listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final MyList myListData = listdata[position];
        holder.cashView.setImageResource(listdata[position].getCash());;
        holder.claim1View.setText(listdata[position].getClaim1());
        holder.november17View.setText(listdata[position].getNovember17());
        holder.money1View.setText(listdata[position].getMoney1());
    }
    @Override
    public int getItemCount() {
        return listdata.length;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cashView;
        public TextView claim1View;
        public TextView november17View;
        public TextView money1View;

        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.cashView = (ImageView) itemView.findViewById(R.id.cash);
            this.claim1View = (TextView) itemView.findViewById(R.id.claim1);
            this.november17View = (TextView) itemView.findViewById(R.id.november17);
            this.money1View = (TextView) itemView.findViewById(R.id.money1);
        }
    }
}
