package com.example.github_simple_retrofit_kotlin_application

import android.app.Application

open class GithubApp : Application(){
    open fun getBaseUrl() = "https://api.github.com/users/octocat/"
}