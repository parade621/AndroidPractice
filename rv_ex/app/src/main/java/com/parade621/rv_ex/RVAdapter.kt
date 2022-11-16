package com.parade621.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items:MutableList<String>):RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):RVAdapter.ViewHolder {
        // recyclerView 아이템을 가져옴
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent,false)

        return ViewHolder(view)
    }

    interface ItemClick {
        fun onClick(view:View, position:Int)
    }
    var itemClick: ItemClick? = null

    override fun onBindViewHolder(holder:RVAdapter.ViewHolder, position:Int) {
        // ViewHolder에 바인딩 해줌

        if(itemClick != null){
            holder.itemView.setOnClickListener { v->
                itemClick?.onClick(v, position)
            }
        }
        holder.bindItems(items[position])
    }

    override fun getItemCount(): Int {
        // 전체 Counter RecyclerView의 갯수를 알려줌
        return items.size
    }

    inner class ViewHolder( itemView: View):RecyclerView.ViewHolder(itemView){

        fun bindItems(item:String){
            val rv_text = itemView.findViewById<TextView>(R.id.rvText)
            rv_text.text = item
        }
    }
}