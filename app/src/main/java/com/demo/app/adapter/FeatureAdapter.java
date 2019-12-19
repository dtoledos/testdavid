package com.demo.app.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.demo.app.R;
import com.demo.app.beans.DataBean;
import com.demo.app.fragment.MainScreenFragment;
import java.util.List;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.NearbyHolder>{
    private List<DataBean> list;
    private Context context;
    NearbyHolder holder;
    int position,height,width;
    private MainScreenFragment fragment;



    public FeatureAdapter(MainScreenFragment fragment, List<DataBean> list, Context context, int height, int width) {
        this.list = list;
        this.context = context;
        this.height=height;
        this.width=width;
        this.fragment=fragment;

    }

    public class NearbyHolder extends RecyclerView.ViewHolder{
        protected ImageView profPic;
        protected TextView tv_title;
        protected FrameLayout containedLayout;

        public NearbyHolder(View itemView) {
            super(itemView);
            this.containedLayout = (FrameLayout) itemView.findViewById(R.id.rl_main);
            this.profPic = (ImageView) itemView.findViewById(R.id.iv_main);
            this.tv_title = (TextView) itemView.findViewById(R.id.tv_title);
        }

    }


    @Override
    public NearbyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.feature_rows, null);
        NearbyHolder mh = new NearbyHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(FeatureAdapter.NearbyHolder inHolder, final int positionIn) {
        this.position =positionIn;
        this.holder = inHolder;
        ImageView imageView = (ImageView)holder.containedLayout.findViewById(R.id.iv_main);

        RelativeLayout.LayoutParams paramsContImagen = new RelativeLayout.LayoutParams(width+50, ViewGroup.LayoutParams.MATCH_PARENT);
        paramsContImagen.width = width+50;
        paramsContImagen.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        paramsContImagen.topMargin=10;
        paramsContImagen.bottomMargin=10;
        paramsContImagen.leftMargin=15+20;
        //paramsContImagen.addRule(RelativeLayout.BELOW, R.id.rl_title);
        inHolder.containedLayout.setLayoutParams(paramsContImagen);

        inHolder.containedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  fragment.iconSelected(iconNames.get(position).replace("img_", "").concat(".png"));
                fragment.getDetail(list.get(positionIn).getId(),null);
            }
        });

        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(iwidth, height);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, height);
        //params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        params.width = width;
        params.height =height;

        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        inHolder.tv_title.setText(list.get(position).getTitle());
        inHolder.profPic.setImageResource(list.get(position).getImage());
    }

    @Override
    public long getItemId(int position) {
        return list.size();
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



}
