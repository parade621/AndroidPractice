package com.parade621.listview_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val list_item = mutableListOf<String>()
        val list_item = mutableListOf<ListViewModel>()

        /*list_item.add("A")
        list_item.add("B")
        list_item.add("C")*/
        list_item.add(ListViewModel("a","b"))
        list_item.add(ListViewModel("c","d"))
        list_item.add(ListViewModel("e","f"))

        // 단순히 문자열이 아닌, 데이터 모델을 전달 해 줄 수도 있다.

        val listview = findViewById<ListView>(R.id.mainlistview)

        val listAdapter = ListViewAdapter(list_item)
        listview.adapter = listAdapter


    }
}