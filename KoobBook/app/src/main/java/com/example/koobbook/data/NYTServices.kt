package com.example.koobbook.data

import com.example.koobbook.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        @Query("api-key") apiKey: String = "8SQEdlzA6KsyC75hAhEiyTPJnQkkybT0",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}