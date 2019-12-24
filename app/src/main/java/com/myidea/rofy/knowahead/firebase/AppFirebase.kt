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

    }

    public fun mandatoryToRun() {
        Static.MAIN_FIREBASE_REFERENCE = FirebaseDatabase.getInstance()
        Static.MAIN_DATABASE_REFERENCE = Static.MAIN_FIREBASE_REFERENCE.getReference()
    }

    public fun initializationOfDatabase() {
        Static.USERS_LIST_DATABASE_REFERENCE = Static.MAIN_DATABASE_REFERENCE.child("USERS")
        

    }

}