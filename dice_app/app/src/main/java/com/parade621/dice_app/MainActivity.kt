package com.parade621.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.parade621.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var toast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.diceStartBtn.setOnClickListener{
            toast?.cancel()
            toast=Toast.makeText(this,"주사위 GO!", Toast.LENGTH_SHORT)
            toast?.show()

            Log.d("MainActivity",Random.nextInt(1,6).toString())
            val num1 = Random.nextInt(1,6)
            val num2 = Random.nextInt(1,6)
            if (num1 == 1){
                binding.dice1.setImageResource(R.drawable.dice_1)
            }else if(num1 == 2){
                binding.dice1.setImageResource(R.drawable.dice_2)
            }else if(num1 == 3){
                binding.dice1.setImageResource(R.drawable.dice_3)
            }else if(num1 == 4){
                binding.dice1.setImageResource(R.drawable.dice_4)
            }else if(num1 == 5){
                binding.dice1.setImageResource(R.drawable.dice_5)
            }else if(num1 == 6){
                binding.dice1.setImageResource(R.drawable.dice_6)
            }
            when (num2){
                1-> binding.dice2.setImageResource(R.drawable.dice_1)
                2-> binding.dice2.setImageResource(R.drawable.dice_2)
                3-> binding.dice2.setImageResource(R.drawable.dice_3)
                4-> binding.dice2.setImageResource(R.drawable.dice_4)
                5-> binding.dice2.setImageResource(R.drawable.dice_5)
                6-> binding.dice2.setImageResource(R.drawable.dice_6)
            }


        }

    }
}