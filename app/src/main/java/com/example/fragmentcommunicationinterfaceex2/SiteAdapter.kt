package com.example.fragmentcommunicationinterfaceex2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class SiteAdapter(
    private val context: Context,
    private val arrayList: List<Sites>
) : BaseAdapter() {

    override fun getCount() = arrayList.size

    override fun getItem(p0: Int) = arrayList[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        var convertView: View? = convertView

        if (convertView == null) {
            convertView =
                LayoutInflater.from(context).inflate(R.layout.item_site, viewGroup, false)
        }
        val sites = getItem(position) as Sites
        convertView?.apply {
            val imgOfSite = findViewById<ImageView>(R.id.img_of_site)
            val sitesName = findViewById<TextView>(R.id.tv_site_name) as TextView

            sites.apply {
                imgOfSite.setImageResource(img)
                sitesName.text = siteName
            }
        }
        return convertView!!
    }
}