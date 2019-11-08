package com.example.moviesap.ui.main.popular

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
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
import kotlinx.android.synthetic.main.fragment_popular_movies.*

class PopularMoviesFragment : BaseVMFragment<PopularMoviesViewModel>(), MovieAdapter.OnMovieClickListener {

//databinding kullanılmayacağı için BaseVMFragmenti kullandık.

    private lateinit var adapter: MovieAdapter

    override fun getViewModel(): Class<PopularMoviesViewModel> = PopularMoviesViewModel::class.java


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popular_movies, container, false)
    }


    //basevmfragment geliyor viewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MovieAdapter()
        populr_recyclerview.layoutManager = GridLayoutManager(activity, 2)
        adapter.setOnMovieClickListener(this)
        viewModel.getPopularMovies()?.observe(this, Observer {
            adapter.submitList(it)
            populr_recyclerview.adapter = adapter
            populr_recyclerview.visible()
            popular_progressbar.gone()
        })
    }

    override fun onMovieClick(movieResult: MovieResult) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra(Constants.EXTRA_POPULAR_MOVIES, movieResult)
        startActivity(intent)
    }
}
