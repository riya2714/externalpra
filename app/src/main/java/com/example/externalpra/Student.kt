package com.example.externalpra

data class Student(var password: String, var username:String, var age: Int, var email: String) {
     var Id:Int = 0;
     constructor(Id:Int,password: String,username: String,age: Int,email: String):this(password,username,age,email)
     {
         this.Id = Id
     }
 }

