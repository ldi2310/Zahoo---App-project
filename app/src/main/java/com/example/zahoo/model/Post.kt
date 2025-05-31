package com.example.zahoo.model

data class Post(
    val id: Int,
    val user_id: Int,
    val content: String,
    val image_url: String?,
    val created_at: String,
    val username: String?,
    val full_name: String?
)