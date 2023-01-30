package com.justin.schoolrides

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.justin.schoolrides.databinding.ActivityAccountTypeBinding

class AccountTypeActivity : AppCompatActivity() {
    lateinit var binding: ActivityAccountTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.parent.setOnClickListener {
            val intent = Intent(this@AccountTypeActivity, ParentProfileActivity::class.java)
            startActivity(intent)
        }

        binding.driver.setOnClickListener {
            val intent = Intent(this@AccountTypeActivity, DriverProfileActivity::class.java)
            startActivity(intent)
        }

        binding.School.setOnClickListener {
            val intent = Intent(this@AccountTypeActivity, SchoolProfileActivity::class.java)
            startActivity(intent)
        }

    }
}