package com.zulkarnaen.gumball.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gumballfamily.R;
import com.zulkarnaen.gumball.data.GumballFamily;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class RowViewGumballFamily extends RecyclerView.Adapter<RowViewGumballFamily.CategoryViewHolder>{
    private Context context;
    private ArrayList<GumballFamily> listgumballfamily;

    private ArrayList<GumballFamily> getListgumballfamily() {
        return listgumballfamily;
    }

    public void setListGumball(ArrayList<GumballFamily> listgumballfamily) {
        this.listgumballfamily = listgumballfamily;
    }

    public RowViewGumballFamily(Context context) {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row_gumball_family, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        final GumballFamily k = getListgumballfamily().get(position);
//        Glide.with(context).load(k.getPhoto()).override(350,550).into(holder.imgPhoto);
        Glide.with(context)
                .load(k.getPhoto())
                .transition(withCrossFade())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
        categoryViewHolder.tvName.setText(k.getName());
        categoryViewHolder.tvRemarks.setText(k.getRemarks());
        categoryViewHolder.gumballFamily = k;
    }

    @Override
    public int getItemCount() {
        return getListgumballfamily().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        GumballFamily gumballFamily;

        CategoryViewHolder( View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            imgPhoto.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailGumballFamilyActivity.class);
            intent.putExtra("key", gumballFamily);
            context.startActivity(intent);

        }
    }
}