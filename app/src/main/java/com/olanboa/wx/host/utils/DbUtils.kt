package com.olanboa.wx.host.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.alibaba.fastjson.JSON
import com.olanboa.wx.host.R
import java.sql.DriverManager

@SuppressLint("StaticFieldLeak")
object DbUtils {

    private var context: Context? = null


    fun init(context: Context) {
        this.context = context
        Class.forName("com.mysql.jdbc.Driver")
    }


    fun select(sql: String) {

        //建立连接
        val conn = DriverManager.getConnection(
            context?.resources?.getString(R.string.mysqlUrl),
            context?.resources?.getString(R.string.mysqlName),
            context?.resources?.getString(R.string.mysqlPass)
        )


        val stmt = conn.createStatement()
        val resultSet = stmt.executeQuery(sql)


        while (resultSet.next()) {

            Log.e("csl", "------------------${JSON.toJSONString(resultSet)}")
        }


        stmt.close()

        conn.close()

    }

}