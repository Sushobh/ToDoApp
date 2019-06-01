package org.sushobh.exampleapp

import android.app.Application

class MyApplication : Application() {


    override fun onCreate() {
        myApplication = this;
        super.onCreate()
    }

    companion object {
        lateinit var myApplication: MyApplication
    }

}