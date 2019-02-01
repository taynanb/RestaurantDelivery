package com.example.anthonyliberatore.restaurantdelivery.app.di.application

import com.data.RestaurantApi
import com.data.RestaurantEndpoint
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

class EndpointModule {

    val module = Kodein.Module("EndpointModule") {
        bind<RestaurantEndpoint>() with singleton {
            instance<Retrofit>().create(RestaurantEndpoint::class.java)
        }

        bind<RestaurantApi>() with singleton {
            RestaurantApi(instance())
        }
    }

}

