package com.example.externalpra

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Dbhelper (var context: Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VER) {
    companion object {
        private val DB_NAME = "PracticeDB"
        private val TB_USER = "Studentdetails"
        private val TB_STUDENT = "student"
        private val DB_VER = 1

        private val ID = "U_Id"
        private val PASSWORD = "U_Password"
        private val USERNAME = "U_Username"
        private val EMAIL = "U_Email"
        private val AGE = "U_Age"

        private val ID_emp = "id"
        private val EMP_NAME = "name"
        private val EMP_DESC = "des"
        private val EMP_SALARY = "salary"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
        var sql1 =
            "CREATE TABLE $TB_USER ($ID INTEGER PRIMARY KEY AUTOINCREMENT, $PASSWORD TEXT, $USERNAME TEXT, $AGE INTEGER, $EMAIL TEXT)"

        var sql2 = "CREATE TABLE $TB_STUDENT ($ID_emp INTEGER PRIMARY KEY AUTOINCREMENT, $EMP_NAME TEXT,$EMP_DESC TEXT, $EMP_SALARY INTEGER)"

        p0?.execSQL(sql1)
        p0?.execSQL(sql2)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
    fun insertUser(student : Student): Long
    {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put(EMAIL,student.email)
        cv.put(AGE,student.age)
        cv.put(PASSWORD, student.password)

        var res = db.insert(TB_USER,null,cv)
        return res
        db.close()
    }
    fun getUser(uname:String): ArrayList<Student>
    {
        var db = readableDatabase
        var sql = "Select * from $TB_USER where $USERNAME = '$uname'"
        var arr = ArrayList<Student>()
        var cursor = db.rawQuery(sql,null)
        while(cursor.moveToNext())
        {
            var id = cursor.getInt(0)
            var username = cursor.getString(1)
            var password = cursor.getString(2)
            var email = cursor.getString(3)
            var age = cursor.getInt(4)

            var us= Student(id,username,password,age,email)

            arr.add(us)
        }
        return arr
        db.close()
    }
    fun insertemployee(emp:Employee) :Long
    {
        var db = writableDatabase
        var cv = ContentValues()
        cv.put(EMP_NAME,emp.Emp_name)
        cv.put(EMP_DESC,emp.Emp_desc)
        cv.put(EMP_SALARY,emp.Emp_salary)


        var res = db.insert(TB_STUDENT,null,cv)
        return res
        db.close()
    }
}
