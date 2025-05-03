package com.example.zahoo.network

import com.example.zahoo.SignInRequest
import com.example.zahoo.SignInResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    fun signIn(@Body request: SignInRequest): Call<SignInResponse>
}
