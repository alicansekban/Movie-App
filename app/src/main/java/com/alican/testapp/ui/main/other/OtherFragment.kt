package com.alican.testapp.ui.main.other

import com.alican.testapp.R
import com.alican.testapp.core.BaseFragment
import com.alican.testapp.databinding.FragmentOtherBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OtherFragment :
    BaseFragment<OtherViewModel, FragmentOtherBinding>(OtherViewModel::class.java) {
    override fun onInit() {

    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_other
    }
}