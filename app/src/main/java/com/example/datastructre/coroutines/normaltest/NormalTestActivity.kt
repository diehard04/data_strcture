package com.example.datastructre.coroutines.normaltest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.datastructre.R

class NormalTestActivity : AppCompatActivity() {

    lateinit var counter:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_test)
        counter= findViewById(R.id.number)
    }

    fun updateCounter(view: View) {
        counter.text = "${counter.text.toString().toInt() + 1}"
    }
    fun executeTask(view: View) {
        
    }
}