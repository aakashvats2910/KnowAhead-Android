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

class MainActivity : AppCompatActivity() {

    // Variables for the widgets on the screen.
    lateinit var main_layout : LinearLayout
    lateinit var username_text_field: EditText
    lateinit var password_text_field: EditText
    lateinit var show_password_check_box: CheckBox

    // Private variables for this class.
    lateinit var a: ViewGroup.LayoutParams

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // Initialization of the widgets.
        main_layout = LinearLayout(applicationContext)
        username_text_field = EditText(applicationContext)
        password_text_field = EditText(applicationContext)
        show_password_check_box = CheckBox(applicationContext)

        // Setting up the orientation of the main_layout to vertical!
        main_layout.orientation = LinearLayout.VERTICAL

        // Adding the widgets in the
        main_layout.addView(username_text_field, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT ))
        main_layout.addView(password_text_field, ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT ))
        main_layout.addView(show_password_check_box)

        // Setting up the characteristics of the username and password field!
        username_text_field.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
        password_text_field.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        show_password_check_box.text = "Show Password"

        // Assigned listener to this activity.
        show_password_check_box.setOnClickListener {
            if (show_password_check_box.isChecked)
                Log.d("()()()()", "Check box CHECKED!!!")
            if (!show_password_check_box.isChecked)
                Log.d("()()()()", "Check box UNCHECKED!!!")
        }


        // Adding main_layout to the screen/window
        setContentView(main_layout)

    }

    
}
