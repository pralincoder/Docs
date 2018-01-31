package com.mgassociates.bluefin.docs.Activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mgassociates.bluefin.docs.Adapters.DemoFormViewPagerAdapter;
import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.Models.SubCategory;
import com.mgassociates.bluefin.docs.R;
import com.mgassociates.bluefin.docs.Utils.Validator;

import java.util.ArrayList;

public class DemoFormActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {

    ViewPager demoFormViewPager;

    ArrayList<Integer> images = new ArrayList<>();
    protected View view;
    private ImageButton btnNext, btnFinish;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private DemoFormViewPagerAdapter adapter;

    DatabaseHandler databaseHandler;
    Category mainCategoryInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_form);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String mainCategoryID = getIntent().getExtras().getString("CategoryID");
        databaseHandler=new DatabaseHandler(this);
        mainCategoryInfo=databaseHandler.getCategory(mainCategoryID);


        demoFormViewPager = (ViewPager) findViewById(R.id.demoFormViewPager);
        btnNext = (ImageButton) findViewById(R.id.btn_next);
        btnFinish = (ImageButton)findViewById(R.id.btn_finish);

        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        btnNext.setOnClickListener(this);
        btnFinish.setOnClickListener(this);

        images = getDemoFormsImages(mainCategoryID);

        adapter = new DemoFormViewPagerAdapter(DemoFormActivity.this, images);
        demoFormViewPager.setAdapter(adapter);
        demoFormViewPager.setCurrentItem(0);
        demoFormViewPager.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {
        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    private ArrayList<Integer> getDemoFormsImages(String id) {
        ArrayList<Integer> imageLIsts = new ArrayList<>();
        imageLIsts.add(R.drawable.demo_form);
        imageLIsts.add(R.drawable.demo_form);
        imageLIsts.add(R.drawable.demo_form);
        imageLIsts.add(R.drawable.demo_form);
        imageLIsts.add(R.drawable.demo_form);

        return imageLIsts;

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));

        if (position + 1 == dotsCount) {
            btnNext.setVisibility(View.GONE);
            btnFinish.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnFinish.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                demoFormViewPager.setCurrentItem((demoFormViewPager.getCurrentItem() < dotsCount)
                        ? demoFormViewPager.getCurrentItem() + 1 : 0);
                break;

            case R.id.btn_finish:
                finish();
                break;
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
