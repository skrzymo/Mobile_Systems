package com.skrzy

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.widget.TextView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ThirdActivity : AppCompatActivity() {

    private var stateName: TextView? = null

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        stateName = findViewById(R.id.activity_third);
        setCurrentStateInTextView("onCreate")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRestart() {
        super.onRestart()
        setCurrentStateInTextView("onRestart")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStart() {
        super.onStart()
        setCurrentStateInTextView("onStart")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        setCurrentStateInTextView("onResume")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onPause() {
        setCurrentStateInTextView("onPause")
        super.onPause()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStop() {
        setCurrentStateInTextView("onStop")
        super.onStop()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onDestroy() {
        setCurrentStateInTextView("onDestroy")
        super.onDestroy()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun setCurrentStateInTextView(state: String) {
        val text = (stateName?.getText().toString() + "[" + getNowTime() + "] ["
                + state + "]\n")
        stateName?.setText(text)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getNowTime(): String {
        val currentDateTime = LocalDateTime.now()
        val now = currentDateTime.format(DateTimeFormatter.ISO_TIME)
        return now
    }
}
