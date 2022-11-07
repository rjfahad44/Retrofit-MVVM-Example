package com.ft.retrofit_mvvm_example.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ft.retrofit_mvvm_example.data.model.Results
import com.ft.retrofit_mvvm_example.databinding.RvItemBinding

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private var movieList = ArrayList<Results>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovieList(movieList: ArrayList<Results>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500${movieList[position].posterPath}")
            .into(holder.binding.ivMovieImage)
        holder.binding.tvMovieName.text = movieList[position].title
        holder.binding.tvMovieReleaseDate.text = movieList[position].releaseDate
        holder.binding.tvMovieLanguage.text = movieList[position].originalLanguage
    }

    override fun getItemCount(): Int = movieList.size
}
