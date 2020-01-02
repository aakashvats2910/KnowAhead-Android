package com.myidea.rofy.knowahead.capture_util

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.provider.Settings
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat
import com.myidea.rofy.knowahead.app_util.MyRandom
import java.lang.Exception

// This class is used to capture the device IMEI number.
// This is used for the identification of the unique devices.
class DeviceIdCapture {

    object Static {

        private lateinit var telephonyManager: TelephonyManager

        @SuppressLint("HardwareIds")
        fun getDeviceID(context: Context): String {
            return "deviceid : " + Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID)
        }

        fun getIMEI(context: Context): String {
            telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    return "imei" + try {
                        telephonyManager.getImei(0)
                    } catch (e: Exception) {
                        telephonyManager.getImei(1)
                    }
                }
            }
            return ""
        }

        fun getUniqueIdentification(context: Context): String {
            return try {
                getDeviceID(context)
            } catch (e: Exception) {
                getIMEI(context)
            }
        }

    }

}