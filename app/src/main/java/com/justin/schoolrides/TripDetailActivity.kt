package com.justin.schoolrides

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.justin.schoolrides.databinding.ActivityTripDetailBinding
import com.justin.schoolrides.databinding.ActivityTripsBinding

class TripDetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityTripDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTripDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}