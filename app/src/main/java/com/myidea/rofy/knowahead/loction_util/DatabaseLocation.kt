package com.myidea.rofy.knowahead.loction_util

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class DatabaseLocation (lat: Double, lng: Double){

    var lat: Double = 0.0
    var lng: Double = 0.0
    var time: String = ""

    init {
        // Getting current date time in format "hh:mm:ss a"
        val date = Date()
        val dateFormat = SimpleDateFormat("hh:mm:ss a")
        // Setting the member variables:
        this.time = dateFormat.format(date)
        this.lat = lat
        this.lng = lng
    }
}