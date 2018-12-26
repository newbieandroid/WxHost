package com.olanboa.wx.host.activity

import com.csl.lib.dialog.MyDialog
import com.olanboa.wx.host.PermissionBaseActivity
import com.olanboa.wx.host.R

class SpActivity : PermissionBaseActivity() {

    override fun onViewCreated() {


        object : MyDialog(this) {
            override fun isCancleable(): Boolean = false

            override fun setLayoutRes(): Int = R.layout.dialog_test

        }.show()


    }


    override fun setLayoutRes(): Int = R.layout.spactivity

}