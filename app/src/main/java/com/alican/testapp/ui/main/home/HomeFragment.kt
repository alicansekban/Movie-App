package com.alican.testapp.ui.main.home

import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.alican.testapp.R
import com.alican.testapp.core.BaseFragment
import com.alican.testapp.databinding.FragmentHomeBinding
import com.alican.testapp.net.response.up_coming.UpComingResponse
import com.alican.testapp.ui.main.home.adapter.NowPlayingAdapter
import com.alican.testapp.ui.main.home.adapter.UpComingAdapter
import com.alican.testapp.utils.util.extension.dismissProgressDialog
import com.alican.testapp.utils.util.extension.observeWith
import com.alican.testapp.utils.util.extension.showProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(HomeViewModel::class.java) {
    override fun onInit() {

        initAdapterNowPlaying()

        binding?.viewModel?.progressLiveData?.observeWith(viewLifecycleOwner) {
            if (it) showProgressDialog() else dismissProgressDialog()
        }
        binding?.upComingList?.apply {
            this.adapter = UpComingAdapter() {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(
                        it.results?.get(0)?.id.toString()
                    )
                findNavController().navigate(action)
            }
            setHasFixedSize(true)
        }
        binding?.viewModel?.upComingResponse?.observeWith(this) {
            initAdapterUpComing(it)
        }
        binding?.viewModel?.nowPlayingResponse?.observeWith(this) {
            (binding?.nowPlayingList?.adapter as? NowPlayingAdapter)?.submitList(it.results)
        }

    }

    private fun initAdapterUpComing(list: List<UpComingResponse?>?) {
        (binding?.upComingList?.adapter as? UpComingAdapter)?.submitList(list)
    }

    private fun initAdapterNowPlaying() {
        val nowPlayingAdapter = NowPlayingAdapter {
            val action =
                HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(it.id.toString())
            findNavController().navigate(action)
        }
        binding?.nowPlayingList?.apply {
            adapter = nowPlayingAdapter
        }

        binding?.indicator?.setViewPager2(binding!!.nowPlayingList)


    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }
}