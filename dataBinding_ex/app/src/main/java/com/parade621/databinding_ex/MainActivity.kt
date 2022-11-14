package com.parade621.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.parade621.databinding_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private var toast:Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 1번 방식 - findViewById 방식
        /*val btn = findViewById<Button>(R.id.testBtnId)
        btn.setOnClickListener{
            Toast.makeText(this, "click", Toast.LENGTH_LONG).show()
        }*/

        // 2번 방식 - DataBinding 방식
        binding.testBtnId.setOnClickListener {
            toast?.cancel()
            toast = Toast.makeText(applicationContext, "click", Toast.LENGTH_LONG)
            toast?.show()
        }

    }
}