package com.example.myapplication

import android.app.Application
import com.example.myapplication.di.AppComponentHolder

class App : Application(), AppComponentHolder {

    companion object {
        lateinit var shared: App private set
    }

    override val component by lazy {
        createAppComponent(
            applicationContext = this,
        )
    }

    override fun onCreate() {
        super.onCreate()

        shared = this
        component.inject(this)
    }
}