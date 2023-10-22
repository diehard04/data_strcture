package com.example.datastructre.utils;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.datastructre.R;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */

public class PermissionMainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_CAMERA_PERMISSION = 123;
    private static final int REQUEST_CODE_PERMISSION_SETTING = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestPermission();
    }

    private void requestPermission() {
        if (PermissionHelper.hasPermission(this, Manifest.permission.CAMERA)) {
            onPermissionGranted();
        } else {
            PermissionHelper.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (PermissionHelper.hasPermissions(this, permissions)) {
            onPermissionGranted();
        } else {
            if (PermissionHelper.shouldShowPermissionRationale(this, permissions)) {
                showPermissionRationale();
            } else {
                onPermissionDenied();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PERMISSION_SETTING) {
            if (PermissionHelper.hasPermission(this, Manifest.permission.CAMERA)) {
                onPermissionGranted();
            }
        }
    }

    private void showPermissionRationale() {
        PermissionHelper.showDialog(this, "Permission", "App require camera permission for detect face.", "OK", new PermissionHelper.OnDialogCloseListener() {
            @Override
            public void onDialogClose(DialogInterface dialog, int buttonType) {
                if (buttonType == PermissionHelper.OnDialogCloseListener.TYPE_POSITIVE) {
                    PermissionHelper.requestPermissions(PermissionMainActivity.this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA_PERMISSION);
                }
            }
        });
    }

    private void onPermissionDenied() {
        PermissionHelper.showDialog(this, "Permission Setting", "Grant camera permission from setting screen.", "OK", new PermissionHelper.OnDialogCloseListener() {
            @Override
            public void onDialogClose(DialogInterface dialog, int buttonType) {
                if (buttonType == PermissionHelper.OnDialogCloseListener.TYPE_POSITIVE) {
                    PermissionHelper.openSettingScreen(PermissionMainActivity.this, REQUEST_CODE_PERMISSION_SETTING);
                }
            }
        });
    }

    private void onPermissionGranted() {
        // code after permission granted
    }

}