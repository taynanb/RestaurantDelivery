package com.example.anthonyliberatore.restaurantdelivery.app.presentation

import android.support.v7.app.AppCompatActivity
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

abstract class BaseActivity : AppCompatActivity(), KodeinAware {

    val parentKodein by closestKodein()

}