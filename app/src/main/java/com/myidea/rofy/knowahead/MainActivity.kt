package com.myidea.rofy.knowahead

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
import com.google.firebase.database.FirebaseDatabase
import com.myidea.rofy.knowahead.firebase.AppFirebase
import com.myidea.rofy.knowaheadlibrary.UserLib.AppUser
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    // Variables for the widgets on the screen.
    lateinit var main_layout: LinearLayout
    lateinit var first_text_view: TextView
    lateinit var second_text_view: TextView
    lateinit var use_it_button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // Initialization of the widgets.
        main_layout = LinearLayout(applicationContext)
        first_text_view = TextView(applicationContext)
        second_text_view = TextView(applicationContext)
        use_it_button = Button(applicationContext)

        // Setting orientation of main_layout
        main_layout.orientation = LinearLayout.VERTICAL

        // Adding characteristics to first_text_view
        first_text_view.text = "No need to login or sign-up!"

        // Adding characteristics to second_text_view
        second_text_view.text = "Just use is directly as a guest!"

        // Adding characteristics to use_it_button
        use_it_button.text = "USE IT"
        use_it_button.setOnClickListener {

        }

        // Adding main_layout to the screen/window
        main_layout.addView(first_text_view)
        main_layout.addView(second_text_view)
        setContentView(main_layout)

    }


}
