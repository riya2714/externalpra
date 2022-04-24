package com.example.externalpra

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnregister.setOnClickListener {
            var intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
        btnlogin.setOnClickListener {
            var db = Dbhelper(this)
            var arr = ArrayList<Student>()
            arr = db.getUser(usename.text.toString())

//            if (usename.text.toString().equals(arr[0].username) && (password.text.toString()
//                    .equals(arr[0].password))
//            ) {
//                Toast.makeText(this, "validate User", Toast.LENGTH_LONG).show()
//            }
//            else {
//                Toast.makeText(this, "Not-validate User", Toast.LENGTH_LONG).show()
//            }
            if (usename.text.toString().equals("") || password.text.toString().equals("")) {
                Toast.makeText(this, "Fill Data Accurately", Toast.LENGTH_LONG).show()
            }
            else if ((usename.text.toString()
                    .equals(arr[0].username)) && (password.text.toString().equals(arr[0].password))
            ) {
                Toast.makeText(this, "Im called!", Toast.LENGTH_LONG).show()
                var intent = Intent(this, Homepage::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_LONG).show()
        }
    }
    }
