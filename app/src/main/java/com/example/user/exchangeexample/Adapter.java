package com.example.user.exchangeexample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.exchangeexample.model.History;

import java.util.List;

/**
 * Created by user on 26.07.17.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private List<History> histories;

    public Adapter(List<History> histories) {
        this.histories = histories;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        History history = histories.get(position);
        //holder.id.setText(String.valueOf(history.getId()));
        holder.currentRate.setText(String.valueOf(history.getCurrentRate()));
        holder.value.setText(String.valueOf(history.getValue()));
        holder.result.setText(String.valueOf(history.getResult()));
        holder.date.setText(String.valueOf(history.getDate()));
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView currentRate;
        TextView value;
        TextView result;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            //this.id = itemView.findViewById(R.id.id);
            this.currentRate = itemView.findViewById(R.id.currentRate);
            this.value = itemView.findViewById(R.id.value);
            this.result = itemView.findViewById(R.id.result);
            this.date = itemView.findViewById(R.id.date);
        }
    }
}
