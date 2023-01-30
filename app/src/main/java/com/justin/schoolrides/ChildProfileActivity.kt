package com.justin.schoolrides

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.justin.schoolrides.databinding.ActivityChildProfileBinding

class ChildProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityChildProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChildProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.map.setOnClickListener {
            val intent = Intent(this@ChildProfileActivity, MainActivity::class.java)
            startActivity(intent)
        }


//        val header = binding.navView.getHeaderView(0)
//        header.firstName.text = firstNameHeader.toString()
//        header.lastName.text = lastNameHeader.toString()
//        header.email.text = emailHeader.toString()
//        Picasso.get()
//            .load(profileHeader)
//            .fit().centerCrop()
//            .placeholder(R.drawable.user)
//            .error(R.drawable.user)
//            .into(header.profile_image)
//
//        val c: Calendar = Calendar.getInstance()
//        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)
//
//        Log.d("timeOfDay", timeOfDay.toString() + "")
//        if (timeOfDay < 12) {
//            binding.greeting.setText(R.string.morning)
//        }
//        else if (timeOfDay < 16) {
//            binding.greeting.setText(R.string.afternoon)
//        }
//        else if (timeOfDay < 21) {
//            binding.greeting.setText(R.string.evening)
//        }
//        else {
//            binding.greeting.setText(R.string.night)
//        }
//
//        if (firstNameHeader != "") {
//            binding.name.text = ", $firstNameHeader"
//        }

        //        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.START)
        binding.nav.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }
        binding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            Log.i(ContentValues.TAG, "onNavigationItemSelected: " + item.itemId)

            when (item.itemId) {
                R.id.profile -> {
                    val intentProfile =
                        Intent(this@ChildProfileActivity, ParentProfileActivity::class.java)
                    startActivity(intentProfile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.childrenProfile -> {
//                    val intentAbout = Intent(this@ChildProfileActivity, AboutActivity::class.java)
//                    startActivity(intentAbout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.trips -> {
                    val intentMyVehicles =
                        Intent(this@ChildProfileActivity, TripsActivity::class.java)
                    startActivity(intentMyVehicles.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.map -> {
                    val intentMyVehicles =
                        Intent(this@ChildProfileActivity, MainActivity::class.java)
                    startActivity(intentMyVehicles.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    return@OnNavigationItemSelectedListener true
                }
                R.id.logout -> {
//                    editor.clear()
//                    editor.apply()
//                    val intentLogout = Intent(this@ChildProfileActivity, MainActivity::class.java)
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