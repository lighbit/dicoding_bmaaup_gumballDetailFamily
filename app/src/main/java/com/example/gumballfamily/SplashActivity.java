package com.example.gumballfamily;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.ImageView;

public class SplashActivity extends Activity {
    private static final int SPLASH_TIME = 2 * 1000;// 3 seconds delay

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        ImageView iv= (ImageView) findViewById(R.id.img_item_photo);
        iv.setBackgroundResource(R.drawable.gumball);
        try {
            new Handler().postDelayed(new Runnable() {

                public void run() {

                    Intent intent = new Intent(SplashActivity.this,
                            MainActivity.class);
                    startActivity(intent);

                    SplashActivity.this.finish();
                }
            }, SPLASH_TIME);
        } catch(Exception e){}
}
    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}