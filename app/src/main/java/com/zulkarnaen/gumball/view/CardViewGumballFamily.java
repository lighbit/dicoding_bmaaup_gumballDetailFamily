package com.zulkarnaen.gumball.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.zulkarnaen.gumball.service.CustomOnItemClickListener;
import com.zulkarnaen.gumball.data.GumballFamily;
import com.example.gumballfamily.R;

import java.util.ArrayList;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class CardViewGumballFamily extends RecyclerView.Adapter<CardViewGumballFamily.CardViewHolder> {

    private ArrayList<GumballFamily> listgumball;
    private Context context;
    private Activity activity;

    public CardViewGumballFamily(Context context) {
        this.context = context;
    }

    public ArrayList<GumballFamily> getListgumball() {
        return listgumball;
    }

    public void setListGumball(ArrayList<GumballFamily> listgumball) {
        this.listgumball = listgumball;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_gumball_family, parent, false);
        CardViewHolder viewHolder = new CardViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        final GumballFamily k = getListgumball().get(position);
//        Glide.with(context).load(k.getPhoto()).override(350,550).into(holder.imgPhoto);
        Glide.with(context)
                .load(k.getPhoto())
                .transition(withCrossFade())
                .apply(new RequestOptions().override(153, 160))
                .into(holder.imgPhoto);
        holder.tvname.setText(k.getName());
        holder.tvremarks.setText(k.getRemarks());
        holder.gumballFamily = k;


//        holder.btnsahre.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(View view, int position) {
//                Toast.makeText(context, "Kamu Share  " + getListgumball().get(position).getName(), Toast.LENGTH_SHORT).show();
//            }
//        }));


    }

    @Override
    public int getItemCount() {
        return getListgumball().size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvname, tvremarks;
        Button btndetail, btnsahre;
        GumballFamily gumballFamily;

        public CardViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
            tvname = (TextView) itemView.findViewById(R.id.tv_item_name);
            tvremarks = (TextView) itemView.findViewById(R.id.tv_item_remarks);
            btnsahre = (Button) itemView.findViewById(R.id.btn_set_share);
            btndetail = (Button) itemView.findViewById(R.id.btn_set_detail);
            btndetail.setOnClickListener(this);
            imgPhoto.setOnClickListener(this);
            btnsahre.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_set_detail :
                    Intent moveDetail = new Intent(context, DetailGumballFamilyActivity.class);
                    moveDetail.putExtra("key", gumballFamily);
                    context.startActivity(moveDetail);
                    break;

                case R.id.img_item_photo :
                    Intent movePhoto = new Intent(context, DetailGumballFamilyActivity.class);
                    movePhoto.putExtra("key", gumballFamily);
                    context.startActivity(movePhoto);
                    break;

                case R.id.btn_set_share:
                    Intent moveShare = new Intent(context, ShareCompleteGumball.class);
                    moveShare.putExtra("key1", gumballFamily);
                    context.startActivity(moveShare);
                    break;
            }

        }
    }
}
