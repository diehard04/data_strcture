package com.example.datastructre.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.datastructre.R
import com.example.datastructre.databinding.FragmentHomeBinding
import com.example.datastructre.services.MyService
import com.example.datastructre.services.MyService.MyBinder


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val TAG = "MainActivity"

    // UI Components
    private var mProgressBar: ProgressBar? = null
    private var mTextView: TextView? = null
    private var mButton: Button? = null

    // Vars
    private var mService: MyService? = null
    private var mViewModel: HomeViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        mProgressBar = root.findViewById(R.id.progresss_bar);
        mTextView = root.findViewById(R.id.text_view);
        mButton = root.findViewById(R.id.toggle_updates);

        mButton?.setOnClickListener {
            toggleUpdates()
        }
        setObservers()
        return root
    }

    private fun setObservers() {
        mViewModel?.getBinder()?.observe(viewLifecycleOwner, object : Observer<MyBinder?> {
           override fun onChanged(@Nullable myBinder: MyBinder?) {
                if (myBinder == null) {
                    Log.d(TAG, "onChanged: unbound from service")
                } else {
                    Log.d(TAG, "onChanged: bound to service.")
                    mService = myBinder.service
                }
            }
        })
        mViewModel?.getIsProgressBarUpdating()?.observe(viewLifecycleOwner, object : Observer<Boolean?> {
            override fun onChanged(aBoolean: Boolean?) {
                val handler = Handler()
                val runnable: Runnable = object : Runnable {
                    override fun run() {
                        if (mViewModel!!.getIsProgressBarUpdating()?.value == true) {
                            if (mViewModel!!.getBinder()?.value != null) { // meaning the service is bound
                                if (mService!!.progress == mService!!.maxValue) {
                                    mViewModel?.setIsProgressBarUpdating(false)
                                }
                                mProgressBar!!.progress = mService!!.progress
                                mProgressBar!!.max = mService!!.maxValue
                                val progress = (100 * mService!!.progress / mService!!.maxValue).toString() + "%"
                                mTextView!!.text = progress
                            }
                            handler.postDelayed(this, 100)
                        } else {
                            handler.removeCallbacks(this)
                        }
                    }
                }

                // control what the button shows
                if (aBoolean == true) {
                    mButton!!.text = "Pause"
                    handler.postDelayed(runnable, 100)
                } else {
                    if (mService!!.progress == mService!!.maxValue) {
                        mButton!!.text = "Restart"
                    } else {
                        mButton!!.text = "Start"
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        startService()
    }

    private fun startService() {
        val intent = Intent(context, MyService::class.java)
        context?.startService(intent)
        bindService()
    }

    private fun bindService() {
        val serviceBindIntent = Intent(context, MyService::class.java)
        context?.bindService(serviceBindIntent, mViewModel?.getServiceConnection()!!, Context.BIND_AUTO_CREATE);
    }

    private fun toggleUpdates() {
        if (mService != null) {
            if (mService!!.progress == mService!!.maxValue) {
                mService?.resetTask()
                mButton!!.text = "Start"
            } else {
                if (mService!!.isPaused) {
                    mService!!.unPausePretendLongRunningTask()
                    mViewModel?.setIsProgressBarUpdating(true)
                } else {
                    mService!!.pausePretendLongRunningTask()
                    mViewModel?.setIsProgressBarUpdating(false)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}