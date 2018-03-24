package com.adminpankajmehta.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.adminpankajmehta.R;

import java.util.List;

/**
 * Created by raju on 09-09-2017.
 */

public class HomeAdapterTextComplaint extends RecyclerView.Adapter<HomeAdapterTextComplaint.ViewHolder> {

    AdapterView.OnItemClickListener onItemClickListener;
    Context context;

    public HomeAdapterTextComplaint(Context applicationContext, List<String> homelist) {

        context = applicationContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adt_homeadtapter, parent, false), this);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.lv_image.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        HomeAdapterTextComplaint homeAdapter2;
        LinearLayout lv_image;
        private ImageView imgComplaint;
        private TextView textCid, text_contact, text_date;
        private TextView textCtype;
        private TextView textCdesc;


        public ViewHolder(View itemView, HomeAdapterTextComplaint homeAdapter2) {
            super(itemView);
            this.homeAdapter2 = homeAdapter2;
            itemView.setOnClickListener(this);

            imgComplaint = (ImageView) itemView.findViewById(R.id.img_complaint);
            textCid = (TextView) itemView.findViewById(R.id.text_cid);
            text_date = (TextView) itemView.findViewById(R.id.text_date);
            text_contact = (TextView) itemView.findViewById(R.id.text_contact);
            textCtype = (TextView) itemView.findViewById(R.id.text_ctype);
            textCdesc = (TextView) itemView.findViewById(R.id.text_cdesc);
            lv_image = (LinearLayout) itemView.findViewById(R.id.lv_image);
        }

        @Override
        public void onClick(View v) {

            homeAdapter2.setItemClick(this);

        }
    }

    private void setItemClick(ViewHolder viewHolder) {

        onItemClickListener.onItemClick(null, viewHolder.itemView, viewHolder.getAdapterPosition(), viewHolder.getItemId());
    }
}
