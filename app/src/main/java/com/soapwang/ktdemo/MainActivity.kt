package com.soapwang.ktdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val foodList = ArrayList<String>()
//        foodList.add("Hamburger")
//        foodList.add("noodles")
//        foodList.add("Chicken")
        val foodList = arrayListOf<String>("Hamburger", "Noodles", "Chicken")

        newAsyncActivityBtn.setOnClickListener({
            var intent = Intent(this, AsyncListActivity::class.java)
            startActivity(intent)
//            var text = addFoodText.text.toString()
//            if (text.trim() != "") {
//                foodList.add(text)
//                addFoodText.setText("")
//                Toast.makeText(this, "New food added!", Toast.LENGTH_SHORT).show()
//                println("Add new food: $text")
//                println(foodList)
//            } else {
//                addFoodText.setText("")
//            }
        })

        decideBtn.setOnClickListener({
            val random = Random()
            var toEat = random.nextInt(foodList.size)
            foodText.setText(foodList[toEat])
        })

        newActivityBtn.setOnClickListener({
            var intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        })

    }
}
