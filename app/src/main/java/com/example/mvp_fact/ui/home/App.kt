package com.example.mvp_fact.ui.home

import android.app.Application
import com.example.mvp_fact.di.AppComponent
import com.example.mvp_fact.di.DaggerAppComponent

class App: Application(){
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent=DaggerAppComponent.builder()
            .build()

    }
    fun getComponent() = appComponent
}