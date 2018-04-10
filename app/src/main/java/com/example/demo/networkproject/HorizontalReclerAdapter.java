package com.example.demo.networkproject;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.demo.networkproject.bean.AllCategory;
import com.example.demo.networkproject.bean.PopularCategory;
import com.example.demo.networkproject.bean.PopularProduct;
import com.example.demo.networkproject.bean.PopularService;

import java.util.ArrayList;

/**
 * Created by akshaydashore on 9/4/18
 */
public class HorizontalReclerAdapter extends RecyclerView.Adapter<HorizontalReclerAdapter.Holder> {

    Context context;
    int viewtype;
    ArrayList list;

    public HorizontalReclerAdapter(Context context, int viewtype, ArrayList list) {
        this.context = context;
        this.viewtype = viewtype;
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_inner_adapter, null);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        if (viewtype == HomeAdapter.ViewHandler.slider_view) {

            PopularProduct popularProduct = (PopularProduct) list.get(0);
            Glide.with(context).load(popularProduct.getImage()).into(holder.product_image);
            holder.product_title.setText(popularProduct.getTitle());

        } else if (viewtype == HomeAdapter.ViewHandler.popular_product) {

            PopularProduct popularProduct = (PopularProduct) list.get(0);
            Glide.with(context)
                    .load(popularProduct.getImage())
                    .thumbnail(0.5f)
                    .into(holder.product_image)
                    .onLoadFailed(null, context.getDrawable(R.mipmap.ic_launcher_round));
            holder.product_title.setText(popularProduct.getTitle());

        } else if (viewtype == HomeAdapter.ViewHandler.popular_service) {

            PopularService popularService = (PopularService) list.get(0);
            Glide.with(context).load(popularService.getImage()).into(holder.product_image);
            holder.product_title.setText(popularService.getTitle());

        } else if (viewtype == HomeAdapter.ViewHandler.popular_category) {

            PopularCategory popularCategory = (PopularCategory) list.get(0);
            Glide.with(context).load(popularCategory.getImage()).into(holder.product_image);
            holder.product_title.setText(popularCategory.getTitle());

        } else if (viewtype == HomeAdapter.ViewHandler.all_category) {

            AllCategory allCategory = (AllCategory) list.get(0);
            Glide.with(context).load(allCategory.getImage()).into(holder.product_image);
            holder.product_title.setText(allCategory.getTitle());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class Holder extends RecyclerView.ViewHolder {

        TextView product_title;
        ImageView product_image;

        public Holder(View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_title = itemView.findViewById(R.id.product_title);
        }
    }

}
