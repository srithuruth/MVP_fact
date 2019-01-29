package com.example.mvp_fact.di

import com.example.mvp_fact.network.APIService
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface AppComponent{
    fun apiService(): APIService
}