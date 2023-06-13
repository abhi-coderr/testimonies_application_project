package com.yogeshwar.testimoniesapp.core

import android.app.Application
import android.graphics.Typeface
import com.yogeshwar.testimoniesapp.core.network_helper.NetworkMonitor
import com.yogeshwar.testimoniesapp.core.utils.TypeFactory
import com.yogeshwar.testimoniesapp.core.validator.MyValidations
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {

    companion object {

        /**
         * To check internet is available or not.
         */
        var isInternetAvailable: Boolean = false


        var mTypeFactory: TypeFactory? = null

        fun getTypeFace(type: TypeFactory.FontType): Typeface? {
            return when (type) {
                TypeFactory.FontType.REGULAR -> mTypeFactory?.regular
                TypeFactory.FontType.LIGHT -> mTypeFactory?.light
                TypeFactory.FontType.MEDIUM -> mTypeFactory?.medium
                TypeFactory.FontType.SEMI_BOLD -> mTypeFactory?.semibold
                TypeFactory.FontType.BOLD -> mTypeFactory?.bold
            }
        }

    }

    override fun onCreate() {
        super.onCreate()

        /**
         * Setting up the validation.
         */
        MyValidations.setAllEditTextValidations(this)

        mTypeFactory = TypeFactory(this)

        /**
         * Start network callback
         */
        NetworkMonitor(this).startNetworkCallback()
    }

    override fun onTerminate() {
        super.onTerminate()
        /**
         * Stop network callback
         */
        NetworkMonitor(this).stopNetworkCallback()
    }
}