package com.example.galleryapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.galleryapp.data.RefugeeData
import com.example.galleryapp.data.RefugeeDataItem
import com.example.galleryapp.databinding.ItemsRefugeeBinding

class RefugeeAdapter(val context: Context) : RecyclerView.Adapter<RefugeeAdapter.MyViewHolder>() {
    private var refugeeList = ArrayList<RefugeeDataItem>()

    inner class MyViewHolder(val binding: ItemsRefugeeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemsRefugeeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val items = refugeeList[position]
        with(holder) {
            binding.apply {
                text1.text = items.name
                text2.text = items.country
                text3.text = items.directions
                text4.text = items.comment
            }
        }
    }

    override fun getItemCount(): Int {
        return refugeeList.size
    }

    fun update(rList: List<RefugeeDataItem>) {
        refugeeList = rList as ArrayList<RefugeeDataItem>
        notifyDataSetChanged()
    }
}