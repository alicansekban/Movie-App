package com.alican.testapp.ui.main.language

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.alican.testapp.R
import com.alican.testapp.core.BaseFragment
import com.alican.testapp.databinding.FragmentLanguageBinding
import com.alican.testapp.ui.main.MainActivity
import com.alican.testapp.ui.main.MainViewModel
import com.alican.testapp.utils.util.extension.clickWithDebounce
import com.alican.testapp.utils.util.extension.show
import java.util.*

class LanguageFragment :
    BaseFragment<LanguageViewModel, FragmentLanguageBinding>(LanguageViewModel::class.java) {
    private val mainActivityViewModel: MainViewModel by activityViewModels()

    override fun getLayoutRes(): Int {
        return R.layout.fragment_language
    }

    override fun onInit() {
        setListener()
        when {
            (activity as MainActivity).getCurrentLanguage().language == Locale.ENGLISH.language -> binding?.englishSelected?.show()
            (activity as MainActivity).getCurrentLanguage().language == Locale.forLanguageTag("tr-TR").language -> binding?.turkishSelected?.show()
        }
    }

    private fun setListener() {
        binding?.backBtn?.clickWithDebounce {
            findNavController().navigateUp()
        }
        binding?.btnEnglish?.clickWithDebounce {
            setLocaleEnglish()
        }
        binding?.btnTurkish?.clickWithDebounce {
            setLocaleTurkish()
        }
    }

    private fun setLocaleEnglish() {
        if ((activity as MainActivity).getCurrentLanguage() != Locale.ENGLISH) {
            mainActivityViewModel.needRestartAppForLocale.value = true
            viewModel.pref.edit().putString("language", "en").apply()
            (activity as MainActivity).setLanguage(Locale.ENGLISH)
        }
    }

    private fun setLocaleTurkish() {
        if ((activity as MainActivity).getCurrentLanguage() != Locale.forLanguageTag("tr-TR")) {
            mainActivityViewModel.needRestartAppForLocale.value = true
            viewModel.pref.edit().putString("language", "en").apply()
            (activity as MainActivity).setLanguage(Locale.forLanguageTag("tr-TR").language)
        }
    }
}