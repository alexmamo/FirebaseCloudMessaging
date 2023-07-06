package ro.alexmamo.firebasecloudmessaging.core

import android.util.Log

class Utils {
    companion object {
        fun print(e: Exception?) = e?.message?.let {
            Log.e(TAG, it)
        }

        fun log(message: String?) = message?.let {
            Log.e(TAG, it)
        }
    }
}