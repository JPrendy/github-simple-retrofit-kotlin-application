package com.example.github_simple_retrofit_kotlin_application

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_character_viewholder.view.*

class GithubAdapter : RecyclerView.Adapter<GithubAdapter.CharacterViewHolder>() {

    private val characterList = mutableListOf<GithubModel>()

    fun setCharacterList(characterList: List<GithubModel>) {
        this.characterList.clear()
        this.characterList.addAll(characterList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_character_viewholder,
            parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount() = characterList.size

    @SuppressLint("DefaultLocale")
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characterList[position]
        val test = character.name
        with(holder) {
            characterNameTextView.text = String.format(character.name)
        }
    }

    inner class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val characterNameTextView: TextView = itemView.character_name_textview
    }
}