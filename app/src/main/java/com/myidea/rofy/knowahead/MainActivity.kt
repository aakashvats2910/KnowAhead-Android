package com.myidea.rofy.knowahead

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.database.FirebaseDatabase
import com.myidea.rofy.knowahead.firebase.AppFirebase
import com.myidea.rofy.knowaheadlibrary.UserLib.AppUser

class MainActivity : AppCompatActivity() {

    // Variables for the widgets on the screen.
    lateinit var main_layout : LinearLayout
    lateinit var username_text_field: TextView
    lateinit var password_text_field: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        main_layout = LinearLayout(applicationContext)

        username_text_field = TextView(applicationContext)
        password_text_field = TextView(applicationContext)



        setContentView(main_layout)

    }
}
