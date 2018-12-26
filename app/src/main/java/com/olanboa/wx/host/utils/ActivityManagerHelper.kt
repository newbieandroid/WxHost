package com.olanboa.wx.host.utils

import android.app.Activity

object ActivityManagerHelper {

    private val activitys = ArrayList<Activity>()


    fun addItems(item: Activity) {
        activitys.add(item)
    }

    fun removeItem(item: Activity) {

        activitys.remove(item)
    }


    fun deleteAll() {

        activitys.forEach { it ->
            it.finish()
        }
        activitys.clear()
    }


    fun removeItemExcept(item: Activity) {

        activitys.forEach {

            if (it != item) {
                it.finish()
            }
        }

        activitys.clear()
        activitys.add(item)

    }


}