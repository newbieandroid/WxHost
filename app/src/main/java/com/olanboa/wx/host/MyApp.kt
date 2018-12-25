package com.olanboa.wx.host

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}