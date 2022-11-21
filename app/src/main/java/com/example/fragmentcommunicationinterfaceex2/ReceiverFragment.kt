package com.example.fragmentcommunicationinterfaceex2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView

class ReceiverFragment : Fragment() {

    private lateinit var browser: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        browser = view.findViewById(R.id.myWebView)
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun setUrl(url: String) {
        browser.settings.javaScriptEnabled = true
        browser.webViewClient = WebViewClient()

        if (url == null) {
            browser.loadUrl("https://www.google.com")
        } else {
            browser.loadUrl(url)
        }
    }
}