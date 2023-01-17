package com.example.pipeline.activityclass

import android.app.Application

open class DataApplication : Application() {


    private var singleton: DataApplication? = null

    open fun getInstance(): DataApplication? {

        return singleton
    }

    override fun onCreate() {
        super.onCreate()
        singleton = this
    }
}