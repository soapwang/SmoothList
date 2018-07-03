package com.soapwang.ktdemo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_layout.view.*
import java.util.*

class CustomAsyncAdapter : BaseAdapter {

    var mContext : Context
    var dataSource : ArrayList<String>

    constructor(context: Context, data : ArrayList<String>) {
        mContext = context
        dataSource = data
    }

    // with view holder design pattern
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder : ViewHolder
        val mInflater = LayoutInflater.from(mContext)
        val mView : View

        //convertView: The old view to reuse, if possible.
        if(convertView == null) {
            mView = mInflater.inflate(R.layout.item_layout, parent, false)
            holder = ViewHolder(position)
            holder.textView = mView.itemText
            holder.imageView = mView.itemImage
            mView.tag = holder
        } else {
            mView = convertView
            holder = convertView.tag as ViewHolder
        }

        class LoadImageTask : AsyncTask<ViewHolder, Void, Bitmap>() {

            override fun onPreExecute() {
                super.onPreExecute()
                Log.d("CustomAsyncAdapter", "Start an AysncTask for position " + position)
            }

            override fun doInBackground(vararg p0: ViewHolder?): Bitmap {

                var rand = Random()
                Thread.sleep(300L + rand.nextInt(500))
                var bitmap = BitmapFactory.decodeResource(mContext.resources, R.drawable.chicken)
                return bitmap
            }

            override fun onPostExecute(result: Bitmap?) {
                super.onPostExecute(result)
                if(holder.mPosition == position) {
                    Log.d("CustomAsyncAdapter", "Load finished, position: " + position)
                    holder.imageView.setImageBitmap(result)
                }
            }
        }
        LoadImageTask().execute(holder)

        var itemStr = getItem(position)
        var textView = holder.textView
        var imageView = holder.imageView

        textView.setText(itemStr)

        Log.d("CustomAsyncAdapter", "Get view for position: " + position)

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
        constructor(position: Int) {
            this.mPosition = position
        }

        lateinit var textView : TextView
        lateinit var imageView : ImageView
        var mPosition : Int
    }


//    class LoadImageTask : AsyncTask<ViewHolder, Void, Bitmap> {
//        private lateinit var holder : ViewHolder
//        private var context : Context
//
//        constructor(context: Context) : super() {
//            this.context = context
//        }
//
//        override fun onPreExecute() {
//            super.onPreExecute()
//        }
//
//        override fun doInBackground(vararg p0: ViewHolder?): Bitmap {
//
//            var rand = Random()
//            Thread.sleep(200L + rand.nextInt(1000))
//            var bitmap = BitmapFactory.decodeResource(context.resources, R.drawable.signal)
//            return bitmap
//
//        }
//
//        override fun onPostExecute(result: Bitmap?) {
//            super.onPostExecute(result)
//            if(holder.mPosition == position)
//                holder.imageView.setImageBitmap(result)
//        }
//    }

}