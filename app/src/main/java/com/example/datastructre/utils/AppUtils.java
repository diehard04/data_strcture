package com.example.datastructre.utils;

import android.Manifest;
import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Dipak Kumar Mehta on 11/30/2022.
 */
public class AppUtils {

    private static final String TAG = AppUtils.class.getSimpleName();

    public static boolean isValidEmail(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static void hideSoftKeyboard(Activity activity) {
        View focusedView = activity.getCurrentFocus();
        if (focusedView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }

    public static InputFilter doNotAllowedSmileyAndSpecialCharFilter(final Boolean canAllowSpace) {
        InputFilter filter = new InputFilter() {
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                for (int i = start; i < end; i++) {
                    if (source.toString().matches("[a-zA-Z0-9 ,._]+")) {
                        if (!canAllowSpace && Character.isSpaceChar(source.charAt(i))) {
                            return "";
                        } else {
                            return source;
                        }
                    }
                }
                return "";
            }
        };
        return filter;
    }

    public static boolean isDigit(String text) {
        boolean isDigit = true;
        if (!TextUtils.isEmpty(text)) {
            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    isDigit = false;
                    break;
                }
            }
        } else {
            isDigit = false;
        }
        return isDigit;
    }

    public static boolean isNumber(String text) {
        if (!TextUtils.isEmpty(text)) {
            Pattern pattern = Pattern.compile("^(([0-9]*)|(([0-9]*)\\.([0-9]*)))$");
            return pattern.matcher(text).matches();
        }
        return true;
    }

    /**
     * show dialog
     *
     * @param title               title for dialog
     * @param message             message for particular permission
     * @param dialogClickListener dialog click listener
     */
    public static AlertDialog showDialog(Context context, String title, String message, String positiveButton, final OnDialogClickListener dialogClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        if (dialogClickListener != null) {
                            dialogClickListener.onDialogClick(dialog, OnDialogClickListener.BUTTON_POSITIVE);
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (dialogClickListener != null) {
                            dialogClickListener.onDialogClick(dialog, OnDialogClickListener.BUTTON_NEGATIVE);
                        }
                    }
                });
        return builder.show();
    }

    /**
     * show dialog
     *
     * @param title               title for dialog
     * @param message             message for particular permission
     * @param dialogClickListener dialog click listener
     */
    public static AlertDialog.Builder getDialog(Context context, String title, String message, String positiveButton, final OnDialogClickListener dialogClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        if (dialogClickListener != null) {
                            dialogClickListener.onDialogClick(dialog, OnDialogClickListener.BUTTON_POSITIVE);
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        if (dialogClickListener != null) {
                            dialogClickListener.onDialogClick(dialog, OnDialogClickListener.BUTTON_NEGATIVE);
                        }
                    }
                });
        return builder;
    }

    public static void openBluetoothSetting(AppCompatActivity activity, int requestCode) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        activity.startActivityForResult(intent, requestCode);
    }

    public static void onBluetooth(Context context) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Log.e(TAG, "Bluetooth adapter is null");
            return;
        }
        if (!bluetoothAdapter.isEnabled()) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            bluetoothAdapter.enable();
        }
    }

    public static void openLocationSetting(AppCompatActivity activity, int requestCode) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void openLocationSetting(Fragment fragment, int requestCode) {
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void openBluetoothSetting(Fragment fragment, int requestCode) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        fragment.startActivityForResult(intent, requestCode);
    }

    public static void openAddContact(Fragment fragment, int requestCode) {
        Intent insertIntent = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);
        // Sets the MIME type to match the Contacts Provider
        insertIntent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        // Sets the special extended data for navigation
        insertIntent.putExtra("finishActivityOnSaveCompleted", true);
        if (insertIntent.resolveActivity(fragment.getContext().getPackageManager()) != null) {
            fragment.startActivityForResult(insertIntent, requestCode);
        }
    }

    public static boolean isLocationEnabled(Context context) {
        int locationMode = 0;
        String locationProviders;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);

            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }

    public static AlertDialog showListDialog(Context context, String title, ArrayList<String> itemList, final DialogInterface.OnClickListener dialogClickListener) {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, itemList);

        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setCancelable(false)
                .setTitle(title)
                .setAdapter(arrayAdapter, dialogClickListener)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        return builder.show();
    }

    public static boolean isServiceRunning(Context context, Class<?> serviceClass) {
        String serviceClassName = serviceClass.getPackage().getName() + "." + serviceClass.getSimpleName();
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        final List<ActivityManager.RunningServiceInfo> services = activityManager.getRunningServices(Integer.MAX_VALUE);
        for (ActivityManager.RunningServiceInfo runningServiceInfo : services) {
            if (runningServiceInfo.service.getClassName().equals(serviceClassName)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAppRunning(Context context) {
        final ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            return false;
        }
        final List<ActivityManager.RunningAppProcessInfo> processInfoList = activityManager.getRunningAppProcesses();
        if (processInfoList != null) {
            for (ActivityManager.RunningAppProcessInfo processInfo : processInfoList) {
                Log.e(TAG, "isAppRunning: " + processInfo.importance + " = " + processInfo.lru);
                if (processInfo.processName.equals(context.getPackageName())) {
                    return processInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
                }
            }
        }
        return false;
    }

    // Check App Download from Playstore or not?
    public boolean isStoreVersion(Context context) {
        boolean result = false;

        try {
            String installer = context.getPackageManager().getInstallerPackageName(context.getPackageName());
            result = !TextUtils.isEmpty(installer);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return result;
    }

}