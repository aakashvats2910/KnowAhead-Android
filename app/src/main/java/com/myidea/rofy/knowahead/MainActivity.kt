package com.myidea.rofy.knowahead

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.Px
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.firebase.database.FirebaseDatabase
import com.myidea.rofy.knowahead.firebase.AppFirebase
import com.myidea.rofy.knowahead.loction_util.LocationCapture
import java.security.Permission
import java.security.Permissions
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    // Variables for the widgets on the screen.
    lateinit var main_layout: LinearLayout
    lateinit var first_text_view: TextView
    lateinit var second_text_view: TextView
    lateinit var use_it_button: Button

    // Final variable for the context;
    val thisActivity = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // Initialization of the widgets.
        main_layout = LinearLayout(applicationContext)
        first_text_view = TextView(applicationContext)
        second_text_view = TextView(applicationContext)
        use_it_button = Button(applicationContext)

        // Granting the permissions.
        if (ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission_group.LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(thisActivity, arrayOf(android.Manifest.permission_group.LOCATION), 0)
        }

        // Setting orientation of main_layout
        main_layout.orientation = LinearLayout.VERTICAL

        // Adding characteristics to first_text_view
        first_text_view.text = "No need to login or sign-up!"

        // Adding characteristics to second_text_view
        second_text_view.text = "Just use is directly as a guest!"

        // Adding characteristics to use_it_button
        use_it_button.text = "USE IT"
        use_it_button.setOnClickListener {
            // TODO check the necessary permissions before going to another activity.
            // The permissions are location and imei number.
            // Location is to use the location of the person for helping him/her.
            // IMEI number is used to mark it as the unique user.
            startActivity(Intent(this, MapsActivity::class.java))
        }

        LocationCapture().mandatoryForGettingLocation(applicationContext)

        // Adding main_layout to the screen/window
        main_layout.addView(first_text_view)
        main_layout.addView(second_text_view)
        main_layout.addView(use_it_button)
        setContentView(main_layout)

    }


}
