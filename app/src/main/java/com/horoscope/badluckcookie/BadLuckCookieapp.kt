package com.horoscope.badluckcookie

import android.app.Application
import com.google.android.gms.ads.MobileAds

class BadLuckCookieapp:Application() {
    override fun onCreate() {
        super.onCreate()

        MobileAds.initialize(this)

    }
}