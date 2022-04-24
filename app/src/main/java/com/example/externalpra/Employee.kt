package com.example.externalpra

 class Employee(var Emp_name:String, var Emp_desc: String, var Emp_salary: Int) {
         var Emp_id:Int = 0
         constructor(emp_id:Int, Emp_name:String ,Emp_desc: String,Emp_salary: Int): this(Emp_name, Emp_desc,Emp_salary)
         {
             this.Emp_id =Emp_id
         }
     }
