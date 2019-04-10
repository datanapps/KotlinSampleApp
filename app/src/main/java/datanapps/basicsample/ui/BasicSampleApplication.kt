package datanapps.basicsample.ui

import android.app.Application

import datanapps.basicsample.utils.DNASharedPreferenceUtils

class BasicSampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DNASharedPreferenceUtils.init(this)
    }
}
