package com.example.zahoo.network

import com.example.zahoo.model.ForgotPasswordRequest
import com.example.zahoo.model.ForgotPasswordResponse
import com.example.zahoo.model.SignInRequest
import com.example.zahoo.model.SignInResponse
import com.example.zahoo.model.SignOutRequest
import com.example.zahoo.model.SignOutResponse
import com.example.zahoo.model.SignUpRequest
import com.example.zahoo.model.SignUpResponse
import com.example.zahoo.model.UpdateProfileRequest
import com.example.zahoo.model.UpdateProfileResponse
import com.example.zahoo.model.UserProfileResponse
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
}
