package com.example.anthonyliberatore.restaurantdelivery.app.di.application

import com.google.gson.Gson
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApplicationModule {

    val module = Kodein.Module("ApplicationModule") {

        import(EndpointModule().module)
        import(RepositoryModule().module)

        bind<Retrofit>() with singleton {
            Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl("https://api.doordash.com/v2/")
                    .build()
        }
    }

}
