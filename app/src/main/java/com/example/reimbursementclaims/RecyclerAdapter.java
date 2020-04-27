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
        View listItem= layoutInflater.inflate(R.layout.list_recycler, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final MyList myListData = listdata[position];
        holder.nameView.setText(listdata[position].getName());
        holder.imagelicView.setImageResource(listdata[position].getImagelic());;
        holder.paymentView.setText(listdata[position].getPayment());
        holder.weeklyView.setText(listdata[position].getWeekly());
        holder.moneyView.setText(listdata[position].getMoney());

    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagelicView;
        public TextView nameView;
        public TextView paymentView;
        public TextView weeklyView;
        public TextView moneyView;

        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imagelicView = (ImageView) itemView.findViewById(R.id.imagelic);
            this.nameView = (TextView) itemView.findViewById(R.id.name);
            this.paymentView = (TextView) itemView.findViewById(R.id.payment);
            this.weeklyView = (TextView) itemView.findViewById(R.id.weekly);
            this.moneyView = (TextView) itemView.findViewById(R.id.money);
        }

    }

}
