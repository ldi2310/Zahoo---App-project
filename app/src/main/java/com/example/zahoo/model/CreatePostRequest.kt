package com.example.zahoo.model

data class CreatePostRequest(
    val user_id: Int,
    val content: String,
    val image_url: String? = null
)