package com.horoscope.badluckcookie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.horoscope.badluckcookie.databinding.ActivityBannerBinding
import com.horoscope.badluckcookie.databinding.ActivityMainBinding

class BannerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBannerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)
        binding = ActivityBannerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initLoadAds()
    }

    private fun initLoadAds() {

        val adRequest = AdRequest.Builder().build()
        binding.banner.loadAd(adRequest)
    }
}