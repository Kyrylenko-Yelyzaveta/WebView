package com.example.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.webview.databinding.FragmentLoadingBinding
import java.net.HttpURLConnection
import java.net.URL


class LoadingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val binding = FragmentLoadingBinding.inflate(inflater)
        return binding.root}


    companion object {

        @JvmStatic
        fun newInstance() = LoadingFragment()
    }
}