package com.parade621.materialCardView_ex.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.parade621.materialCardView_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}