package com.example.anthonyliberatore.restaurantdelivery.app.di.screen

import android.app.Activity
import com.domain.usecase.GetRestaurantListUseCase
import com.domain.usecase.GetRestaurantUseCase
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.BaseActivity
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.imagedetail.ImageDetailViewModel
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.main.MainRouter
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.main.MainViewModel
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.restaurantdetail.RestaurantDetailRouter
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.restaurantdetail.RestaurantDetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

class ScreenModule(private val activity: BaseActivity) {

    val module = Kodein.Module("ScreenModule") {
        bind<BaseActivity>() with provider { activity }

        bind<MainRouter>() with scoped(WeakContextScope.of<Activity>()).singleton {
            MainRouter(context)
        }

        bind<RestaurantDetailRouter>() with scoped(WeakContextScope.of<Activity>()).singleton {
            RestaurantDetailRouter(context)
        }

        bind<GetRestaurantUseCase>() with singleton {
            GetRestaurantUseCase(instance())
        }

        bind<GetRestaurantListUseCase>() with singleton {
            GetRestaurantListUseCase(instance())
        }

        bind<MainViewModel>() with scoped(WeakContextScope.of<Activity>()).singleton {
            MainViewModel(instance(), instance())
        }

        bind<RestaurantDetailViewModel>() with scoped(WeakContextScope.of<Activity>()).singleton {
            RestaurantDetailViewModel(instance(), instance())
        }

        bind<ImageDetailViewModel>() with scoped(WeakContextScope.of<Activity>()).singleton {
            ImageDetailViewModel()
        }
    }

}
