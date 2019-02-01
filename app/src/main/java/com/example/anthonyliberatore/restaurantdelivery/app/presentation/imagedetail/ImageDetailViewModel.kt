package com.example.anthonyliberatore.restaurantdelivery.app.presentation.imagedetail

import android.databinding.ObservableField

class ImageDetailViewModel {

    val imageUrl = ObservableField<String>()

    fun bound(url: String) {
        imageUrl.set(url)
    }
}
