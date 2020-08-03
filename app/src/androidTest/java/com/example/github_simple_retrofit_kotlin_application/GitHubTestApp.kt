package com.example.github_simple_retrofit_kotlin_application

class GitHubTestApp  : GithubApp() {

    var url = "http://127.0.0.1:8080"

    override fun getBaseUrl(): String {
        return url
    }
}