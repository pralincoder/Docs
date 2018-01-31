package com.mgassociates.bluefin.docs.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.mgassociates.bluefin.docs.Adapters.SubCategoryRecyclerViewAdapter;
import com.mgassociates.bluefin.docs.DatabaseUtils.DatabaseHandler;
import com.mgassociates.bluefin.docs.Models.Category;
import com.mgassociates.bluefin.docs.R;
import com.mgassociates.bluefin.docs.Utils.Validator;

public class SubCategoryActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener, SubCategoryRecyclerViewAdapter.ClickListener {

    private static final int PERCENTAGE_TO_SHOW_IMAGE = 20;
    private View mFab;
    private int mMaxScrollSize;
    private boolean mIsImageHidden;
    FloatingActionButton fab;
    Category mainCategoryInfo;
    DatabaseHandler databaseHandler;

    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView collapsingImageView;
    Toolbar toolbar;
    AppBarLayout appbar;

    int headerImage;

    RecyclerView subCategoryRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        String mainCategoryID = getIntent().getExtras().getString("CategoryID");
        databaseHandler = new DatabaseHandler(this);
        mainCategoryInfo = databaseHandler.getCategory(mainCategoryID);
        mainCategoryInfo = new Validator(this).validateCategory(mainCategoryInfo);

        if (mainCategoryID.equalsIgnoreCase("pp")) {
            headerImage = R.drawable.pp;

        } else if (mainCategoryID.equalsIgnoreCase("lc")) {
            headerImage = R.drawable.lc;


        } else if (mainCategoryID.equalsIgnoreCase("bb")) {
            headerImage = R.drawable.bb;


        } else if (mainCategoryID.equalsIgnoreCase("vc")) {
            headerImage = R.drawable.vc;


        } else {
            headerImage = R.drawable.mp;

        }

        idDefination();
        headerImplementation();

        initRecyclerView();


    }

    private void initRecyclerView() {


        SubCategoryRecyclerViewAdapter adapter = new SubCategoryRecyclerViewAdapter(SubCategoryActivity.this, mainCategoryInfo, this);
        GridLayoutManager manager = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false);
        subCategoryRecyclerView.setLayoutManager(manager);
        subCategoryRecyclerView.setAdapter(adapter);
    }

    private void headerImplementation() {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        collapsingImageView.setImageResource(headerImage);

        appbar.addOnOffsetChangedListener(this);

        collapsingToolbarLayout.setTitle(mainCategoryInfo.getCategoryName());


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Different Categories of "+ mainCategoryInfo.getCategoryName(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        subCategoryRecyclerView = (RecyclerView) findViewById(R.id.subCategoryRecyclerView);
    }

    private void idDefination() {
        fab = (FloatingActionButton) findViewById(R.id.fab);
        toolbar = (Toolbar) findViewById(R.id.flexible_example_toolbar);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.flexible_example_collapsing);
        collapsingImageView = (ImageView) findViewById(R.id.collapsingImageView);
        appbar = (AppBarLayout) findViewById(R.id.flexible_example_appbar);


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
        if (mMaxScrollSize == 0)
            mMaxScrollSize = appBarLayout.getTotalScrollRange();

        int currentScrollPercentage = (Math.abs(i)) * 100
                / mMaxScrollSize;

        if (currentScrollPercentage >= PERCENTAGE_TO_SHOW_IMAGE) {
            if (!mIsImageHidden) {
                mIsImageHidden = true;

                ViewCompat.animate(mFab).scaleY(0).scaleX(0).start();
            }
        }

        if (currentScrollPercentage < PERCENTAGE_TO_SHOW_IMAGE) {
            if (mIsImageHidden) {
                mIsImageHidden = false;
                ViewCompat.animate(mFab).scaleY(1).scaleX(1).start();
            }
        }
    }


    @Override
    public void onItemClick(Category clickedCategory, int position) {

        Intent i = new Intent(SubCategoryActivity.this, DetailPageActivity.class);
        i.putExtra("subCategoryID", clickedCategory.getSubCategoriesid().get(position));

        startActivity(i);

    }
}
