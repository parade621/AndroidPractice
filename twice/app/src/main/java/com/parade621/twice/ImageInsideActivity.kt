package com.parade621.twice

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.Toast

class ImageInsideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val getData = intent.getStringExtra("data")
        val memberImage = findViewById<ImageView>(R.id.memberImageArea)
        val toast = Toast.makeText(this, getData, Toast.LENGTH_SHORT)
        toast.show()
        Handler().postDelayed(Runnable {
            run(){
                toast.cancel()
            }
        },1000)

        // 이제 이미지를 넘어온 데이터를 바탕으로 바꾼다.
        if(getData=="1"){
            memberImage.setImageResource(R.drawable.member_1)
        }
        else if(getData=="2"){
            memberImage.setImageResource(R.drawable.member_2)
        }else if(getData=="3"){
            memberImage.setImageResource(R.drawable.member_3)
        }else if(getData=="4"){
            memberImage.setImageResource(R.drawable.member_4)
        }else if(getData=="5"){
            memberImage.setImageResource(R.drawable.member_5)
        }else if(getData=="6"){
            memberImage.setImageResource(R.drawable.member_6)
        }else if(getData=="7"){
            memberImage.setImageResource(R.drawable.member_7)
        }else if(getData=="8"){
            memberImage.setImageResource(R.drawable.member_8)
        }else{
            memberImage.setImageResource(R.drawable.member_9)
        }
    }
}