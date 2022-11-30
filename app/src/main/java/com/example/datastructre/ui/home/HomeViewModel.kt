package com.example.datastructre.ui.home

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.datastructre.services.MyService.MyBinder


class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val TAG = "MainActivityViewModel"

    private val mIsProgressBarUpdating = MutableLiveData<Boolean>()
    private val mBinder = MutableLiveData<MyBinder?>()


    // Keeping this in here because it doesn't require a context
    private val serviceConnection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, iBinder: IBinder) {
            Log.d(TAG, "ServiceConnection: connected to service.")
            // We've bound to MyService, cast the IBinder and get MyBinder instance
            val binder = iBinder as MyBinder
            mBinder.postValue(binder)
        }

        override fun onServiceDisconnected(arg0: ComponentName) {
            Log.d(TAG, "ServiceConnection: disconnected from service.")
            mBinder.postValue(null)
        }
    }


    fun getServiceConnection(): ServiceConnection? {
        return serviceConnection
    }

    fun getBinder(): LiveData<MyBinder?>? {
        return mBinder
    }


    fun getIsProgressBarUpdating(): LiveData<Boolean>? {
        return mIsProgressBarUpdating
    }

    fun setIsProgressBarUpdating(isUpdating: Boolean) {
        mIsProgressBarUpdating.postValue(isUpdating)
    }

}