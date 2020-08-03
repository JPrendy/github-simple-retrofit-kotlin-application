package com.example.github_simple_retrofit_kotlin_application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var characterAdapter: GithubAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        // Switch to AppTheme for displaying the activity
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Your code
        characterAdapter = GithubAdapter()
        character_recyclerview.adapter = characterAdapter

        //Gson implementation version
//        val githubApi = Retrofit.Builder()
//                .baseUrl((application as GithubApp).getBaseUrl())
//                .addConverterFactory(GsonConverterFactory.create(Gson()))
//                .client(OkHttpProvider.getOkHttpClient())
//                .build()
//                .create(GithubApi::class.java)

        //Moshi implementation version
        val githubApi = Retrofit.Builder()
                .baseUrl((application as GithubApp).getBaseUrl())
                .addConverterFactory(MoshiConverterFactory.create())
                .client(OkHttpProvider.getOkHttpClient())
                .build()
                .create(GithubApi::class.java)

        githubApi.getCharacters().enqueue(object : Callback<List<GithubModel>> {
            override fun onFailure(call: Call<List<GithubModel>>, t: Throwable) {
                showErrorState()
            }

            override fun onResponse(call: Call<List<GithubModel>>,
                                    response: Response<List<GithubModel>>) {
                if (response.isSuccessful && response.body() != null) {
                    val characterList = response.body()!!
                    if (characterList.isEmpty()) {
                        showEmptyDataState()
                    } else {
                        showCharacterList(characterList)
                    }
                } else {
                    showErrorState()
                }
            }
        })
    }

    private fun showEmptyDataState() {
        character_recyclerview.visibility = View.GONE
        progress_bar.visibility = View.GONE
        textview.visibility = View.VISIBLE
        textview.text = "woops"
    }

    private fun showCharacterList(characterList: List<GithubModel>) {
        character_recyclerview.visibility = View.VISIBLE
        progress_bar.visibility = View.GONE
        textview.visibility = View.GONE
        characterAdapter.setCharacterList(characterList)
    }

    private fun showErrorState() {
        character_recyclerview.visibility = View.GONE
        progress_bar.visibility = View.GONE
        textview.visibility = View.VISIBLE
        textview.text = "woops"
    }

}
