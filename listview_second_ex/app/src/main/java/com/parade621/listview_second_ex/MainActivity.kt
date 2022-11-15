 package com.parade621.listview_second_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val list_item = mutableListOf<String>()
//        list_item.add("A")
//        list_item.add("B")
//        list_item.add("C")

        val list_item2 = mutableListOf<ListViewModel>()
        list_item2.add(ListViewModel("a","b"))
        list_item2.add(ListViewModel("c","d"))
        list_item2.add(ListViewModel("e","f"))
        list_item2.add(ListViewModel("g","h"))



        val listViewAdapter = ListViewAdapter(list_item2)
        val listview = findViewById<ListView>(R.id.mainListView)

        listview.adapter = listViewAdapter

        listview.setOnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this,list_item2[position].text1, Toast.LENGTH_SHORT).show()
        }



    }
}