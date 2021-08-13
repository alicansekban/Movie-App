package com.alican.testapp.ui.main.detail

import androidx.navigation.fragment.navArgs
import com.alican.testapp.R
import com.alican.testapp.core.BaseFragment
import com.alican.testapp.databinding.FragmentMovieDetailBinding
import com.alican.testapp.utils.util.extension.dismissProgressDialog
import com.alican.testapp.utils.util.extension.observeWith
import com.alican.testapp.utils.util.extension.showProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment :
    BaseFragment<MovieDetailViewModel, FragmentMovieDetailBinding>(MovieDetailViewModel::class.java) {
    private val args: MovieDetailFragmentArgs by navArgs()
    override fun getLayoutRes(): Int {
        return R.layout.fragment_movie_detail
    }

    override fun onInit() {
        viewModel.getMovieDetail(args.id)
        binding?.viewModel?.progressLiveData?.observeWith(viewLifecycleOwner) {
            if (it) showProgressDialog() else dismissProgressDialog()
        }
    }
}