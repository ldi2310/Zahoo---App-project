// File: User.kt
package com.example.zahoo.model  // hoặc com.example.zahoo nếu không chia package

data class User(
    val id: Int,
    val username: String,
    val email: String,
    val fullName: String?,
    val avatarUrl: String?
)
