package com.example.galleryapp.viewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.galleryapp.Images
import com.example.galleryapp.ImagesData
import com.example.galleryapp.Interface.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImagesViewModel : ViewModel() {
    private var imagesListLiveData = MutableLiveData<List<Images>>()

    fun getImages() {
        val apiInterface = Api.imagesList().getImagesList()
        apiInterface.enqueue(object : Callback<ImagesData> {
            override fun onResponse(call: Call<ImagesData>, response: Response<ImagesData>) {
                imagesListLiveData.value = response.body()!!.photos.photo
            }

            override fun onFailure(call: Call<ImagesData>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }


        })
    }

    fun observeMovieLiveData(): MutableLiveData<List<Images>> {
        return imagesListLiveData
    }
}