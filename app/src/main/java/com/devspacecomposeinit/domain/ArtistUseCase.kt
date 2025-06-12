package com.devspacecomposeinit.domain

import androidx.annotation.DrawableRes

data class ArtistUseCase(
    val name: String,
    val lastSeenOnline: String,
    @DrawableRes val image: Int,
    @DrawableRes val art: Int,
)
