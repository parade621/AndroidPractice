package com.parade621.listview_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List:MutableList<ListViewModel>) :BaseAdapter(){
    // item들의 갯수
    // 중요
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // 중요요
   override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView

        if (convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listviewItem_title)
        val content = convertView!!.findViewById<TextView>(R.id.listviewItem_content)
        title.text = List[position].title
        content.text = List[position].content
        // List[0] -> ListviewModel("a","b")
        // List[1] -> ListviewModel("c","d")
        // List[2] -> ListviewModel("e","f")

        return  convertView!!
    }
}