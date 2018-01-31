package com.mgassociates.bluefin.docs.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.mgassociates.bluefin.docs.R;

public class SplashActivity extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);


        ImageView imageView=(ImageView)findViewById(R.id.logo);
        TextView textView=(TextView)findViewById(R.id.name);

        Animation animTopTOMiddle = AnimationUtils.loadAnimation(this, R.anim.top_to_middle);
        animTopTOMiddle.setInterpolator((new AccelerateDecelerateInterpolator()));
        animTopTOMiddle.setFillAfter(true);
        imageView.setAnimation(animTopTOMiddle);

        Animation animBottomTOMiddle = AnimationUtils.loadAnimation(this, R.anim.bottom_to_middle);
        animBottomTOMiddle.setInterpolator((new AccelerateDecelerateInterpolator()));
        animBottomTOMiddle.setFillAfter(true);
        textView.setAnimation(animTopTOMiddle);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(SplashActivity.this,Navigation_drawer.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
