package com.parade621.recyclerview_practice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RVAdapter(val items: MutableList<String>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    // setOnItemClick 등의 이벤트를 만들기도 함.
    // 리사이클러 뷰의 아이템을 불러오는 곳.
    override fun onCreateViewHolder(parent: ViewGroup, viewType:Int): RVAdapter.ViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rvitems,parent,false)

        return ViewHolder(view)
    }

    interface ItemClick{
        fun onClick(view : View, position:Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder:RVAdapter.ViewHolder, position: Int){
        holder.bindItems(items[position])

        // 여기서 이걸 해주면, item click 이벤트가 발생함.
        if(itemClick != null){
            holder.itemView.setOnClickListener { v->
                itemClick?.onClick(v,position)
            }
        }
    }
    override fun getItemCount(): Int {
        return items.size
    }

    // 이 부분이 inner class로 뷰를 재사용하는 부분임.
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(item:String){
            val rv_text = itemView.findViewById<TextView>(R.id.rvItems)
            rv_text.text = item
        }
    }
}