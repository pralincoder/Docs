package com.mgassociates.bluefin.docs.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.DatabaseUtils.Datas;
import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.Models.SubCategory;
import com.mgassociates.bluefin.docs.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private View mFab;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;


    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView collapsingImageView;
    Toolbar toolbar;
    String toolbarTitle;
    AppBarLayout appbar;

    String userChoice;

    CardView license,bluebook,passport,malpot,votersCard;


    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        databaseHandler = new DatabaseHandler(this);
        userChoice=getIntent().getStringExtra("userChoice");


        idDefination();
        headerImplementation();

        if(userChoice.equalsIgnoreCase("reqDocs")){
            toolbarTitle="Required Documents";
            intentToSubCategory();
        }
        else if(userChoice.equalsIgnoreCase("steps")){
            toolbarTitle="Steps Guidance";
            intentToSteps();

        }
        else  if (userChoice.equalsIgnoreCase("demoForms")){
            toolbarTitle="Demo Forms";
            intentToDemoForm();

        }
        else{
            toolbarTitle="Office Location";
            intentToLocation();
        }




    }

    private void intentToLocation() {
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,EnterLocationActivity.class);
                i.putExtra("CategoryID", "pp");
                startActivity(i);
            }
        });
        bluebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,EnterLocationActivity.class);
                i.putExtra("CategoryID", "bb");

                startActivity(i);
            }
        });
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,EnterLocationActivity.class);
                i.putExtra("CategoryID", "lc");

                startActivity(i);
            }
        });

        malpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,EnterLocationActivity.class);
                i.putExtra("CategoryID", "m");

                startActivity(i);
            }
        });
        votersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,EnterLocationActivity.class);
                i.putExtra("CategoryID", "vc");

                startActivity(i);
            }
        });
    }

    private void intentToDemoForm() {
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,DemoFormActivity.class);
                i.putExtra("CategoryID", "pp");
                startActivity(i);
            }
        });
        bluebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,DemoFormActivity.class);
                i.putExtra("CategoryID", "bb");

                startActivity(i);
            }
        });
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,DemoFormActivity.class);
                i.putExtra("CategoryID", "lc");

                startActivity(i);
            }
        });

        malpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,DemoFormActivity.class);
                i.putExtra("CategoryID", "m");

                startActivity(i);
            }
        });
        votersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,DemoFormActivity.class);
                i.putExtra("CategoryID", "vc");

                startActivity(i);
            }
        });
    }

    private void intentToSteps() {
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,StepsActivity.class);
                i.putExtra("CategoryID", "pp");
                startActivity(i);
            }
        });
        bluebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,StepsActivity.class);
                i.putExtra("CategoryID", "bb");

                startActivity(i);
            }
        });
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,StepsActivity.class);
                i.putExtra("CategoryID", "lc");

                startActivity(i);
            }
        });

        malpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,StepsActivity.class);
                i.putExtra("CategoryID", "m");

                startActivity(i);
            }
        });
        votersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,StepsActivity.class);
                i.putExtra("CategoryID", "vc");

                startActivity(i);
            }
        });


    }

    private void intentToSubCategory() {
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,SubCategoryActivity.class);
                i.putExtra("CategoryID", "pp");
                startActivity(i);
            }
        });
        bluebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,SubCategoryActivity.class);
                i.putExtra("CategoryID", "bb");

                startActivity(i);
            }
        });
        license.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,SubCategoryActivity.class);
                i.putExtra("CategoryID", "lc");

                startActivity(i);
            }
        });

        malpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,SubCategoryActivity.class);
                i.putExtra("CategoryID", "m");

                startActivity(i);
            }
        });
        votersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CategoryActivity.this,SubCategoryActivity.class);
                i.putExtra("CategoryID", "vc");

                startActivity(i);
            }
        });


    }





    public void idDefination() {
        toolbar = (Toolbar) findViewById(R.id.flexible_example_toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.flexible_example_collapsing);
        collapsingImageView = (ImageView) findViewById(R.id.collapsingImageView);
        appbar = (AppBarLayout) findViewById(R.id.flexible_example_appbar);
//        mFab = findViewById(R.id.flexible_example_fab);

        passport=(CardView) findViewById(R.id.passport);
        bluebook=(CardView)findViewById(R.id.bluebook);
        license=(CardView)findViewById(R.id.license);
        malpot=(CardView)findViewById(R.id.malpot);
        votersCard=(CardView)findViewById(R.id.votersCard);


    }

    public void headerImplementation() {

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        appbar.addOnOffsetChangedListener(this);

        collapsingToolbarLayout.setTitle(toolbarTitle);


//        mFab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(CategoryActivity.this, "sdalfnasjkdnfsd", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
//        if (mMaxScrollSize == 0)
//            mMaxScrollSize = appBarLayout.getTotalScrollRange();
//
//        int currentScrollPercentage = (Math.abs(i)) * 100
//                / mMaxScrollSize;
//
//        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
//            if (!mIsImageHidden) {
//                mIsImageHidden = true;
//
//                ViewCompat.animate(mFab).scaleY(0).scaleX(0).start();
//            }
//        }
//
//        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
//            if (mIsImageHidden) {
//                mIsImageHidden = false;
//                ViewCompat.animate(mFab).scaleY(1).scaleX(1).start();
//            }
//        }
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

