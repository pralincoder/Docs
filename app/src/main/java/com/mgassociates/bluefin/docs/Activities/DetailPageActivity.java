package com.mgassociates.bluefin.docs.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.mgassociates.bluefin.docs.Adapters.DetailPageViewPagerAdapter;
import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.Fragments.DetailFragment;
import com.mgassociates.bluefin.docs.Fragments.DocumentsFragment;
import com.mgassociates.bluefin.docs.Fragments.StepsFragment;
import com.mgassociates.bluefin.docs.Models.SubCategory;
import com.mgassociates.bluefin.docs.R;
import com.mgassociates.bluefin.docs.Utils.Validator;

public class DetailPageActivity extends AppCompatActivity implements View.OnClickListener {

    SubCategory mainOfficeDetail;
    DatabaseHandler databaseHandler;
    Validator validator;
    Toolbar toolbar;

    ViewPager detailPageViewPager;
    TabLayout detailpageTabLayout;

    String mainID;

    FloatingActionButton fab, fab_website, fab_call, fab_locate, fab_mail;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;
    private Boolean isFabOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        idDefinations();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mainID = getIntent().getStringExtra("subCategoryID");
        databaseHandler = new DatabaseHandler(this);
        validator = new Validator(this);
        mainOfficeDetail = databaseHandler.getSubCategory(mainID);

        mainOfficeDetail = validator.validateSubCategory(mainOfficeDetail);


        fab_website.setOnClickListener(this);
        fab_locate.setOnClickListener(this);
        fab_call.setOnClickListener(this);
        fab_mail.setOnClickListener(this);
        fab.setOnClickListener(this);

        initViewPager();


    }

    private void initViewPager() {
        DetailPageViewPagerAdapter adapter = new DetailPageViewPagerAdapter(getSupportFragmentManager());

        DetailFragment detailFragment = new DetailFragment();
        DocumentsFragment documentsFragment = new DocumentsFragment();
        StepsFragment stepsFragment = new StepsFragment();

        Bundle bundle = new Bundle();
        bundle.putString("subCategoryID", mainID);

        detailFragment.setArguments(bundle);
        documentsFragment.setArguments(bundle);
        stepsFragment.setArguments(bundle);

        adapter.addFragment(detailFragment, "DETAIL");
        adapter.addFragment(documentsFragment, "DOCUMENTS");
        adapter.addFragment(stepsFragment, "STEPS");
        detailPageViewPager.setAdapter(adapter);


        detailpageTabLayout.setupWithViewPager(detailPageViewPager);

    }

    private void idDefinations() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        detailpageTabLayout = (TabLayout) findViewById(R.id.detailpageTabs);
        detailPageViewPager = (ViewPager) findViewById(R.id.detailPageViewPager);

        fab_call = (FloatingActionButton) findViewById(R.id.fab_call);
        fab_locate = (FloatingActionButton) findViewById(R.id.fab_locate);
        fab_website = (FloatingActionButton) findViewById(R.id.fab_website);
        fab_mail = (FloatingActionButton) findViewById(R.id.fab_mail);


        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);


    }

    public void animateFAB() {

        if (isFabOpen) {

            fab.startAnimation(rotate_backward);
            fab_mail.startAnimation(fab_close);
            fab_locate.startAnimation(fab_close);
            fab_website.startAnimation(fab_close);
            fab_call.startAnimation(fab_close);
            fab_mail.setClickable(false);
            fab_locate.setClickable(false);
            fab_call.setClickable(false);
            fab_mail.setClickable(false);
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimary)));
            isFabOpen = false;


        } else {

            fab.startAnimation(rotate_forward);
            fab_call.startAnimation(fab_open);
            fab_locate.startAnimation(fab_open);
            fab_mail.startAnimation(fab_open);
            fab_website.startAnimation(fab_open);
            fab_call.setClickable(true);
            fab_locate.setClickable(true);
            fab_mail.setClickable(true);
            fab_website.setClickable(true);
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.materialRed)));
            isFabOpen = true;

        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.fab:

                animateFAB();
                break;
            case R.id.fab_call:

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9849775852"));
                if (ActivityCompat.checkSelfPermission(DetailPageActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(DetailPageActivity.this, new String[]{android.Manifest.permission.CALL_PHONE}, 101);

                    return;
                }
                startActivity(intent);
                break;
            case R.id.fab_website:
                String url = mainOfficeDetail.getWebsite();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
                break;
            case R.id.fab_mail:

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{mainOfficeDetail.getEmailAddress()});
                email.putExtra(Intent.EXTRA_SUBJECT, "To "+mainOfficeDetail.getSubCategoryName());
                email.putExtra(Intent.EXTRA_TEXT, "message");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
                break;

            case R.id.fab_locate:
                Intent locate = new Intent(DetailPageActivity.this, EnterLocationActivity.class);
                locate.putExtra("CategoryID",mainOfficeDetail.getId().substring(3) );
                startActivity(locate);
                break;
        }
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
