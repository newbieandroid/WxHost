package com.olanboa.wx.host.bean.db

import org.litepal.crud.LitePalSupport

class LoginBean : LitePalSupport() {

    var userType: Int = 0
    var userName = ""
    var userTel = ""
    var userPass = ""

}