package com.example.galleryapp.data

class RefugeeData : ArrayList<RefugeeDataItem>()

class RefugeeDataItem(
    val accessible: Boolean,
    val approved: Boolean,
    val changing_table: Boolean,
    val city: String,
    val comment: String,
    val country: String,
    val created_at: String,
    val directions: String,
    val downvote: Int,
    val edit_id: Int,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val name: String,
    val state: String,
    val street: String,
    val unisex: Boolean,
    val updated_at: String,
    val upvote: Int
)