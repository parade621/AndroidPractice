package com.parade621.codelab_recyclerview_ex.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parade621.codelab_recyclerview_ex.R
import com.parade621.codelab_recyclerview_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}