package com.example.galleryapp.activities

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.galleryapp.Adapter.ImagesAdapter
import com.example.galleryapp.ImagesData
import com.example.galleryapp.Interface.Api
import com.example.galleryapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val imagesAdapter by lazy { ImagesAdapter(this) }
//    private val imageList = ArrayList<Images>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getList()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        binding.imagesRv.adapter = imagesAdapter
        binding.imagesRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getList() {
        val apiInterface = Api.imagesList()
            .getImagesList(
                "flickr.photos.getRecent",
                "6f102c62f41998d151e5a1b48713cf13",
                20,
                1,
                "json",
                1,
                "url_s"
            )
        apiInterface.enqueue(object : Callback<ImagesData> {

            override fun onResponse(call: Call<ImagesData>, response: Response<ImagesData>) {
                if (response.body() == null) {
                    Toast.makeText(this@MainActivity, "Empty", Toast.LENGTH_SHORT).show()
                } else if (response.isSuccessful) {
                    Log.e(TAG, "onResponse:${response.body()} ")
                    imagesAdapter.update(response.body() as ArrayList<ImagesData>)
                }
            }

            override fun onFailure(call: Call<ImagesData>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })

    }
}