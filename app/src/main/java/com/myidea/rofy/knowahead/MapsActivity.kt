package com.myidea.rofy.knowahead

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.myidea.rofy.knowahead.firebase.AppFirebase
import com.myidea.rofy.knowahead.loction_util.DatabaseLocation
import com.myidea.rofy.knowahead.loction_util.LocationStore
import com.myidea.rofy.knowahead.loction_util.NewLocationCapture
import kotlinx.android.synthetic.main.activity_maps.*
import java.lang.Exception
import java.util.*

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    object Static {

        var mMapStatic: GoogleMap? = null
        private var marker: Marker? = null

        public var lat: Double = 0.0
        public var lng: Double = 0.0

        public fun updateLocation(lat: Double, lng: Double) {
            println("()()()() NOT UPDATED LOCATION")
            Static.lat = lat
            Static.lng = lng
            if (mMapStatic != null) {
                if (marker != null)
                    marker?.remove()
                println("()()()() UPDATED LOCATION :)")
                val myLatLng = LatLng(lat, lng)
                marker = mMapStatic?.addMarker(MarkerOptions().position(myLatLng).title("My Location"))
                mMapStatic?.moveCamera(CameraUpdateFactory.newLatLngZoom(myLatLng, 20f))
            }
        }

    }

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Setting the on click listener on the marker_button
        // This adds the new location/marker in the marker list on the firebase real time database
        marker_button.setOnClickListener {
            AppFirebase.Static.MARKERS_LIST_DATABASE_REFERENCE.push().setValue(DatabaseLocation(Static.lat, Static.lng))
//            x.child("LAT").setValue(Static.lat)
//            x.child("LNG").setValue(Static.lng)
            Toast.makeText(applicationContext, "Marked loction!", Toast.LENGTH_SHORT).show()
        }

        addAuthorityMarkers()

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

        Static.mMapStatic = googleMap

        NewLocationCapture.mandatoryForGettingLocation(applicationContext)


        // Making changes in the google maps for our own location
//        var myNewLocationLatLng = LatLng(Static.lat, Static.lng)
//        mMap.addMarker(MarkerOptions().position(myNewLocationLatLng).title("My Location"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myNewLocationLatLng, 15f))

//        var myNewLocationLatLng = LatLng(Static.lat, Static.lng)
//        mMap.addMarker(MarkerOptions().position(myNewLocationLatLng).title("My Location"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myNewLocationLatLng, 15f))


//        var timer: Timer = Timer()
//
//
//        val timerTask: TimerTask = object : TimerTask() {
//            override fun run() {
//                var myNewLocationLatLng: LatLng = LatLng(Static.lat, Static.lng)
//                mMap.addMarker(MarkerOptions().position(myNewLocationLatLng).title("My Location"))
//                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myNewLocationLatLng, 15f))
//            }
//        }
//
//
//        MapsActivity.Static.thisActivity.run {
//            timer.scheduleAtFixedRate(timerTask, 0, 1000)
//        }


        // Add a marker in Sydney and move the camera
//        val ganaur = LatLng(29.132200, 77.011700)
//        mMap.addMarker(MarkerOptions().position(ganaur).title("Marker in Ganaur"))
//        val delhi = LatLng(28.704060, 77.102493)
//        mMap.addMarker(MarkerOptions().position(delhi).title("Marker in Delhi"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ganaur, 15f))
    }

    private fun addAuthorityMarkers() {
        AppFirebase.Static.MARKERS_LIST_DATABASE_REFERENCE.addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {
            }

            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                try {
                    println("aa")
                    println("()()()()$p1")
                    println("()()()()" + p0.getValue(String::class.java))

                } catch (e: Exception) {
                    print(e.toString())
                }
            }

            override fun onChildRemoved(p0: DataSnapshot) {
            }
        })
    }

}
