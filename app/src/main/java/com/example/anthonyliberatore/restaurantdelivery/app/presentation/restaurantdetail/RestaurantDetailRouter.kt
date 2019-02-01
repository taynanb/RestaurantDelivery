package com.example.anthonyliberatore.restaurantdelivery.app.presentation.restaurantdetail

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.imagedetail.ImageDetailActivity
import java.lang.ref.WeakReference

/**
 * RestaurantDetailRouter handles navigation for the RestaurantDetail Screen
 */
class RestaurantDetailRouter(private val activityRef: Activity) {

    enum class Route {
        IMAGE_DETAIL,
    }

    fun navigate(route: Route, bundle: Bundle = Bundle()) {
        when (route) {
            Route.IMAGE_DETAIL -> {
                showNextScreen(ImageDetailActivity::class.java, bundle)
            }
        }
    }

    private fun showNextScreen(clazz: Class<*>, bundle: Bundle?) {
        activityRef.startActivity(Intent(activityRef, clazz).putExtras(bundle))
    }
}
