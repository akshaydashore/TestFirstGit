package com.example.demo.networkproject;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import com.example.demo.networkproject.bean.HomeBean;
import java.util.ArrayList;

/**
 * Created by akshaydashore on 9/4/18
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.Holder> {

    Context context;
    HomeBean homeBean;

    public HomeAdapter(Context context, HomeBean homeBean) {
        this.context = context;
        this.homeBean = homeBean;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_adapter, null);
        Holder holder = new Holder(view, viewType);
        return holder;
    }


    @Override
    public void onBindViewHolder(Holder holder, int position) {

        if (getItemViewType(position) == ViewHandler.slider_view) {

            HorizontalReclerAdapter horizontalReclerAdapter = new HorizontalReclerAdapter(context, ViewHandler.popular_product, new ArrayList(homeBean.getData().getPopularProduct()));
            holder.recyclerView.setAdapter(horizontalReclerAdapter);

        } else if (getItemViewType(position) == ViewHandler.popular_product) {

            HorizontalReclerAdapter horizontalReclerAdapter = new HorizontalReclerAdapter(context, ViewHandler.popular_product, new ArrayList(homeBean.getData().getPopularProduct()));
            holder.recyclerView.setAdapter(horizontalReclerAdapter);
            holder.category_title.setText("Popular Product");
            holder.category_title.setPaintFlags(holder.category_title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        } else if (getItemViewType(position) == ViewHandler.popular_service) {

            HorizontalReclerAdapter horizontalReclerAdapter = new HorizontalReclerAdapter(context, ViewHandler.popular_service, new ArrayList(homeBean.getData().getPopularService()));
            holder.recyclerView.setAdapter(horizontalReclerAdapter);
            holder.category_title.setText("Popular Service");

        } else if (getItemViewType(position) == ViewHandler.popular_category) {

            GridAdapter horizontalReclerAdapter = new GridAdapter(context, ViewHandler.popular_category, new ArrayList(homeBean.getData().getPopularCategory()));
            holder.recyclerView.setAdapter(horizontalReclerAdapter);
            holder.category_title.setText("Popular Category");

        } else if (getItemViewType(position) == ViewHandler.all_category) {

            GridAdapter horizontalReclerAdapter = new GridAdapter(context, ViewHandler.all_category, new ArrayList(homeBean.getData().getAllCategory()));
            holder.recyclerView.setAdapter(horizontalReclerAdapter);
            holder.category_title.setText("All Category");

        }

    }


    @Override
    public int getItemCount() {
        return ViewHandler.total_view_count;
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0) {
            return ViewHandler.slider_view;
        }

        if (position == 1) {
            return ViewHandler.popular_product;
        }

        if (position == 2) {
            return ViewHandler.popular_service;
        }

        if (position == 3) {
            return ViewHandler.popular_category;
        }

        if (position == 4) {
            return ViewHandler.all_category;
        }

        return super.getItemViewType(position);
    }


    class Holder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView category_title, view_all_tv;

        public Holder(View itemView, int viewType) {

            super(itemView);
            category_title = itemView.findViewById(R.id.category_title);
            view_all_tv = itemView.findViewById(R.id.view_all_tv);
            recyclerView = itemView.findViewById(R.id.horizontal_recycler);

            if (viewType == ViewHandler.all_category) {

                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 3);
                recyclerView.setLayoutManager(gridLayoutManager);
                int padding = (int) context.getResources().getDimension(R.dimen._15sdp);
                recyclerView.setPadding(padding,padding,padding,padding);

            } else {

                LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                recyclerView.setLayoutManager(manager);
            }
        }
    }


    interface ViewHandler {

        int total_view_count = 5;
        int slider_view = 0;
        int popular_product = 1;
        int popular_service = 2;
        int popular_category = 3;
        int all_category = 4;

    }

}
