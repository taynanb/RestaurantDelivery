package com.example.anthonyliberatore.restaurantdelivery.app.di.screen

import android.app.Activity
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.imagedetail.ImageDetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

class ImageDetailActivityModule {

    val module = Kodein.Module("ImageDetailActivityModule") {

        bind<ImageDetailViewModel>() with scoped(WeakContextScope.of<Activity>()).singleton {
            ImageDetailViewModel()
        }

    }

}