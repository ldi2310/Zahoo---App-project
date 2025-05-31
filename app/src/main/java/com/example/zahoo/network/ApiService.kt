package com.example.zahoo.network

import com.example.zahoo.ForgotPasswordRequest
import com.example.zahoo.ForgotPasswordResponse
import com.example.zahoo.SignInRequest
import com.example.zahoo.SignInResponse
import com.example.zahoo.SignOutRequest
import com.example.zahoo.SignOutResponse
import com.example.zahoo.SignUpRequest
import com.example.zahoo.SignUpResponse
import com.example.zahoo.UpdateProfileRequest
import com.example.zahoo.UpdateProfileResponse
import com.example.zahoo.UserProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface ApiService {
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

}
