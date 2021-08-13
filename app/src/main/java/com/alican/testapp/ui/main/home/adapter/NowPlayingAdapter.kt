package com.alican.testapp.ui.main.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.alican.testapp.core.BaseAdapter
import com.alican.testapp.databinding.ItemNowPlayingBinding
import com.alican.testapp.net.response.now_playing.ResultsItem
import com.alican.testapp.utils.util.extension.clickWithDebounce

class NowPlayingAdapter(private val callBack: ((ResultsItem) -> Unit)?) :
    BaseAdapter<ResultsItem>(object : DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ResultsItem,
            newItem: ResultsItem
        ): Boolean {
            return oldItem == newItem
        }

    }) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val viewModel = NowPlayingAdapterViewModel()
        val binding: ItemNowPlayingBinding =
            ItemNowPlayingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        binding.viewModel = viewModel
        binding.itemRoot.clickWithDebounce {
            binding.viewModel?.item?.get()?.let {
                callBack?.invoke(it)
            }
        }
        return binding

    }

    override fun bind(binding: ViewDataBinding, position: Int) {
        (binding as ItemNowPlayingBinding).viewModel?.item?.set(getItem(position))
        binding.executePendingBindings()
    }
}