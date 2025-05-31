package com.example.zahoo.repository

import com.example.zahoo.model.ShortVideo
import com.example.zahoo.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShortVideoRepository {
    fun getShortVideos(onResult: (List<ShortVideo>?, String?) -> Unit) {
        RetrofitInstance.api.getShortVideos().enqueue(object : Callback<List<ShortVideo>> {
            override fun onResponse(call: Call<List<ShortVideo>>, response: Response<List<ShortVideo>>) {
                if (response.isSuccessful) {
                    onResult(response.body(), null)
                } else {
                    onResult(null, "Failed to load videos")
                }
            }

            override fun onFailure(call: Call<List<ShortVideo>>, t: Throwable) {
                onResult(null, "Error: ${t.message}")
            }
        })
    }
}