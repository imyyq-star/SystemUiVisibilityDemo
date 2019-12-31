package com.imyyq.systemuivisibility

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mLopProfile.tag = View.SYSTEM_UI_FLAG_LOW_PROFILE

        mHideNav.tag = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        mFullscreen.tag = View.SYSTEM_UI_FLAG_FULLSCREEN

        mLayoutStable.tag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        mLayoutHideNav.tag = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        mLayoutFullscreen.tag = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        mImmersive.tag = View.SYSTEM_UI_FLAG_IMMERSIVE
        mImmersiveSticky.tag = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mLightStatusBar.tag = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            mLightStatusBar.tag = View.SYSTEM_UI_FLAG_VISIBLE
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mLightNavBar.tag = View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
        } else {
            mLightStatusBar.tag = View.SYSTEM_UI_FLAG_VISIBLE
        }

        mNavBarBg.tag = Color.WHITE
        mStatusBarBg.tag = Color.WHITE
    }

    fun onResult(v: View) {
        var flags = View.SYSTEM_UI_FLAG_VISIBLE
        for (child in mLayout.children) {
            if (child.id == R.id.view) break

            if (child is CheckBox) {
                flags = flags or if (child.isChecked) child.tag as Int else 0
            }
        }
        Log.i("MainActivity", "onResult: $flags")
        startActivity(
            Intent(this, ResultActivity::class.java)
                .putExtra("flags", flags)
                .putExtra("navBarBgColor", if (mNavBarBg.isChecked) mNavBarBg.tag as Int else 0)
                .putExtra("statusBarBgColor", if (mStatusBarBg.isChecked) mStatusBarBg.tag as Int else 0)
        )
    }
}
