package com.alican.testapp.ui.main.detail

import android.content.Intent
import android.net.Uri
import androidx.navigation.fragment.navArgs
import com.alican.testapp.R
import com.alican.testapp.core.BaseFragment
import com.alican.testapp.databinding.FragmentMovieDetailBinding
import com.alican.testapp.utils.util.extension.clickWithDebounce

class MovieDetailFragment :
    BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>(MovieDetailViewModel::class.java) {
    private val args: MovieDetailFragmentArgs by navArgs()
    override fun getLayoutRes(): Int {
        return R.layout.fragment_movie_detail
    }

    override fun onInit() {
        viewModel.getUpComingMovies(args.id)
        setListener()

    }

    private fun setListener() {
        binding?.posterImg?.clickWithDebounce {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=")
                )
            )
        }
    }
}