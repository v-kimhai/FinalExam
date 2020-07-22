package com.example.vannakimhai.Activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.vannakimhai.R

class StartupActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000 //3s

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)
        val prefs = getSharedPreferences("isStarted", Context.MODE_PRIVATE)
        val isStarted = prefs.getBoolean("isStarted", false)
        Handler().postDelayed({
                startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
