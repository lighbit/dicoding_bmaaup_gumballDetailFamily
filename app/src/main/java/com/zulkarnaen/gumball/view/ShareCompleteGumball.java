package com.zulkarnaen.gumball.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gumballfamily.R;
import com.zulkarnaen.gumball.data.GumballFamily;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ShareCompleteGumball extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_complete);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        GumballFamily gumballFamily = getIntent().getParcelableExtra("key1");

        ImageView gamabar = (ImageView) findViewById(R.id.img_item_photo);
        TextView name = (TextView) findViewById(R.id.tv_item_name);

//        Glide.with(this).load(gumballFamily.getPhoto()).override(350,550).into(gamabar);
        Glide.with(this)
                .load(gumballFamily.getPhoto())
                .transition(withCrossFade())
                .apply(new RequestOptions().override(153, 160))
                .into(gamabar);


        name.setText(gumballFamily.getName());

        Log.i("photo", gumballFamily.getPhoto());
        Log.i("deskripsi", gumballFamily.getDeskripsi());
    }


}
