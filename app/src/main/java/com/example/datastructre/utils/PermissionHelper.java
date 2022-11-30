package com.example.datastructre.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.datastructre.BuildConfig;

import java.util.ArrayList;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public class PermissionHelper {

    public static boolean hasPermission(Context context, String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M
                || ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static boolean hasPermissions(Context context, String[] permissions) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (permissions == null) {
            return false;
        }
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        if (permissions == null) {
            return;
        }

        String[] permissionArray = getNonGrantedPermissions(activity, permissions);
        if (permissionArray != null) {
            ActivityCompat.requestPermissions(activity, permissionArray, requestCode);
        }
    }


    public static void requestPermissions(Fragment fragment, String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return;
        }
        if (permissions == null) {
            return;
        }

        String[] permissionArray = getNonGrantedPermissions(fragment.getContext(), permissions);
        if (permissionArray != null) {
            fragment.requestPermissions(permissionArray, requestCode);
        }
    }

    private static String[] getNonGrantedPermissions(Context context, String[] permissions) {
        ArrayList<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }
        if (permissionList.size() > 0) {
            String[] permissionArray = new String[permissionList.size()];
            permissionList.toArray(permissionArray);
            return permissionArray;
        }
        return null;
    }

    public static boolean shouldShowPermissionRationale(Activity activity, String[] permissions) {
        if (permissions == null) {
            return false;
        }
        for (String permission : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                return true;
            }
        }
        return false;
    }

    public static boolean shouldShowPermissionRationale(Fragment fragment, String[] permissions) {
        if (permissions == null) {
            return false;
        }
        for (String permission : permissions) {
            if (fragment.shouldShowRequestPermissionRationale(permission)) {
                return true;
            }
        }
        return false;
    }

    public static void showDialog(Context context, String title, String message, String positiveButtonText, final OnDialogCloseListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        listener.onDialogClose(dialogInterface, OnDialogCloseListener.TYPE_POSITIVE);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        listener.onDialogClose(dialogInterface, OnDialogCloseListener.TYPE_NEGATIVE);
                    }
                });
        builder.show();
    }

    public static void openSettingScreen(Activity activity, int requestCode) {
        activity.startActivityForResult(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + BuildConfig.APPLICATION_ID)), requestCode);
    }

    public static void openSettingScreen(Fragment fragment, int requestCode) {
        fragment.startActivityForResult(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.parse("package:" + BuildConfig.APPLICATION_ID)), requestCode);
    }

    public interface OnDialogCloseListener {
        int TYPE_POSITIVE = 1;
        int TYPE_NEGATIVE = -1;

        void onDialogClose(DialogInterface dialog, int buttonType);
    }
}