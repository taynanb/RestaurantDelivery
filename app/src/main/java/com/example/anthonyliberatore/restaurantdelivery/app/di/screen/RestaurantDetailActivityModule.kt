package com.example.anthonyliberatore.restaurantdelivery.app.di.screen

import android.app.Activity
import com.domain.usecase.GetRestaurantUseCase
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.restaurantdetail.RestaurantDetailRouter
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.restaurantdetail.RestaurantDetailViewModel
import org.kodein.di.Kodein
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

class RestaurantDetailActivityModule {

    val module = Kodein.Module("RestaurantDetailActivityModule") {

        bind<RestaurantDetailRouter>() with scoped(WeakContextScope.of<Activity>()).singleton {
            RestaurantDetailRouter(context)
        }

        bind<GetRestaurantUseCase>() with singleton {
            GetRestaurantUseCase(restaurantRepository = instance())
        }

        bind<RestaurantDetailViewModel>() with scoped(WeakContextScope.of<Activity>()).singleton {
            RestaurantDetailViewModel(
                    getRestaurantUseCase = instance(),
                    restaurantDetailRouter = instance())
        }
    }

}