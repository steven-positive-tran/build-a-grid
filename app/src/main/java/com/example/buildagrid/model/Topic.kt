package com.example.buildagrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(

    @StringRes val topic_name: Int,
    val topic_courses: Int,
    @DrawableRes val topic_image: Int

)
