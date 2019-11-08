package com.example.moviesap.ui.main.toprated

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesap.R
import com.example.moviesap.common.BaseVMFragment
import com.example.moviesap.model.movie.MovieResult
import com.example.moviesap.ui.detail.DetailActivity
import com.example.moviesap.ui.main.MovieAdapter
import com.example.moviesap.util.Constants
import com.example.moviesap.util.gone
import com.example.moviesap.util.visible
import kotlinx.android.synthetic.main.fragment_top_rated_movies.*

class TopRatedMoviesFragment : BaseVMFragment<TopRatedMoviesViewModel>(),MovieAdapter.OnMovieClickListener {

    private lateinit var adapter: MovieAdapter

    override fun getViewModel(): Class<TopRatedMoviesViewModel> =
        TopRatedMoviesViewModel::class.java

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_rated_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MovieAdapter()
        populr_recyclerview.layoutManager = GridLayoutManager(activity, 2)
        adapter.setOnMovieClickListener(this)
        viewModel.getTopRatedMovies()?.observe(this, Observer {
            adapter.submitList(it)
            populr_recyclerview.adapter = adapter
            populr_recyclerview.visible()
            popular_progressbar.gone()
        })
    }
    override fun onMovieClick(movieResults: MovieResult) {

        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(Constants.EXTRA_POPULAR_MOVIES,movieResults)
        startActivity(intent)
    }


}
