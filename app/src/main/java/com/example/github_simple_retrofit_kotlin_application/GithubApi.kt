package com.example.github_simple_retrofit_kotlin_application

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("repos")
    fun getCharacters(@Query("key") key: String = API_KEY): Call<List<GithubModel>>
}

val API_KEY = ""