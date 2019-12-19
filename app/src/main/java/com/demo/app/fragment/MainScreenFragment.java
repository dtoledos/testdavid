package com.demo.app.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.app.R;
import com.demo.app.adapter.FeatureAdapter;
import com.demo.app.beans.DataBean;

import java.util.ArrayList;
import java.util.List;


public class MainScreenFragment extends Fragment {
    private LinearLayoutManager horizontalLayoutManager;
    private View view;
    public MainScreenFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main_screen, container, false);
        RecyclerView recyclerFeatures=(RecyclerView) view.findViewById(R.id.recyclerFeatures);
        RecyclerView recyclerTopics=(RecyclerView) view.findViewById(R.id.recyclerTopics);
        RecyclerView recyclerTimeToRead=(RecyclerView) view.findViewById(R.id.recyclerTimeToRead);


        List<DataBean> lstDataBean = new ArrayList<DataBean>();
        DataBean dataBean= new DataBean();
        dataBean.setTitle(getString(R.string.label_lose_focus));
        dataBean.setId(1);
        dataBean.setImage(R.drawable.image1);
        lstDataBean.add(dataBean);

        dataBean= new DataBean();
        dataBean.setTitle(getString(R.string.label_peaceful));
        dataBean.setId(2);
        dataBean.setImage(R.drawable.image2);
        lstDataBean.add(dataBean);


        dataBean= new DataBean();
        dataBean.setTitle(getString(R.string.label_lose_focus));
        dataBean.setId(3);
        dataBean.setImage(R.drawable.image1);
        lstDataBean.add(dataBean);

        dataBean= new DataBean();
        dataBean.setTitle(getString(R.string.label_peaceful));
        dataBean.setId(4);
        dataBean.setImage(R.drawable.image2);
        lstDataBean.add(dataBean);


        List<DataBean> lstDataBeanTopic = new ArrayList<DataBean>();
        DataBean dataBeanTopic= new DataBean();
        dataBeanTopic.setTitle(getString(R.string.label_peace));
        dataBeanTopic.setId(1);
        dataBeanTopic.setImage(R.drawable.image3);
        lstDataBeanTopic.add(dataBeanTopic);

        dataBeanTopic= new DataBean();
        dataBeanTopic.setTitle(getString(R.string.label_balance));
        dataBeanTopic.setId(2);
        dataBeanTopic.setImage(R.drawable.image4);
        lstDataBeanTopic.add(dataBeanTopic);

        dataBeanTopic= new DataBean();
        dataBeanTopic.setTitle(getString(R.string.label_peace));
        dataBeanTopic.setId(2);
        dataBeanTopic.setImage(R.drawable.image3);
        lstDataBeanTopic.add(dataBeanTopic);

        DisplayMetrics dm= new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);

        int iiheightImage=dm.heightPixels;

        double fiiHeightAImage=iiheightImage;
        fiiHeightAImage=fiiHeightAImage*0.28;
        int iheightImage=(int)fiiHeightAImage;


        int widthImage=dm.widthPixels/2;
        double fiiWidthImage=widthImage;
        fiiWidthImage=widthImage*0.95;
        int iWidhtImage=(int)fiiWidthImage;


        List<DataBean> lstTimeToRead = new ArrayList<DataBean>();
        DataBean dataBeanTimeToRead= new DataBean();
        dataBeanTimeToRead.setTitle(getString(R.string.label_5min));
        dataBeanTimeToRead.setId(1);
        dataBeanTimeToRead.setImage(R.drawable.image5);
        lstTimeToRead.add(dataBeanTimeToRead);

        dataBeanTimeToRead= new DataBean();
        dataBeanTimeToRead.setTitle(getString(R.string.label_10min));
        dataBeanTimeToRead.setId(2);
        dataBeanTimeToRead.setImage(R.drawable.image6);
        lstTimeToRead.add(dataBeanTimeToRead);

        dataBeanTimeToRead= new DataBean();
        dataBeanTimeToRead.setTitle(getString(R.string.label_5min));
        dataBeanTimeToRead.setId(3);
        dataBeanTimeToRead.setImage(R.drawable.image5);
        lstTimeToRead.add(dataBeanTimeToRead);


        FeatureAdapter requestLocationAdapter = new FeatureAdapter(this,lstDataBean, getActivity(),iheightImage,iWidhtImage);
        horizontalLayoutManager = new LinearLayoutManager(recyclerFeatures.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerFeatures.setLayoutManager(horizontalLayoutManager);
        recyclerFeatures.setAdapter(requestLocationAdapter );

        FeatureAdapter requestTopicAdapter = new FeatureAdapter(this,lstDataBeanTopic, getActivity(),iheightImage,iWidhtImage);
        horizontalLayoutManager = new LinearLayoutManager(recyclerTopics.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerTopics.setLayoutManager(horizontalLayoutManager);
        recyclerTopics.setAdapter(requestTopicAdapter );

        FeatureAdapter requestTimetoReadAdapter = new FeatureAdapter(this,lstTimeToRead, getActivity(),iheightImage,iWidhtImage);
        horizontalLayoutManager = new LinearLayoutManager(recyclerTimeToRead.getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerTimeToRead.setLayoutManager(horizontalLayoutManager);
        recyclerTimeToRead.setAdapter(requestTimetoReadAdapter );



        return view;
    }

    public void getDetail(int id,String text)
    {

    }

}
