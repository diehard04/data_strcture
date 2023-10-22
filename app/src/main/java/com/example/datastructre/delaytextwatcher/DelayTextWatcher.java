package com.example.datastructre.delaytextwatcher;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public abstract class DelayTextWatcher implements TextWatcher {

    private final long DELAY = 300; // milliseconds
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            onAfterTextChanged();
        }
    };

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, DELAY);
    }

    protected abstract void onAfterTextChanged();
}