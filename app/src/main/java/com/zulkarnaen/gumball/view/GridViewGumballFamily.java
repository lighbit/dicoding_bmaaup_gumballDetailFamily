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

public class GridViewGumballFamily extends RecyclerView.Adapter<GridViewGumballFamily.GridViewHolder> {

    private Context context;
    private ArrayList<GumballFamily> listgumballfamily;

    private ArrayList<GumballFamily> getListgumballfamily() {
        return listgumballfamily;
    }

    public void setListGumball(ArrayList<GumballFamily> listgumballfamily) {
        this.listgumballfamily = listgumballfamily;
    }

    public GridViewGumballFamily(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_grid_gumball_family, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        final GumballFamily k = getListgumballfamily().get(position);
        Glide.with(context)
                .load(getListgumballfamily().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.tvname.setText(k.getName());
        holder.gumballFamily = k;
    }

    @Override
    public int getItemCount() {
        return getListgumballfamily().size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvname;
        GumballFamily gumballFamily;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvname = itemView.findViewById(R.id.tv_item_name);
            imgPhoto.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, DetailGumballFamilyActivity.class);
            intent.putExtra("key", gumballFamily);
            context.startActivity(intent);
        }
    }
}