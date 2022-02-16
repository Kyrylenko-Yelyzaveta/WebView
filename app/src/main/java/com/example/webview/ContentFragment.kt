package com.example.webview

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.webview.databinding.FragmentContentBinding


class ContentFragment : Fragment() {
    lateinit var sharedPref: SharedPreferences
    private lateinit var binding: FragmentContentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentContentBinding.inflate(inflater)

        sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)!!
        if (sharedPref.getBoolean("firstRun", true)) {
            sharedPref.getString("link", "")?.let {
                binding.webView.loadUrl(it)
            }
            sharedPref.edit().putBoolean("firstRun", false).commit()
        } else {
            sharedPref.getString("home", "")?.let {
                binding.webView.loadUrl(it)
            }
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    when {
                        binding.webView.canGoBack() -> binding.webView.goBack()
                        else -> activity?.finish()
                    }
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = ContentFragment()
    }
}