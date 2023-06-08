package com.jvillad1.networking.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ServiceDrivenResponse(
    @Json(name = "type") val type: String? = null,
    @Json(name = "action") val requiredProceed: String? = null,
    @Json(name = "content") val content: Content
)

@JsonClass(generateAdapter = true)
data class Content(
    @Json(name = "title") val title: String? = null
)
