package com.example.moviesap.ui.detail

import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.example.moviesap.R
import com.example.moviesap.common.BaseActivity
import com.example.moviesap.common.ViewPagerAdapter
import com.example.moviesap.databinding.ActivityDetailBinding
import com.example.moviesap.model.movie.MovieResult
import com.example.moviesap.ui.detail.overview.OverviewFragment
import com.example.moviesap.util.Constants
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {

    private var movie: MovieResult? = null


    override fun getLayoutRes(): Int = R.layout.activity_detail
    override fun getViewModel(): Class<DetailViewModel> = DetailViewModel::class.java


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupUI()

        intent.extras.let {
            movie = it?.getParcelable(Constants.EXTRA_POPULAR_MOVIES)
            setupViewPager(movie)
            fabBehaviour(movie)
            detail_tabs.setupWithViewPager(detail_viewpager!!)
            dataBinding.movie = movie

        }
    }
    private fun fabBehaviour(movie: MovieResult?) {
        detail_appbar_layout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffsett ->
            if(Math.abs(verticalOffsett) - appBarLayout.totalScrollRange == 0) {
                favorite_fab.hide()
                supportActionBar?.setDisplayShowTitleEnabled(true)
                detail_toolbar.title = movie?.title
            } else {
                favorite_fab.show()
                supportActionBar?.setDisplayShowTitleEnabled(false)
                detail_toolbar.title = " "
            }
        })

        detail_collapsing_toolbarlayout.setExpandedTitleColor(resources.getColor(android.R.color.transparent))
    }




    private fun setupUI() {
        setSupportActionBar(detail_toolbar)
        //bir önceki activiye geçmesini sağlar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //toolbarda title göstemiyoruz.
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setupViewPager(movie: MovieResult?) {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.apply {
            addFragment(OverviewFragment.newInstance(movie),"Overview")
        }
        detail_viewpager.adapter = adapter
    }
}
