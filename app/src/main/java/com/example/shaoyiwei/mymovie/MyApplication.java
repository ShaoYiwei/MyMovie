package com.example.shaoyiwei.mymovie;

import android.app.Application;
import android.os.Process;
import android.support.v7.app.AppCompatDelegate;
import android.widget.Toast;

import com.example.shaoyiwei.mymovie.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


/**
 * Created by shaoyiwei on 2016/11/30.
 */

public class MyApplication extends Application {

    public static final String TAG = "MyApplication";

    public static final boolean DEBUG = true;

    public static  MyApplication myApplication;

    public static int mainTid;

    public static List<BaseActivity> activityList;

    //设置日夜模式
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        activityList = new ArrayList<>();
        mainTid = Process.myTid();
        Toast.makeText(this,TAG,Toast.LENGTH_LONG).show();
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public static int getMainTid() {
        return mainTid;
    }

    public static List<BaseActivity> getActivityList() {
        return activityList;
    }

    /**
     * 添加一个Activity
     * @param activity
     */
    public void addActivity(BaseActivity activity){
        activityList.add(activity);
    }

    /**
     * 移除一个Activity
     * @param activity
     */
    public void removeActivity(BaseActivity activity){
        if (activity != null) {
            activity.finish();
        }
        activityList.remove(activity);
    }

    /**
     * 清空所有Activity
     */
    public void clearAcitivitys(){
        ListIterator<BaseActivity> iterator = activityList.listIterator();
        BaseActivity activity;
        while (iterator.hasNext()){
            activity = iterator.next();
            if (activity != null) {
                activity.finish();
            }
        }
        activityList.clear();
    }
}
