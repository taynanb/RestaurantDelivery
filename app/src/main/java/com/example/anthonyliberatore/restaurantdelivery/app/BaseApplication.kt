package com.example.anthonyliberatore.restaurantdelivery.app

import android.app.Application
import com.example.anthonyliberatore.restaurantdelivery.app.di.application.ApplicationModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.androidModule

class BaseApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidModule(this@BaseApplication))
        import(ApplicationModule(this@BaseApplication).module)
    }

//    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        inject()
    }

    fun inject() {
//        component = DaggerApplicationComponent.builder().applicationModule(
//                ApplicationModule(this)).build()
//        component.inject(this)
    }
}