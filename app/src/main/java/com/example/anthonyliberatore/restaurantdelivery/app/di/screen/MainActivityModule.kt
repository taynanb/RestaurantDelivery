package com.example.anthonyliberatore.restaurantdelivery.app.di.screen

import android.app.Activity
import com.domain.usecase.GetRestaurantListUseCase
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.main.MainRouter
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.main.MainViewModel
import org.kodein.di.Kodein
import org.kodein.di.bindings.WeakContextScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton
import java.lang.ref.WeakReference

class MainActivityModule {

    val module = Kodein.Module("MainActivityModule") {

        bind<MainRouter>() with scoped(WeakContextScope.of<Activity>()).singleton {
            MainRouter(WeakReference(context))
        }

        bind<MainViewModel>() with scoped(WeakContextScope.of<Activity>()).singleton {
            MainViewModel(getRestaurantListUseCase = instance(), mainRouter = instance())
        }

        bind<GetRestaurantListUseCase>() with singleton {
            GetRestaurantListUseCase(restaurantRepository = instance())
        }
    }

}