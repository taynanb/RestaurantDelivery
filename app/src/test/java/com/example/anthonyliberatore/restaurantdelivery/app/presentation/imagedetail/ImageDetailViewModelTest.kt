package com.example.anthonyliberatore.restaurantdelivery.app.presentation.imagedetail


import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class ImageDetailViewModelTest {

    private lateinit var sut: ImageDetailViewModel

    @Before
    fun setUp() {
        sut = ImageDetailViewModel()
    }

    @Test
    fun `bound sets imageUrl to url`() {
        val url = "url"

        sut.bound(url)

        assertThat(sut.imageUrl.get(), equalTo(url))
    }
}
