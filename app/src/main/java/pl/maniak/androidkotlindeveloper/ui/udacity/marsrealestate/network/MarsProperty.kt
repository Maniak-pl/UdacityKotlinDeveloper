package pl.maniak.androidkotlindeveloper.ui.udacity.marsrealestate.network

import com.squareup.moshi.Json

class MarsProperty(
    val id: String,
    @Json(name = "img_src") val imgSrcUrl: String,
    val type: String,
    val price: Double
)