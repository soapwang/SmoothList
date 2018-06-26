package com.soapwang.ktdemo

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_layout.view.*

class CustomAdapter : BaseAdapter {

    var mContext : Context?
    var dataSource : ArrayList<String>

    constructor(context: Context?, data : ArrayList<String>) {
        mContext = context
        dataSource = data
    }

    // with view holder design pattern
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder : ViewHolder
        var mInflater = LayoutInflater.from(mContext)
        var mView : View
        //convertView: The old view to reuse, if possible.
        if(convertView == null) {
            mView = mInflater.inflate(R.layout.item_layout, parent, false)
            holder = ViewHolder()
            holder.textView = mView.itemText
            holder.imageView = mView.itemImage
            mView.tag = holder
        } else {
            mView = convertView
            holder = convertView.tag as ViewHolder
        }


        var itemStr = getItem(position)
        var textView = holder.textView
        var imageView = holder.imageView

        textView.setText(itemStr)
        // Change here to show different images
        imageView.setImageResource(R.drawable.signal)

        //Log.d("CustomAdapter", "Get view for position: " + position)

        return mView
    }

    override fun getItem(i: Int): String {
         return dataSource[i]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    class ViewHolder {
        lateinit var textView : TextView
        lateinit var imageView : ImageView
    }
}