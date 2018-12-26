package com.olanboa.wx.host

import android.Manifest
import android.app.Notification
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import permissions.dispatcher.*


@RuntimePermissions
abstract class PermissionBaseActivity : AppCompatActivity() {


    abstract fun onViewCreated()
    abstract fun setLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayoutRes())

        onNeedsPermissionWithPermissionCheck()
    }


    @OnNeverAskAgain(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.READ_PHONE_STATE
    )
    fun onNeverAskAgain() {
//注解在当用户选中了授权窗口中的不再询问复选框后并拒绝了权限请求时需要调用的方法，一般可以向用户解释为何申请此权限，并根据实际需求决定是否再次弹出权限请求对话

        Log.e("csl", "=========onNeverAskAgain=======")



    }

    @OnPermissionDenied(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.READ_PHONE_STATE
    )
    fun onPermissionDenied() {
        //注解在当用户拒绝了权限请求时需要调用的方法上
        Log.e("csl", "=========onPermissionDenied=======")


        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_PHONE_STATE
            ),
            0
        )
    }

    @OnShowRationale(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.READ_PHONE_STATE
    )
    fun onShowRationale(request: PermissionRequest) {
        //注解在用于向用户解释为什么需要调用该权限的方法上，只有当第一次请求权限被用户拒绝，下次请求权限之前会调用
        Log.e("csl", "=========onShowRationale=======")

        request.proceed()

    }

    @NeedsPermission(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.CAMERA,
        Manifest.permission.READ_PHONE_STATE
    )
    fun onNeedsPermission() {
        //注解在需要调用运行时权限的方法上，当用户给予权限时会执行该方法

        Log.e("csl", "=========onNeedsPermission=======")
        onViewCreated()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)

    }

}