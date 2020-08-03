package com.example.github_simple_retrofit_kotlin_application

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

//data class GithubModel(
//    @SerializedName("name")
//    val name: String
//)

data class GithubModel(
        @field:Json(name = "name") val name: String
)