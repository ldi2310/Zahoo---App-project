package com.example.zahoo.network

import com.example.zahoo.model.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("login")
    fun signIn(@Body request: SignInRequest): Call<SignInResponse>

    @POST("register")
    fun signUp(@Body request: SignUpRequest): Call<SignUpResponse>

    @POST("logout")
    fun signOut(@Body request: SignOutRequest): Call<SignOutResponse>

    @GET("profile")
    fun getProfile(@Header("Authorization") token: String): Call<UserProfileResponse>

    @PUT("profile")
    fun updateProfile(
        @Header("Authorization") token: String,
        @Body request: UpdateProfileRequest
    ): Call<UpdateProfileResponse>

    @POST("forgot-password")
    fun forgotPassword(@Body request: ForgotPasswordRequest): Call<ForgotPasswordResponse>

    @GET("short-videos")
    fun getShortVideos(): Call<List<ShortVideo>>
}