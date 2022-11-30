package com.example.datastructre;

import android.app.Application;
import android.content.Intent;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public class MyApplication extends Application {

    public void onCreate() {
        // Setup handler for uncaught exceptions.
        super.onCreate();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                handleUncaughtException(thread, e);
            }
        });
    }

    public void handleUncaughtException (Thread thread, Throwable e) {
        e.printStackTrace(); // not all Android versions will print the stack trace automatically
        Intent intent = new Intent ();
        intent.setAction ("com.example.datastructre.SEND_LOG"); // see step 5.
        intent.setFlags (Intent.FLAG_ACTIVITY_NEW_TASK); // required when starting from Application
        startActivity (intent);

        System.exit(1); // kill off the crashed app
    }
}