package com.example.moviesap.ui.detail.overview


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.example.moviesap.R
import com.example.moviesap.common.BaseFragment
import com.example.moviesap.databinding.FragmentOverviewBinding
import com.example.moviesap.model.movie.MovieResult

class OverviewFragment : BaseFragment<FragmentOverviewBinding, OverviewViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_overview

    override fun getViewModel(): Class<OverviewViewModel> = OverviewViewModel::class.java

    companion object {
        private const val MOVIE_KEY = "movie_overview_key"
        fun newInstance(movie: MovieResult?):OverviewFragment
        {
            val args = Bundle()
            args.putParcelable(MOVIE_KEY,movie)

            val fragment= OverviewFragment()
            fragment.arguments=args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val movie:MovieResult= arguments?.getParcelable<MovieResult>(MOVIE_KEY) as MovieResult
        val movieId=movie.movieId

        viewModel.getDetails(movieId).observe(this, Observer {
            dataBinding.detail=it
        })

    }


}
