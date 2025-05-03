package com.example.zahoo

// Định nghĩa data class cho phản hồi từ server
data class SignInResponse(
    val success: Boolean,
    val message: String? = null,
    val user: User? = null
)

data class User(
    val id: Int,
    val username: String,
    val email: String
)
