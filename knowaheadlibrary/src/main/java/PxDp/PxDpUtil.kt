package PxDp

import android.content.Context

class PxDpUtil {

    lateinit var x: String

    object Static {

        public fun dpFromPx(context: Context, px: Float): Float {
            return px / context.resources.displayMetrics.density
        }

        public fun pxFromDp(context: Context, dp: Float): Float {
            return dp * context.resources.displayMetrics.density
        }

    }

}