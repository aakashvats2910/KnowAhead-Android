package com.myidea.rofy.knowahead.firebase

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AppFirebase constructor() {

    object Static{

        // Base initialization of the firebase database.
        public lateinit var MAIN_FIREBASE_REFERENCE: FirebaseDatabase
        public lateinit var MAIN_DATABASE_REFERENCE: DatabaseReference

        // User database reference
        public lateinit var USERS_LIST_DATABASE_REFERENCE : DatabaseReference

        // Locations of traffic authorities on the road. Those locations are just static.
        public lateinit var MARKERS_LIST_DATABASE_REFERENCE: DatabaseReference

        public fun mandatoryToRun() {
            MAIN_FIREBASE_REFERENCE = FirebaseDatabase.getInstance()
            MAIN_DATABASE_REFERENCE = MAIN_FIREBASE_REFERENCE.reference
            initializationOfDatabase()
        }

        private fun initializationOfDatabase() {
            MARKERS_LIST_DATABASE_REFERENCE = MAIN_DATABASE_REFERENCE.child("MARKERS_LIST")
//            USERS_LIST_DATABASE_REFERENCE = MAIN_DATABASE_REFERENCE.child("USERS")

        }

    }



}