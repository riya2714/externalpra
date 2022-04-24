package com.example.externalpra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnregister1.setOnClickListener {
            if (reusername.text.toString().equals("") || reage.text.toString().toInt().equals("")
                || repassword.text.toString().equals("")|| reemail.text.toString().equals("")
            ) {
                Toast.makeText(this, "Fill Data Accurately", Toast.LENGTH_LONG).show()
            } else if (repassword.text.toString().length <= 7) {
                Toast.makeText(this, "Password Must be 8 Character Long!", Toast.LENGTH_LONG).show()
            }
            else
            {
                var student = Student(repassword.text.toString(),reusername.text.toString(),reage.text.toString().toInt(),reemail.text.toString())
                var db = Dbhelper(this)

                var res = db.insertUser(student)
                if(res>0)
                {
                    Toast.makeText(this,"Register Successfully",Toast.LENGTH_LONG).show()
                    var intent = Intent(this,Login::class.java)
                    startActivity(intent)
                    finish()
                }
        }
    }
    }

}