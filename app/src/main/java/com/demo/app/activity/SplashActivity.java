package com.demo.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.demo.app.R;
import com.demo.app.adapter.ViewPagerAdapter;

import java.util.ArrayList;


public class SplashActivity extends AppCompatActivity implements OnClickListener {
    private ViewPagerAdapter mAdapter;
    private ViewPager intro_images;
    private Button bt_skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_splash_screen);

        intro_images = findViewById(R.id.pager_introduction);
        bt_skip= findViewById(R.id.bt_skip);

        //RelativeLayout rl_container= findViewById(R.id.rl_main);
        //ImageView iv_background= findViewById(R.id.iv_background);
        //ImageView iv_title= findViewById(R.id.iv_title);

        bt_skip.setOnClickListener(this);
        /*iv_background.setOnClickListener(this);
        intro_images.setOnClickListener(this);*/

        ArrayList<String> arrayLst= new ArrayList<String>();
        arrayLst.add(getString(R.string.label_pager0));
        arrayLst.add(getString(R.string.label_pager1));
        arrayLst.add(getString(R.string.label_pager2));
        arrayLst.add(getString(R.string.label_pager3));

        mAdapter = new ViewPagerAdapter(this, arrayLst);
        intro_images.setAdapter(mAdapter);
        loadScreen();
    }

    private void nextScreen()
    {
        int currPos=intro_images.getCurrentItem();
        intro_images.setCurrentItem(currPos+1);
        bt_skip.setVisibility(View.VISIBLE);
    }



    private void loadScreen()
    {
        new Thread()
        {
            @Override
            public void run()
            {
                super.run();
                try
                {

                    sleep(2000);
                    // helper.close();
                    SplashActivity.this.runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            //pd.dismiss();
                            // updateUI();
                            handlerProgram.sendEmptyMessage(0);
                        }
                    });
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }.start();
    }


    protected Handler handlerProgram = new Handler() {
        //@Override
        public void handleMessage(Message msg) {

            try {
               startApp();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    };


    protected void startApp() {
        nextScreen();
    }

    private void nextPage()
    {
        Intent intent = new Intent(SplashActivity.this, CalendarActivity.class);
        startActivity(intent);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.bt_skip:
                nextPage();
                break;

        }
    }
}
