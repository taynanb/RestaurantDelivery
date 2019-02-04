package com.example.anthonyliberatore.restaurantdelivery.app.presentation.imagedetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.anthonyliberatore.restaurantdelivery.R
import com.example.anthonyliberatore.restaurantdelivery.app.di.screen.ImageDetailActivityModule
import com.example.anthonyliberatore.restaurantdelivery.app.presentation.BaseActivity
import com.example.anthonyliberatore.restaurantdelivery.databinding.ActivityImageDetailBinding
import org.kodein.di.Kodein
import org.kodein.di.generic.instance

class ImageDetailActivity : BaseActivity() {

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        import(ImageDetailActivityModule().module)
    }

    val viewModel: ImageDetailViewModel by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityImageDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_detail)
        binding.viewModel = viewModel

        viewModel.bound(intent.extras.getString(EXTRA_URL, ""))
    }

    companion object {
        const val EXTRA_URL = "URL"
    }
}
