package com.parade621.mango_contents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVAdapter(val context: Context, val List: MutableList<ContentModel>):RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int):RVAdapter.ViewHolder{
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)

        return ViewHolder(v)
    }

    interface ItemClick{
        fun onClick(view: View, position:Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position:Int){

        if(itemClick !=null){
            holder.itemView?.setOnClickListener { v->
                itemClick!!.onClick(v,position)
            }
        }
        holder.bindItems(List[position])
    }
    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        // 아래 parameter가 contentModel인건 저기 저 위에 RVAdapter 리스트 파라미터 타입이 ContentView이기 때문입니당.
        fun bindItems(item : ContentModel){
            val rv_image = itemView.findViewById<ImageView>(R.id.rvImageArea)
            val rv_text = itemView.findViewById<TextView>(R.id.rvTextArea)

            rv_text.text = item.titleText
            // glide gradle에 적용한 다음에
            Glide.with(context)
                .load(item.ImageUrl)
                .into(rv_image)
        }
    }


}