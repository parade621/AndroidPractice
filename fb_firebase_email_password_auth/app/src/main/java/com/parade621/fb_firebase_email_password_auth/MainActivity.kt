package com.parade621.fb_firebase_email_password_auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        val joinBtn = findViewById<Button>(R.id.joinBtn)
        val loginBtn = findViewById<Button>(R.id.joinBtn)
        val logoutBtn = findViewById<Button>(R.id.logoutBtn)
        val email = findViewById<EditText>(R.id.emailArea)
        val password = findViewById<EditText>(R.id.passwordArea)

        joinBtn.setOnClickListener {

            auth.createUserWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(baseContext,"성공",Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(baseContext, "실패", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        loginBtn.setOnClickListener {
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(baseContext,"환영합니다.",Toast.LENGTH_SHORT).show()
                    } else {

                        Toast.makeText(baseContext, "로그인 실패", Toast.LENGTH_SHORT).show()

                    }
                }
        }

        logoutBtn.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(baseContext,"로그아웃 완료", Toast.LENGTH_SHORT).show()
        }

    }
}