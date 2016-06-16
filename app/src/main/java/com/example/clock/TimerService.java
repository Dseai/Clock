package com.example.clock;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.IBinder;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2016/6/8.
 */

public class TimerService extends Service{
    private Timer timer;
    //格式化时间
    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    @Override
    public IBinder onBind(Intent arg0){
        return null;
    }
    @Override
    public void onCreate(){
        super.onCreate();
        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                updateViews();
            }
        },0,1000);

    }
    private void updateViews(){
        String time=sdf.format(new Date());
        RemoteViews rv=new RemoteViews(getPackageName(),R.layout.widget);
        rv.setTextViewText(R.id.tv,time);
        AppWidgetManager manager=AppWidgetManager.getInstance(getApplicationContext());
        ComponentName cn=new ComponentName(getApplicationContext(),WidgetProvider.class);
        manager.updateAppWidget(cn,rv);

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        timer=null;
    }
}
