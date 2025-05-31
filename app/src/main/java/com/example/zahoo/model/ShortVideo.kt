package com.example.zahoo.model

data class ShortVideo(
    val id: Int,
    val videoUrl: String,
    val caption: String,
    val user: User,
    val likes: Int,
    val comments: List<Comment>
)

data class Comment(
    val id: Int,
    val text: String,
    val user: User
)