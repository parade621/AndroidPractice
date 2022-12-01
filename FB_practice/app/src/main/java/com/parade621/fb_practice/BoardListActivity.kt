package com.parade621.fb_practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.parade621.fb_practice.databinding.ActivityBoardListBinding

class BoardListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityBoardListBinding
    private lateinit var LVAdapter : ListViewAdapter

    val list = mutableListOf<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_list)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_board_list)

        binding.writeBtn.setOnClickListener {
            val intent = Intent(this, BoardWriteActivity::class.java)
            startActivity(intent)
        }
        getData()
        LVAdapter = ListViewAdapter(list)
        binding.lv.adapter = LVAdapter
    }

    fun getData(){


        val database = Firebase.database
        val myRef = database.getReference("message")

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                Log.d("datasnapshot",dataSnapshot.toString())

                for (dataModel in dataSnapshot.children){
                    val item = dataModel.getValue(Model::class.java)
                    Log.d("datasnapshot",item.toString())
                    list.add(item!!)
                }
                LVAdapter.notifyDataSetChanged() // 비동기 동기화
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("BoardListActivity", "loadPost:onCancelled", databaseError.toException())
            }
        }
        myRef.addValueEventListener(postListener)
    }
}