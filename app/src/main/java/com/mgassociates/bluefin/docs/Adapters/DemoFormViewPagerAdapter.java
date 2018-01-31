package com.mgassociates.bluefin.docs.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mgassociates.bluefin.docs.R;

import java.util.ArrayList;

/**
 * Created by reddevil on 1/28/18.
 */

public class DemoFormViewPagerAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<Integer> images=new ArrayList<>();

    public DemoFormViewPagerAdapter(Context context, ArrayList<Integer> images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view ==((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.demo_form_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.image);
        TextView textView=(TextView)itemView.findViewById(R.id.text);

        imageView.setImageResource(images.get(position));
        textView.setText("FORM "+ String.valueOf(position+1));


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout) object);
    }
}
