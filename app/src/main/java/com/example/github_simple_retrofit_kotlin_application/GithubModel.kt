package com.example.github_simple_retrofit_kotlin_application

import com.google.gson.annotations.SerializedName

data class GithubModel(
    @SerializedName("name")
    val name: String
)