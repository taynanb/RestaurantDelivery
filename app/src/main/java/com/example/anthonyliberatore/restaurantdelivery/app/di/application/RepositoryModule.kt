package com.example.anthonyliberatore.restaurantdelivery.app.di.application

import com.data.mapper.RestaurantMapper
import com.data.repository.RestaurantRepositoryImpl
import com.domain.repository.RestaurantRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class RepositoryModule {

    val module = Kodein.Module("RepositoryModule") {
        bind<RestaurantMapper>() with singleton {
            RestaurantMapper()
        }

        bind<RestaurantRepository>() with singleton {
            RestaurantRepositoryImpl(instance(), instance())
        }
    }

}
