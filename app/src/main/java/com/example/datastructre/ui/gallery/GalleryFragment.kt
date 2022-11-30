package com.example.datastructre.ui.gallery

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.datastructre.BuildConfig
import com.example.datastructre.R
import com.example.datastructre.databinding.FragmentGalleryBinding
import com.example.datastructre.foregroundservice.SampleForegroundService

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    companion object{
        const val  ACTION_STOP_FOREGROUND = "${BuildConfig.APPLICATION_ID}.stopforeground"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        root.findViewById<View>(R.id.btn_start)?.setOnClickListener {
            context?.startService(Intent(context, SampleForegroundService::class.java))
            updateTextStatus(root)
        }
        root.findViewById<View>(R.id.btn_stop)?.setOnClickListener {
            val intentStop = Intent(context, SampleForegroundService::class.java)
            intentStop.action = ACTION_STOP_FOREGROUND
            context?.startService(intentStop)
            Handler().postDelayed({
                updateTextStatus(root)
            },100)
        }
        updateTextStatus(root)
        return root
    }

    private fun updateTextStatus(root: View) {
        if(isMyServiceRunning(SampleForegroundService::class.java)){
            root.findViewById<TextView>(R.id.txt_service_status)?.text = "Service is Running"
        }else{
            root.findViewById<TextView>(R.id.txt_service_status)?.text = "Service is NOT Running"
        }
    }


    private fun isMyServiceRunning(serviceClass: Class<*>): Boolean {
        try {
            val manager = context?.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            for (service in manager.getRunningServices(
                Int.MAX_VALUE
            )) {
                if (serviceClass.name == service.service.className) {
                    return true
                }
            }
        } catch (e: Exception) {
            return false
        }
        return false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}