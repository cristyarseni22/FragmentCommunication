package com.example.fragmentcommunicationinterfaceex2

import androidx.annotation.DrawableRes

data class Sites(
    @DrawableRes val img: Int,
    val urls: String,
    val siteName: String
)