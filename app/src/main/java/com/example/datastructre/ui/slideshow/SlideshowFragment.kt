package com.example.datastructre.ui.slideshow

import android.app.PendingIntent
import android.app.PendingIntent.CanceledException
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.datastructre.databinding.FragmentSlideshowBinding
import com.google.android.material.snackbar.Snackbar


class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        textView.setOnClickListener {
            val v:View = it
            val lState = SoundService.getState()
            when (lState) {
                MusicConstants.STATE_SERVICE.NOT_INIT -> {
                    if (!NetworkHelper.isInternetAvailable(v.getContext())) {
                        showError(v)
                        return@setOnClickListener
                    }
                    val startIntent = Intent(v.getContext(), SoundService::class.java)
                    startIntent.action = MusicConstants.ACTION.START_ACTION
                    context?.startService(startIntent)
                }
                MusicConstants.STATE_SERVICE.PREPARE, MusicConstants.STATE_SERVICE.PLAY -> {
                    val lPauseIntent = Intent(v.getContext(), SoundService::class.java)
                    lPauseIntent.action = MusicConstants.ACTION.PAUSE_ACTION
                    val lPendingPauseIntent = PendingIntent.getService(
                        v.getContext(),
                        0,
                        lPauseIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                    )
                    try {
                        lPendingPauseIntent.send()
                    } catch (e: CanceledException) {
                        e.printStackTrace()
                    }
                }
                MusicConstants.STATE_SERVICE.PAUSE -> {
                    if (!NetworkHelper.isInternetAvailable(v.getContext())) {
                        showError(v)
                        return@setOnClickListener
                    }
                    val lPauseIntent = Intent(v.getContext(), SoundService::class.java)
                    lPauseIntent.action = MusicConstants.ACTION.PLAY_ACTION
                    val lPendingPauseIntent = PendingIntent.getService(
                        v.getContext(),
                        0,
                        lPauseIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                    )
                    try {
                        lPendingPauseIntent.send()
                    } catch (e: CanceledException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun showError(v: View) {
        Snackbar.make(v, "No internet", Snackbar.LENGTH_LONG).show()
    }
}