package com.demo.app.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;

import com.demo.app.R;

import java.util.ArrayList;


public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<String> paymentData;
//    private String description;

    public ViewPagerAdapter(Context mContext, ArrayList<String> lstLocationPic) {
        this.mContext = mContext;
        this.paymentData =lstLocationPic;
       // this.description=description;
       // this.locationBeanData=locationBeanData;
    }

    @Override
    public int getCount() {
        return paymentData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        //return view == ((LinearLayout) object);
        //return view == ((FrameLayout) object);
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.pager_item1, container, false);

        TextView tv_pager= itemView.findViewById(R.id.tv_pager);
        String txt= paymentData.get(position);
        tv_pager.setText(txt);


        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //container.removeView((FrameLayout) object);
        container.removeView((RelativeLayout) object);
    }
}