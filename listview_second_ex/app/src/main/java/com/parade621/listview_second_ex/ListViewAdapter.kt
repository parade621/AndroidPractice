package com.parade621.listview_second_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter (val List : MutableList<ListViewModel>): BaseAdapter(){
    override fun getCount(): Int {
        //전체 크기 리턴
        return List.size

    }

    override fun getItem(position: Int): Any {
        // 리스트 원소 리턴
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView

        if (convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item,parent,false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listViewTitleText1)
        val content = convertView!!.findViewById<TextView>(R.id.listViewTitleText2)
        title.text = List[position].text1
        content.text =List[position].text2

        return convertView!!
    }
}