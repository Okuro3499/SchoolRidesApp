package com.justin.schoolrides

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.justin.schoolrides.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.btSignUp.setOnClickListener{
            val intent = Intent(this@SignUpActivity, AccountTypeActivity::class.java)
            startActivity(intent)
        }

        binding.ltLogin.setOnClickListener{
            val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}