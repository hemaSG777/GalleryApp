package com.example.galleryapp

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface Api {
    @GET("flickr.photos.getRecent")
    fun getImagesList(
        @Query("api_key")
        method: String,
        api_key: String,
        per_page: Int,
        page: Int,
        format: String,
        nojsoncallback:Int,
        extras:String
    ): Call<ImagesData>
    companion object {

        private val customInterceptor = Interceptor {
            val requestBuilder = it.request().newBuilder()
                .addHeader(
                    "api_key",
                    "6f102c62f41998d151e5a1b48713cf13"
                )
                .build()
            it.proceed(requestBuilder)
        }

        private val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(customInterceptor)
            .build()
        var BASE_URL = "https://api.flickr.com/services/rest/?"


        fun imagesList(): Api {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(Api::class.java)
        }
    }
}