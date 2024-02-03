package com.example.kotlin51.preference

import android.content.Context

class PrefernceHelper(context: Context) {

    private val preference =
        context.getSharedPreferences(PREFERENCES_USER_NAME, Context.MODE_PRIVATE)
    var isShowRegister: Boolean
        get() = preference.getBoolean(PREFERNCE_IS_SHOW_REGISTER, false)
        set(value) {
            preference.edit().putBoolean(PREFERNCE_IS_SHOW_REGISTER, value).apply()
        }

    var user_name: String?
        get() = preference.getString(PREFERENCES_USER_NAME, "")
        set(value) {
            preference.edit().putString(PREFERENCES_USER_NAME, value).apply()
        }
    var age: String?
        get() = preference.getString(PREFERENCES_AGE, "")
        set(value) {
            preference.edit().putString(PREFERENCES_AGE, value).apply()
        }
    var email: String?
        get() = preference.getString(PREFERENCES_EMAIL, "")
        set(value) {
            preference.edit().putString(PREFERENCES_EMAIL, value).apply()
        }

    var password: String?
        get() = preference.getString(PREFERENCES_PASSWORD, "")
        set(value) {
            preference.edit().putString(PREFERENCES_PASSWORD, value).apply()
        }

    companion object {
        const val PREFERNCE_IS_SHOW_REGISTER = "register"
        const val PREFERENCES_USER_NAME = "user_name helper"
        const val PREFERENCES_AGE = "age helper"
        const val PREFERENCES_EMAIL = "email helper"
        const val PREFERENCES_PASSWORD = "password helper"
    }
}