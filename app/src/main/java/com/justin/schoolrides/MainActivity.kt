package com.justin.schoolrides

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.navigation.NavigationView
import com.justin.schoolrides.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    lateinit var binding: ActivityMainBinding
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

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

//        binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, GravityCompat.END)
//        binding.navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
//            Log.i(ContentValues.TAG, "onNavigationItemSelected: " + item.itemId)
//
//            when (item.itemId) {
//                R.id.profile -> {
//                    val intentProfile =
//                        Intent(this@MainActivity, ParentProfileActivity::class.java)
//                    startActivity(intentProfile.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.booking -> {
////                    val intentAbout = Intent(this@MainActivity, AboutActivity::class.java)
////                    startActivity(intentAbout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.trips -> {
//                    val intentMyVehicles =
//                        Intent(this@MainActivity, TripsActivity::class.java)
//                    startActivity(intentMyVehicles.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
//                    return@OnNavigationItemSelectedListener true
//                }
//                R.id.logout -> {
////                    editor.clear()
////                    editor.apply()
////                    val intentLogout = Intent(this@MainActivity, MainActivity::class.java)
////                    startActivity(intentLogout.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
////                    finish()
//                    return@OnNavigationItemSelectedListener true
//
//                }
//            }
//            binding.drawerLayout.closeDrawer(GravityCompat.START)
//            Log.i(ContentValues.TAG, "onNavigationItemSelected: nothing clicked")
//            false
//        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

//        direction()
        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

//    private fun direction() {
////        val queue = Volley.newRequestQueue(this)
//        val url = Uri.parse("https://maps.googleapis.com/maps/api/directions/json")
//            .buildUpon()
//            .appendQueryParameter("destination", "-6.9218571, 107.6048254")
//            .appendQueryParameter("origin", "-6.9249233, 107.6345122")
//            .appendQueryParameter("mode", "driving")
//            .appendQueryParameter("key", "AIzaSyAj6AMcyvJAN7YGP4MDdSztGk_x3DBxfm0")
//            .toString()
//        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
//            { response ->
//                try {
//                    val status = response.getString("status")
//                    if (status == "OK") {
//                        val routes = response.getJSONArray("routes")
//                        var points: ArrayList<LatLng?>
//                        var polylineOptions: PolylineOptions? = null
//                        for (i in 0 until routes.length()) {
//                            points = ArrayList()
//                            polylineOptions = PolylineOptions()
//                            val legs = routes.getJSONObject(i).getJSONArray("legs")
//                            for (j in 0 until legs.length()) {
//                                val steps = legs.getJSONObject(j).getJSONArray("steps")
//                                for (k in 0 until steps.length()) {
//                                    val polyline = steps.getJSONObject(k).getJSONObject("polyline")
//                                        .getString("points")
//                                    val list: List<LatLng> = decodePoly(polyline)
//                                    for (l in list.indices) {
//                                        val position = LatLng(list[l].latitude, list[l].longitude)
//                                        points.add(position)
//                                    }
//                                }
//                            }
//                            polylineOptions.addAll(points)
//                            polylineOptions.width(10f)
//                            polylineOptions.color(
//                                ContextCompat.getColor(
//                                    this@MapsActivity,
//                                    R.color.purple_500
//                                )
//                            )
//                            polylineOptions.geodesic(true)
//                        }
//                        mMap.addPolyline(polylineOptions!!)
//                        mMap.addMarker(
//                            MarkerOptions().position(LatLng(-6.9249233, 107.6345122))
//                                .title("Point 1")
//                        )
//                        mMap.addMarker(
//                            MarkerOptions().position(LatLng(-6.9218571, 107.6048254))
//                                .title("Point 2")
//                        )
//                        val bounds = LatLngBounds.Builder()
//                            .include(LatLng(-6.9249233, 107.6345122))
//                            .include(LatLng(-6.9218571, 107.6048254)).build()
//                        val point = Point()
//                        windowManager.defaultDisplay.getSize(point)
//                        mMap.animateCamera(
//                            CameraUpdateFactory.newLatLngBounds(
//                                bounds,
//                                point.x,
//                                150,
//                                30
//                            )
//                        )
//                    }
//                } catch (e: JSONException) {
//                    e.printStackTrace()
//                }
//            }) { }
//        val retryPolicy: RetryPolicy = DefaultRetryPolicy(
//            30000,
//            DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
//        )
//        jsonObjectRequest.retryPolicy = retryPolicy
//        queue.add(jsonObjectRequest)
//    }
//
//    private fun decodePoly(encoded: String): List<LatLng> {
//        val poly: MutableList<LatLng> = java.util.ArrayList()
//        var index = 0
//        val len = encoded.length
//        var lat = 0
//        var lng = 0
//        while (index < len) {
//            var b: Int
//            var shift = 0
//            var result = 0
//            do {
//                b = encoded[index++].code - 63
//                result = result or (b and 0x1f shl shift)
//                shift += 5
//            } while (b >= 0x20)
//            val dlat = if (result and 1 != 0) (result shr 1).inv() else result shr 1
//            lat += dlat
//            shift = 0
//            result = 0
//            do {
//                b = encoded[index++].code - 63
//                result = result or (b and 0x1f shl shift)
//                shift += 5
//            } while (b > 0x20)
//            val dlng = if (result and 1 != 0) (result shr 1).inv() else result shr 1
//            lng += dlng
//            val p = LatLng(lat.toDouble() / 1E5, lng.toDouble() / 1E5)
//            poly.add(p)
//        }
//        return poly
//    }
}