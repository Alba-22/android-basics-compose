package com.example.marsphotos.fake

import com.example.marsphotos.network.MarsPhoto

object FakeDatasource {

    val photosList = listOf(
        MarsPhoto(
            id = "img1",
            imgSrc = "url1"
        ),
        MarsPhoto(
            id = "img2",
            imgSrc = "url2"
        )
    )
}