package com.soapwang.ktdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*

class AsyncListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Log.d("-AsyncListActivity-", "onCreate")

        var foodNames = arrayListOf<String>()
        for (i in 1..25)
            foodNames.add("food name " + i);

        var myListView = listview1
        var myListAdapter = CustomAsyncAdapter(this, foodNames)

        myListView.adapter = myListAdapter
        myListView.setOnItemClickListener({ parent, view, position, id ->
            var strToShow : String = myListView.adapter.getItem(position).toString()
            Toast.makeText(this, strToShow, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onStop() {
        super.onStop()
        Log.d("-AsyncListActivity-", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("-AsyncListActivity-", "onRestart")
    }
}
