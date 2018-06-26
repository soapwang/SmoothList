package com.soapwang.ktdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        var wifiNames = arrayListOf<String>()
        for (i in 1..25)
            wifiNames.add("Wi-Fi name " + i);

        var myListView = listview1
        var myListAdapter = CustomAdapter(this, wifiNames)

        myListView.adapter = myListAdapter
        myListView.setOnItemClickListener({ parent, view, position, id ->
            var strToShow : String = myListView.adapter.getItem(position).toString()
            Toast.makeText(this, strToShow, Toast.LENGTH_SHORT).show()
        })
    }
}
