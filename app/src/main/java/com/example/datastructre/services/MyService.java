package com.example.datastructre.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public class MyService extends Service {


    private static final String TAG = "MyService";

    private final IBinder mBinder = new MyBinder();
    private Boolean mIsPaused;
    private int mProgress, mMaxValue;
    private Handler mHandler;


    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
        mProgress = 0;
        mIsPaused = true;
        mMaxValue = 5000;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    public void pausePretendLongRunningTask(){
        mIsPaused = true;
    }

    public void unPausePretendLongRunningTask(){
        mIsPaused = false;
        startPretendLongRunningTask();
    }

    private void startPretendLongRunningTask() {
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(mProgress >= mMaxValue || mIsPaused){
                    Log.d(TAG, "run: removing callbacks");
                    mHandler.removeCallbacks(this); // remove callbacks from runnable
                    pausePretendLongRunningTask();
                }
                else{
                    Log.d(TAG, "run: progress: " + mProgress);
                    mProgress += 100; // increment the progress
                    mHandler.postDelayed(this, 100); // continue incrementing
                }
            }
        };
        mHandler.postDelayed(runnable, 100);
    }

    public class MyBinder extends Binder {

       public MyService  getService() {
            return MyService.this;
        }
    }

    public Boolean getIsPaused(){
        return mIsPaused;
    }

    public int getProgress(){
        return mProgress;
    }

    public int getMaxValue(){
        return mMaxValue;
    }

    public void resetTask(){
        mProgress = 0;
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        Log.d(TAG, "onTaskRemoved: called.");
        stopSelf();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: called.");
    }
}
