package com.example.fragmentcommunicationinterfaceex2

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.cardview.widget.CardView

class SenderFragment : Fragment() {

    private lateinit var communicator: Communicator
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var siteListView: ListView

    private val urls = arrayOf(
        "https://www.google.com",
        "https://www.facebook.com",
        "https://www.youtube.com",
        "https://www.apple.com"
    )

    override fun onAttach(context: Context) {
        super.onAttach(context)
        communicator = context as Communicator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("Tag", "onCreateView")
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        siteListView = view.findViewById(R.id.site_list_view)
        adapter = ArrayAdapter<String>(
            view.context,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            urls
        )

        siteListView.adapter = adapter
        siteListView.setOnItemClickListener { adapterView, view, position, id ->
            val selectedUrl = urls[position]
            communicator.sendUrl(selectedUrl)
        }

    }
}