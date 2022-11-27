package com.parade621.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bookmarkBtn = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkBtn.setOnClickListener {

            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)

        }


        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/naO5C9wSDnbr",
                "https://mp-seoul-image-production-s3.mangoplate.com/908198_1613908519563798.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "베이컨시"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/Fy2Z5kqgi-7b",
                "https://mp-seoul-image-production-s3.mangoplate.com/495395_1614255254121795.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "따빠디또 디저트 따빠스바"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/CbdJqQErxKsX",
                "https://mp-seoul-image-production-s3.mangoplate.com/611133_1550401765568269.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "빠사삭"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
                "https://mp-seoul-image-production-s3.mangoplate.com/331247/60039_1596540913676_34054?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴욕택시디저트"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/56MKQk5Vm_",
                "https://mp-seoul-image-production-s3.mangoplate.com/1187060_1614152939493440.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "오목눈이"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/y4pGEk_ZwDqZ",
                "https://mp-seoul-image-production-s3.mangoplate.com/222991_1511866490383465.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "퍼블리코타코"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/q1PDtSFDsXea",
                "https://mp-seoul-image-production-s3.mangoplate.com/705256_1575706043849051.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "오월의김밥"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/g0N_jDu7tyvV",
                "https://mp-seoul-image-production-s3.mangoplate.com/9239_1663137727307936.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "푀유 파티세리"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/56MKQk5Vm_",
                "https://mp-seoul-image-production-s3.mangoplate.com/104601_1503734240862785.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "두만강샤브샤브"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/KIjjCOGG794g",
                "https://mp-seoul-image-production-s3.mangoplate.com/947135_1594533300193078.jpg?fit=around|359:240&crop=359:240;*,*&output-format=jpg&output-quality=80",
                "커피볶는여자"
            )
        )

        // 여기서 이제 recyclerView 연결
        val recyclerView = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items)
        recyclerView.adapter = rvAdapter

//        recyclerView.layoutManager = LinearLayoutManager(this)  // 필수
        recyclerView.layoutManager = GridLayoutManager(this, 3)


        rvAdapter.itemClick = object:RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title", items[position].titleText)
                intent.putExtra("imageUrl",items[position].ImageUrl)
                startActivity(intent)

            }

        }


    }
}