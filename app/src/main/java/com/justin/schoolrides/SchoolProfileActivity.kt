package com.justin.schoolrides

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.justin.schoolrides.databinding.ActivitySchoolProfileBinding

class SchoolProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivitySchoolProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySchoolProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
        //        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.START)
        binding.nav.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            Log.i(ContentValues.TAG, "onNavigationItemSelected: " + item.itemId)

            when (item.itemId) {
                R.id.profile -> {
                    val intentProfile =
                        Intent(this@SchoolProfileActivity, SchoolProfileActivity::class.java)
                    startActivity(intentProfile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.childrenProfile -> {
//                    val intentAbout = Intent(this@SchoolProfileActivity, AboutActivity::class.java)
//                    startActivity(intentAbout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.trips -> {
                    val intentMyVehicles =
                        Intent(this@SchoolProfileActivity, TripsActivity::class.java)
                    startActivity(intentMyVehicles.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.map -> {
                    val intentMyVehicles =
                        Intent(this@SchoolProfileActivity, MainActivity::class.java)
                    startActivity(intentMyVehicles.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.logout -> {
//                    editor.clear()
//                    editor.apply()
//                    val intentLogout = Intent(this@SchoolProfileActivity, MainActivity::class.java)
//                    startActivity(intentLogout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
//                    finish()
                    return@OnNavigationItemSelectedListener true

                }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            Log.i(ContentValues.TAG, "onNavigationItemSelected: nothing clicked")
            false
        })
    }
}