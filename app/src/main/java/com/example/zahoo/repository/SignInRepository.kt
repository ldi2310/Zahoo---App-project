package com.example.zahoo.repository

import com.example.zahoo.model.SignInRequest
import com.example.zahoo.model.SignInResponse
import com.example.zahoo.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInRepository {
    fun signIn(username: String, password: String, onResult: (Boolean, String) -> Unit) {
        val signInRequest = SignInRequest(username, password)

        RetrofitInstance.api.signIn(signInRequest).enqueue(object : Callback<SignInResponse> {
            override fun onResponse(call: Call<SignInResponse>, response: Response<SignInResponse>) {
                if (response.isSuccessful && response.body()?.success == true) {
                    // Đăng nhập thành công
                    onResult(true, "Login successful")
                } else {
                    // Đăng nhập thất bại
                    onResult(false, response.body()?.message ?: "Unknown error")
                }
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                // Lỗi kết nối
                onResult(false, "Failed to connect to server")
            }
        })
    }
}
