package com.olanboa.wx.host

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.multidex.MultiDex
import com.olanboa.wx.host.utils.ActivityManagerHelper
import com.olanboa.wx.host.utils.DbUtils
import org.litepal.LitePal

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        LitePal.initialize(this)
        DbUtils.init(this)

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(p0: Activity?) {
            }

            override fun onActivityResumed(p0: Activity?) {
            }

            override fun onActivityStarted(p0: Activity?) {
            }

            override fun onActivityDestroyed(p0: Activity?) {

                ActivityManagerHelper.removeItem(p0!!)
            }

            override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
            }

            override fun onActivityStopped(p0: Activity?) {
            }

            override fun onActivityCreated(p0: Activity?, p1: Bundle?) {

                ActivityManagerHelper.addItems(p0!!)
            }

        })
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}