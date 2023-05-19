package com.example.galleryapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.galleryapp.Interface.RefugeeApi
import com.example.galleryapp.adapter.RefugeeAdapter
import com.example.galleryapp.data.RefugeeData
import com.example.galleryapp.databinding.ActivityRestBinding
import retrofit2.Call
import retrofit2.Response

class RestActivity : AppCompatActivity() {
    private val binding by lazy { ActivityRestBinding.inflate(layoutInflater) }
    private val rAdapter by lazy { RefugeeAdapter(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getList()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        binding.restRv.adapter = rAdapter
        binding.restRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun getList() {
        val apiInterface = RefugeeApi.refugeeList().getRefugeeList()
        apiInterface.enqueue(object : retrofit2.Callback<RefugeeData> {
            override fun onResponse(call: Call<RefugeeData>, response: Response<RefugeeData>) {
                val responseData = response.body()
                rAdapter.update(responseData!!)
            }

            override fun onFailure(call: Call<RefugeeData>, t: Throwable) {
                Toast.makeText(this@RestActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }

}