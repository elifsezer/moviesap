package com.example.moviesap.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesap.databinding.ItemMovieBinding
import com.example.moviesap.model.movie.MovieResult

class MovieAdapter: ListAdapter<MovieResult, MovieAdapter.ViewHolder>(DIFF_CALLBACK) {

    private lateinit var onMovieClickListener: OnMovieClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.create(LayoutInflater.from(parent.context), parent, onMovieClickListener)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(getItem(position))

    fun setOnMovieClickListener(onMovieClickListener: OnMovieClickListener) {
        this.onMovieClickListener = onMovieClickListener
    }

    class ViewHolder(val binding: ItemMovieBinding, onMovieClickListener: OnMovieClickListener): RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                onMovieClickListener.onMovieClick(binding.movie!!)
            }
        }

        companion object {
            fun create(inflater: LayoutInflater, parent: ViewGroup, onMovieClickListener: OnMovieClickListener): ViewHolder {
                val itemMovieBinding = ItemMovieBinding.inflate(inflater, parent, false)
                return ViewHolder(itemMovieBinding, onMovieClickListener)
            }
        }

        fun bind(movieResults: MovieResult) {
            binding.movie = movieResults
            binding.executePendingBindings()
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieResult>() {
            override fun areItemsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean =
                oldItem.movieId == newItem.movieId

            override fun areContentsTheSame(oldItem: MovieResult, newItem: MovieResult): Boolean =
                oldItem.title == newItem.title

        }
    }

    interface OnMovieClickListener {
        fun onMovieClick(movieResults: MovieResult)
    }
}
