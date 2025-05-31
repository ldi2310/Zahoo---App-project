package com.example.zahoo.model

// Định nghĩa data class cho phản hồi từ server
data class SignInResponse(val success: Boolean, val message: String? = null, val user: User? = null)