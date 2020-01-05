package com.myidea.rofy.knowahead.loction_util

import com.myidea.rofy.knowahead.MapsActivity

class LocationStore {

    object Static {

        private var LATITUDE: Double = 0.0
        private var LONGITUDE: Double = 0.0

        public fun setLatLng(lat: Double, lng: Double) {
            MapsActivity.Static.lat = lat
            MapsActivity.Static.lng = lng
        }

    }

}