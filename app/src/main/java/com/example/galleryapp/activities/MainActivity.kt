package com.example.galleryapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.galleryapp.Images
import com.example.galleryapp.adapter.ImagesAdapter
import com.example.galleryapp.databinding.ActivityMainBinding
import com.example.galleryapp.viewModel.ImagesViewModel

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
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        binding.imagesRv.adapter = imagesAdapter
        binding.imagesRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}