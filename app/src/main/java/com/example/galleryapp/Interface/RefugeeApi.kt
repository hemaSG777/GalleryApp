package com.example.galleryapp.Interface

import com.example.galleryapp.data.RefugeeData
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface RefugeeApi {

    @GET("restrooms")
    fun getRefugeeList(
        @Query("page") page: Int = 1,
        @Query("per_page") per_page: Int = 10,
        @Query("offset") offset: Int = 0,
        @Query("query") query: String = "san%20francisco",
    ): Call<RefugeeData>

    companion object {
        private val client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
        var BASE_URL = "https://www.refugerestrooms.org/api/v1/"


        fun refugeeList(): RefugeeApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .client(client)
                .build()
            return retrofit.create(RefugeeApi::class.java)
        }
    }
}