package com.example.galleryapp

import com.google.gson.annotations.SerializedName

data class ImagesData(
    val photos: Data,
    val stat: String
)
data class Data(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val photo: List<Images>,
    val total: Int
)
data class Images(
    val farm: Int,
    val height_s: Int,
    val id: String,
    val isfamily: Int,
    val isfriend: Int,
    val ispublic: Int,
    val owner: String,
    val secret: String,
    val server: String,
    val title: String,
    val url_s: String,
    val width_s: Int
)