package com.example.datastructre.utils;

import android.content.DialogInterface;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public interface OnDialogClickListener {

    int BUTTON_POSITIVE = 1;
    int BUTTON_NEGATIVE = 2;

    void onDialogClick(DialogInterface dialogInterface, int button);
}
