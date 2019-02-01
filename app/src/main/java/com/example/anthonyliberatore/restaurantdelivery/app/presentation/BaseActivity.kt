package com.example.anthonyliberatore.restaurantdelivery.app.presentation

import android.support.v7.app.AppCompatActivity
import com.example.anthonyliberatore.restaurantdelivery.app.di.screen.ScreenModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

abstract class BaseActivity : AppCompatActivity(), KodeinAware {

    private val _parentKodein by closestKodein()

    override val kodein: Kodein = Kodein.lazy {
        extend(_parentKodein)
        import(ScreenModule(this@BaseActivity).module)
    }


//    val screenComponent by lazy {
        //        getApplicationComponent().plus(ScreenModule(this))
//    }

//    private fun getApplicationComponent(): ApplicationComponent {
//        return (application as BaseApplication).component
//    }
}