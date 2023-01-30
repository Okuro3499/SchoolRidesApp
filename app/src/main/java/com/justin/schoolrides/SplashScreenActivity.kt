package com.justin.schoolrides

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.justin.schoolrides.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    private val splashScreen = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }, splashScreen.toLong())
    }
}