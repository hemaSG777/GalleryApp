package com.example.galleryapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryapp.Images
import com.example.galleryapp.databinding.ItemsImageBinding

class ImagesAdapter(val context: Context, private var list: List<Images>) :
    RecyclerView.Adapter<ImagesAdapter.MyViewHolder>() {


    inner class MyViewHolder(val binding: ItemsImageBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemsImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]
        with(holder) {
            Glide.with(context)
                .load(item.url_s)
                .into(binding.imageIv)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setImagesList(movieList: List<Images>) {
        list = movieList as ArrayList<Images>
        notifyDataSetChanged()
    }

}
