package com.myidea.rofy.knowahead.loction_util

import android.content.Context
import android.os.Looper
import android.util.Log
import com.google.android.gms.location.*

object NewLocationCapture {

    var latitude = 0.0
    var longitude = 0.0
    private var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private var locationRequest: LocationRequest? = null
    private var locationCallback: LocationCallback? = null

    // Building location request.
    private fun buildLocationRequest() {
        locationRequest = LocationRequest()
        locationRequest!!.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest!!.interval = 5000
        locationRequest!!.fastestInterval = 3000
        locationRequest!!.smallestDisplacement = 10f
    }

    // Building the LocationCallback.
    private fun buildLocationCallback() {
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
                    // ApplicationFirebase.GPS_LATITUDE_DATABASE_REFERENCE.setValue(location.getLatitude());
                    // ApplicationFirebase.GPS_LONGITUDE_DATABASE_REFERENCE.setValue(location.getLongitude());
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