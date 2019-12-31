package com.imyyq.systemuivisibility

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val flags = intent.getIntExtra("flags", View.SYSTEM_UI_FLAG_VISIBLE)
        Log.i("ResultActivity", "onCreate: $flags")
        window.decorView.systemUiVisibility = flags

        val statusBarBgColor = intent.getIntExtra("statusBarBgColor", 0)
        if (statusBarBgColor != 0)
            window.statusBarColor = statusBarBgColor

        val navBarBgColor = intent.getIntExtra("navBarBgColor", 0)
        if (navBarBgColor != 0)
            window.navigationBarColor = navBarBgColor

        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT
    }
}