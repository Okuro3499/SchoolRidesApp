package com.justin.schoolrides

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.justin.schoolrides.databinding.ActivityTripsBinding

class TripsActivity : AppCompatActivity() {
    lateinit var binding: ActivityTripsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTripsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.more.setOnClickListener {
            val intent = Intent(this@TripsActivity, TripDetailActivity::class.java)
            startActivity(intent)
        }
    }
}