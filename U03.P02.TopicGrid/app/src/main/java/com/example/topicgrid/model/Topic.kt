package com.example.topicgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val textResourceId: Int,
    val count: Int,
    @DrawableRes val imageResourceId: Int
)