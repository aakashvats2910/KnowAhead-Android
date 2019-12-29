package com.myidea.rofy.knowahead.capture_util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat

// This class is used to capture the device IMEI number.
// This is used for the identification of the unique devices.
class DeviceIdCapture {

    object Static {

        private lateinit var telephonyManager: TelephonyManager

        fun getDeviceID(context: Context): String {
            return Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }

        fun getIMEI(context: Context): String {
            telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    return telephonyManager.getImei(0) + "||" + telephonyManager.getImei(1)
                }
            }
            return ""
        }

    }

}