package com.example.datastructre.delaytextwatcher;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public abstract class TypingTextWatcher implements TextWatcher {

    private final long DELAY = 1000; // milliseconds
    private Handler handler = new Handler();
    private boolean isTyping = false;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            isTyping = false;
            onTyping(false);
        }
    };

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!isTyping) {
            onTyping(true);
            isTyping = true;
        }
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, DELAY);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    protected abstract void onTyping(boolean isTyping);

}