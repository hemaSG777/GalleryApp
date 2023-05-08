package com.example.galleryapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.galleryapp.Images
import com.example.galleryapp.ImagesData
import com.example.galleryapp.Interface.Api
import com.example.galleryapp.adapter.ImagesAdapter
import com.example.galleryapp.databinding.ActivityMainBinding
import com.example.galleryapp.viewModel.ImagesViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val imagesAdapter by lazy { ImagesAdapter(this, imageList) }
    private val imageList = ArrayList<Images>()
    private lateinit var imagesModel : ImagesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        imagesModel = ViewModelProvider(this)[ImagesViewModel::class.java]
        imagesModel.getImages()
        imagesModel.observeMovieLiveData().observe(this, Observer { imageList->
            imagesAdapter.setImagesList(imageList)
        })
//        getList()
    }

//    viewModel = ViewModelProvider(this)[MovieViewModel::class.java]
//    viewModel.getPopularMovies()
//    viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
//        adapter.setMovieList(movieList)
//    })
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        binding.imagesRv.adapter = imagesAdapter
        binding.imagesRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

//    private fun getList() {
//        val apiInterface = Api.imagesList()
//            .getImagesList()
//        apiInterface.enqueue(object : Callback<ImagesData> {
//
//            override fun onResponse(call: Call<ImagesData>, response: Response<ImagesData>) {
//                val responseData = response.body()!!.photos.photo
//                val adapter = ImagesAdapter(this@MainActivity, responseData)
//                binding.imagesRv.adapter = adapter
//            }
//
//            override fun onFailure(call: Call<ImagesData>, t: Throwable) {
//                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
//            }
//
//        })
//    }
}