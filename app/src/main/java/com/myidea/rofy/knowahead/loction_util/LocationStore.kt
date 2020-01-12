package com.myidea.rofy.knowahead.loction_util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.myidea.rofy.knowahead.MapsActivity
import java.lang.Exception

class LocationStore {

    object Static {

        private var LATITUDE: Double = 0.0
        private var LONGITUDE: Double = 0.0

        public fun setLatLng(lat: Double, lng: Double) {
            MapsActivity.Static.lat = lat
            MapsActivity.Static.lng = lng
        }

        // To check the status of weather the location service is on or off in the device.0
        fun locationStatus(context: Context): Boolean {
            val location = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (ContextCompat.checkSelfPermission(context, Manifest.permission_group.LOCATION) == PackageManager.PERMISSION_GRANTED) {
                return (location.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || location.isProviderEnabled(LocationManager.GPS_PROVIDER))
            }
            return false
        }

    }

}