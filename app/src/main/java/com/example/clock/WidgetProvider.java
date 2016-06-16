package com.example.clock;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2016/6/8.
 */

public class WidgetProvider extends AppWidgetProvider{
    @Override
    public void onDeleted(Context context,int[] appWidgetIds)
    {
        super.onDeleted(context,appWidgetIds);
        //widget从屏幕移除

    }
    @Override
    public void onDisabled(Context context){
        super.onDisabled(context);
        //最后一个widget被从一屏幕移除执行
        context.stopService(new Intent(context,TimerService.class));
    }
    @Override
    public void onEnabled(Context context){
        super.onEnabled(context);
        //第一个widget添加到屏幕执行
        context.startService(new Intent(context,TimerService.class));
    }
    @Override
    public void onReceive(Context context, Intent intent){
        super.onReceive(context,intent);
        //
    }
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
        super.onUpdate(context,appWidgetManager,appWidgetIds);
        //刷新widget
        //removeView和AppWidgetManager

    }

}
