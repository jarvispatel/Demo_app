package com.example.urvish.demo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.urvish.demo.Model.Quote_list;
import com.example.urvish.demo.R;

import java.util.ArrayList;

public class Swap_adapter extends RecyclerView.Adapter<Swap_adapter.View_holder> {

    Context context;
    ArrayList<Quote_list> quote_lists;

    public Swap_adapter(Context swap, ArrayList<Quote_list> quote_lists) {
        this.context = swap;
        this.quote_lists = quote_lists;
    }

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.swap_item, parent, false);
        return new View_holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, int position) {
        Quote_list quote_list = quote_lists.get(position);

//        holder.num_txt.setText(Html.fromHtml("<font color='#212F3D'>" + quote_list.getQuote_title() + "</font>" + "" + quote_list.getQuote_description()), TextView.BufferType.SPANNABLE);
        holder.num_txt.setText(quote_list.getQuote_title() + "\n\n" + quote_list.getQuote_description());
        ;
    }

    @Override
    public int getItemCount() {
        return quote_lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class View_holder extends RecyclerView.ViewHolder {

        TextView num_txt;

        public View_holder(View itemView) {
            super(itemView);

            num_txt = itemView.findViewById(R.id.num_txt);
        }
    }
}
