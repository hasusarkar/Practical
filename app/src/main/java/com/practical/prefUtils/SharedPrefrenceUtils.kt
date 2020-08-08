package com.practical.prefUtils

import android.content.Context
import android.content.SharedPreferences
import android.util.Log

object SharedPrefrenceUtils {
    private const val MINDTOKE_APPLICATION = "mindtoke_application_preferences"
    const val PREF_EPISODE_DATA = "prf_episode_data"
    const val PREF_CHANNEL_DATA = "prf_channel_data"
    const val PREF_CATEGORY_DATA = "prf_category_data"

    fun setSharedPreferenceString(context: Context, key: String, value: String, prefname: String) {
        val settings = context.getSharedPreferences(prefname, 0)
        val editor = settings.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun setSharedPreferenceboolean(
        context: Context,
        key: String,
        value: Boolean,
        prefname: String
    ) {
        val settings = context.getSharedPreferences(prefname, 0)
        val editor = settings.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getSharedPreferenceString(
        context: Context,
        key: String,
        defValue: String,
        prefname: String
    ): String? {
        val settings = context.getSharedPreferences(prefname, 0)
        return settings.getString(key, defValue)
    }

    fun clearSharedPreference(context: Context, prefname: String): Boolean {
        val settings = context.getSharedPreferences(prefname, 0)
        return settings.edit().clear().commit()
    }

    fun getSharedPreferenceboolean(
        context: Context,
        key: String,
        defValue: Boolean,
        prefname: String
    ): Boolean {
        val settings = context.getSharedPreferences(prefname, 0)
        return settings.getBoolean(key, defValue)
    }


    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(
            MINDTOKE_APPLICATION,
            Context.MODE_PRIVATE
        )
    }

    fun getStringPref(context: Context, key: String?): String? {
        return getSharedPreferences(context).getString(key, "")
    }

    fun putStringPref(
        context: Context,
        key: String?,
        value: String?
    ) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(key, value)
        editor.apply()
    }


    fun getIntPref(context: Context, key: String?): Int {
        return getSharedPreferences(context).getInt(key, 0)
    }

    fun putIntPref(
        context: Context,
        key: String?,
        value: Int
    ) {
        val editor = getSharedPreferences(context).edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getBooleanPref(context: Context, key: String?): Boolean {
        return getSharedPreferences(context).getBoolean(key, false)
    }

    fun putBooleanPref(
        context: Context,
        key: String?,
        value: Boolean
    ) {
        val editor = getSharedPreferences(context).edit()
        editor.putBoolean(key, value)
        editor.apply()
    }


    fun getLongPref(context: Context, key: String?): Long {
        return getSharedPreferences(context).getLong(key, 0L)
    }

    fun putLongPref(
        context: Context,
        key: String?,
        value: Long
    ) {
        val editor = getSharedPreferences(context).edit()
        editor.putLong(key, value)
        editor.apply()
    }


    fun getSessionExpired(
        context: Context,
        key: String?
    ): Boolean {
        return getSharedPreferences(context).getBoolean(key, false)
    }

    fun putSessionExpired(
        context: Context,
        key: String?,
        value: Boolean
    ) {
        val editor = getSharedPreferences(context).edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun clearAllPreferences(context: Context) {
        getSharedPreferences(context).edit().clear().apply()
        Log.e("clearAllPreferences: ", "===> " + "Cleared")
    }
}