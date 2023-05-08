package com.example.galleryapp

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class ImagesViewModel : ViewModel() {
//    private var imageList = MutableLiveData<List<ImagesData>>()
//
//    fun getImages() {
//        val apiInterface = Api.imagesList().getImagesList("6f102c62f41998d151e5a1b48713cf13")
//        apiInterface.enqueue(object : Callback<ImagesData> {
//            override fun onResponse(call: Call<ImagesData>, response: Response<ImagesData>) {
//                if (response.body() != null) {
//                    imageList.value = response.body()!!.photo
//                } else {
//                    return
//                }
//            }
//
//            override fun onFailure(call: Call<ImagesData>, t: Throwable) {
//                Toast.makeText("TAG", t.message.toString(), Toast.LENGTH_SHORT).show()
//            }
//
//        })
//    }
//}
//
//class MovieViewModel : ViewModel() {
//    private var movieLiveData = MutableLiveData<List<Result>>()
//
//    @SuppressLint("SuspiciousIndentation")
//    fun getPopularMovies() {
//        val apiInterface = Api.moviesList().getPopularMovies("69d66957eebff9666ea46bd464773cf0")
//        apiInterface.enqueue(object : Callback<MovieData> {
//            override fun onResponse(call: Call<MovieData>, response: Response<MovieData>) {
//                if (response.body() != null) {
//                    movieLiveData.value = response.body()!!.results
//                } else {
//                    return
//                }
//            }
//
//            override fun onFailure(call: Call<MovieData>, t: Throwable) {
//                Log.d("TAG", t.message.toString())
//            }
//        })
//    }
//
//    fun observeMovieLiveData(): LiveData<List<Result>> {
//        return movieLiveData
//    }
//}