package com.example.healthrecord

import android.content.Context

class Preference {

    companion object {

        fun getInt(context: Context, prefName: String, key: String, defaultValue: Int): Int {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getInt(key, defaultValue)
        }
        fun setInt(context: Context, prefName: String, key: String, value: Int) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            val editor = pref.edit()
            editor.putInt(key, value)
            editor.apply()
        }

        const val PREFERENCE_USER_DATA = "user_data"
        const val KEY_GENDER = "gender"
        const val KEY_HEIGHT = "height"
    }
}