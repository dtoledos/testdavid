package com.demo.app.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.demo.app.R;
import com.demo.app.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.Calendar;


public class CalendarActivity extends AppCompatActivity implements OnClickListener {
    private Button bt_save;
    private TextView tv_time,tv_date_birth;
    private static final String CERO = "0";
    private boolean isSelectedDate=false,isSelectedTime=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_calendar);

        RelativeLayout rl_date= findViewById(R.id.rl_date);
        rl_date.setOnClickListener(this);

        RelativeLayout rl_time= findViewById(R.id.rl_time);
        rl_time.setOnClickListener(this);

        bt_save= findViewById(R.id.bt_save);
        bt_save.setOnClickListener(this);

        tv_time= findViewById(R.id.tv_time);
        tv_date_birth= findViewById(R.id.tv_date_birth);

    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.rl_date:
                datePicker();
                break;
            case R.id.rl_time:
                timePicker();
                break;
            case R.id.bt_save:
                nextScreen();
                break;
        }
    }

    private void nextScreen(){

        if (!isSelectedTime)
        {
            alertbox("",getString(R.string.label_hour_error), CalendarActivity.this);
        }
        else if (!isSelectedDate)
        {
            alertbox("",getString(R.string.label_date_error), CalendarActivity.this);
        }
        else
        {
            Intent intent = new Intent(CalendarActivity.this, MainScreen.class);
            startActivity(intent);
        }
    }


    private void datePicker(){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int style= R.style.TimePickerTheme_1;

        DatePickerDialog pickerYear = new DatePickerDialog(this, style,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                tv_date_birth.setText(""+month+"/"+dayOfMonth+"/"+year);
                isSelectedDate=true;

            }
            //Estos valores deben ir en ese orden, de lo contrario no mostrara la fecha actual
            /**
             *También puede cargar los valores que usted desee
             */
        },year, month , day);
        //Muestro el widget
        pickerYear.show();

    }


    private void timePicker()
    {
        Calendar c = Calendar.getInstance();
        final int hours = c.get(Calendar.HOUR);
        final int hours24 = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        int style= R.style.TimePickerTheme_1;

        TimePickerDialog pickerHour = new TimePickerDialog(this, style, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String minutoFormat = (minute < 10)? String.valueOf(CERO + minute):String.valueOf(minute);
                isSelectedTime=true;
                String format;
                if (hourOfDay == 0) {
                    hourOfDay += 12;
                    format = "am";
                }
                else if (hourOfDay == 12) {
                    format = "pm";
                }
                else if (hourOfDay > 12) {
                    hourOfDay -= 12;
                    format = "pm";
                }
                else {
                    format = "am";
                }

                String horaFormat = (hourOfDay < 10)? String.valueOf(CERO + hourOfDay):String.valueOf(hourOfDay);

                tv_time.setText(""+horaFormat+":"+minutoFormat+" "+format);
            }
        }, hours24, minute, false);
        pickerHour.show();
    }


    public void alertbox(String title, String message, Activity activiy) {
        final AlertDialog alertDialog = new AlertDialog.Builder(activiy).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        //alertDialog.setIcon(R.drawable.dashboard);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();
            } });
        alertDialog.show();
    }
}
