package com.myidea.rofy.knowahead.loction_util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Looper
import android.util.Log
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import com.myidea.rofy.knowahead.MapsActivity

object NewLocationCapture {

    object Static {

        // To check the status of weather the location service is on or off in the device.0
        fun locationStatus(context: Context): Boolean {
            val location = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
            if (ContextCompat.checkSelfPermission(context, Manifest.permission_group.LOCATION) == PackageManager.PERMISSION_GRANTED) {
                return (location.isProviderEnabled(LocationManager.NETWORK_PROVIDER) || location.isProviderEnabled(
                    LocationManager.GPS_PROVIDER))
            }
            return false
        }

    }

    private var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private var locationRequest: LocationRequest? = null
    private var locationCallback: LocationCallback? = null

    // Building location request.
    private fun buildLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest!!.interval = 0
        locationRequest!!.fastestInterval = 0
        locationRequest!!.smallestDisplacement = 0f
    }

    // Building the LocationCallback.
    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
//                    LocationStore.Static.setLatLng(location.latitude, location.longitude)
                    MapsActivity.Static.updateLocation(location.latitude, location.longitude)
                    // TODO give the current location of the device to the firebase database.
                    // Just for checking in the log:
                    Log.d(
                        "()() LOCATION",
                        " " + location.latitude + "||" + location.longitude
                    )
                }
            }
        }
    }

    // If we have to get location then this method is must to be called.
    fun mandatoryForGettingLocation(context: Context?) {
        buildLocationRequest()
        buildLocationCallback()
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(context!!)
        startLocationService()
    }

    fun startLocationService() {
        fusedLocationProviderClient!!.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.myLooper()
        )
    }

    fun stopLocationService() {
        fusedLocationProviderClient!!.removeLocationUpdates(locationCallback)
    }

}