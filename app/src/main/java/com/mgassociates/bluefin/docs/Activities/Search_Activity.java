package com.mgassociates.bluefin.docs.Activities;

import android.animation.TimeInterpolator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.mgassociates.bluefin.docs.R;



    public class Search_Activity extends Activity {

        private ImageView iv;
        private TextView text;
        private AnimatedVectorDrawable searchToBar;
        private AnimatedVectorDrawable barToSearch;
        private float offset;
        private Interpolator interp;
        private int duration;
        private boolean expanded = false;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            iv = (ImageView) findViewById(R.id.search);
            text = (TextView) findViewById(R.id.text);
            searchToBar = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim_search_to_bar);
            barToSearch = (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.anim_bar_to_search);
            interp = AnimationUtils.loadInterpolator(this, android.R.interpolator.linear_out_slow_in);
            duration = getResources().getInteger(R.integer.duration_bar);
            // iv is sized to hold the search+bar so when only showing the search icon, translate the
            // whole view left by half the difference to keep it centered
            offset = -71f * (int) getResources().getDisplayMetrics().scaledDensity;
            iv.setTranslationX(offset);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public void animate(View view) {

            if (!expanded) {
                iv.setImageDrawable(searchToBar);
                searchToBar.start();
                iv.animate().translationX(0f).setDuration(duration).setInterpolator((TimeInterpolator) interp);
                text.animate().alpha(1f).setStartDelay(duration - 100).setDuration(100).setInterpolator((TimeInterpolator) interp);
            } else {
                iv.setImageDrawable(barToSearch);
                barToSearch.start();
                iv.animate().translationX(offset).setDuration(duration).setInterpolator((TimeInterpolator) interp);
                text.setAlpha(0f);
            }
            expanded = !expanded;
        }
    }

