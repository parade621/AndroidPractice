package com.parade621.diet_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        val listView = findViewById<ListView>(R.id.mainListView)
        val LVadapter = ListViewAdapter(dataModelList)

        listView.adapter = LVadapter

        // 데이터 불러오기 부분
        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                dataModelList.clear()
                for (dataModel in snapshot.children){
                    Log.d("data",dataModel.toString())
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)
                }
                LVadapter.notifyDataSetChanged() // 데이터가 추가되면 ListView에 새롭게 대이터를 쏴줌
                Log.d("DataModel", dataModelList.toString())
            }

        })

        val writeBtn = findViewById<ImageView>(R.id.writeBtn)
        writeBtn.setOnClickListener {

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()

            val DataSelectBtn = mAlertDialog.findViewById<Button>(R.id.dataSelectBtn)

            var dateText = ""

            mAlertDialog.findViewById<Button>(R.id.dataSelectBtn)?.setOnClickListener {

                val today = GregorianCalendar()
                val year :Int = today.get(Calendar.YEAR)
                val month:Int = today.get(Calendar.MONTH)
                val dayOfMonth:Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object:DatePickerDialog.OnDateSetListener{
                    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayofMonth: Int) {
                        Toast.makeText(baseContext,"${year}, ${month+1}, ${dayofMonth}",Toast.LENGTH_SHORT).show()
                        DataSelectBtn?.setText("${year}, ${month+1}월 ${dayofMonth}일")
                        dateText = "${year}년 ${month+1}월 ${dayofMonth}일"
                    }
                }, year,month,dayOfMonth)
                dlg.show()
            }

            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            saveBtn?.setOnClickListener {

                val healthMemo = mAlertDialog.findViewById<EditText>(R.id.healthMemo)?.text.toString()

                val database = Firebase.database
                val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid)

                val model = DataModel(dateText,healthMemo)

                myRef
                    .push()
                    .setValue(model)

                mAlertDialog.dismiss()

            }
        }

    }

}