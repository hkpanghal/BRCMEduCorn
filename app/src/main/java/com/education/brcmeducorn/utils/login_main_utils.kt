package com.education.brcmeducorn.utils

import android.content.Context
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.education.brcmeducorn.activites.AdminDashboardActivity
import com.education.brcmeducorn.activites.StudentDashboardActivity
import com.education.brcmeducorn.activites.FacultyDashboardActivity
import com.education.brcmeducorn.R

class login_main_utils {

    companion object {
       var student_user=1;
        var faculty_user=0;
        var admin_user=0;
    }
    fun adjustColor(context: Context, role:TextView, studentBtn:Button, facultyBtn:Button, adminBtn:Button)
    {
        //        managing the click on the login users

//        1 -> student
        studentBtn.setOnClickListener {

            //set the student user to handle the login
            student_user = 1
            //set the faculty and the admin user to zero
            faculty_user=0
            admin_user=0

            role.text = "Student Login"
            //set the  background color and the text color
            setSelfColor(studentBtn,context);

            //set the other users background color and text color
            setOtherUser(facultyBtn,adminBtn,context);
        }

//        2 -> faculty
        facultyBtn.setOnClickListener {
            //set the faculty user to handle the login
            faculty_user = 1

            // set the admin and student user to zero
            student_user=0;
            admin_user=0;

            role.text = "Faculty Login"

            //set the  background color and the text color
            setSelfColor(facultyBtn,context);

            //set the other users background color and text color
            setOtherUser(studentBtn,adminBtn,context);
        }

//        3 -> admin
        adminBtn.setOnClickListener {

            //set the admin user to handle the login
            admin_user = 1
            // set the faculty and student user to zero
            student_user=0;
            faculty_user=0;

            role.text = "Admin Login"
            //set the  background color and the text color
            setSelfColor(adminBtn,context);

            //set the other users background color and text color
            setOtherUser(studentBtn,facultyBtn,context);
        }
    }

    fun setOtherUser(btn1:Button,btn2:Button,context: Context)
    {
        // set color of other user to appPrimary
        btn1.setBackgroundColor(ContextCompat.getColor(context,R.color.appPrimary))
        btn2.setBackgroundColor(ContextCompat.getColor(context,R.color.appPrimary))

        // set the text color of other users to white
        btn1.setTextColor(ContextCompat.getColor(context,R.color.white))
        btn2.setTextColor(ContextCompat.getColor(context,R.color.white))
    }

    fun setSelfColor(btn:Button,context: Context)
    {
        btn.setTextColor(ContextCompat.getColor(context,R.color.black))
        btn.setBackgroundColor(ContextCompat.getColor(context,R.color.white))

    }

    fun handleLogin(context: Context)
    {

        if(student_user == 1 && faculty_user==0 && admin_user == 0)
        {
           val intent = Intent(context, StudentDashboardActivity::class.java)
            startActivity(context,intent,null)
        }
        else if(faculty_user == 1 && student_user==0 && admin_user==0 )
        {
            val intent = Intent(context, FacultyDashboardActivity::class.java)
            startActivity(context,intent,null)
        }
        else if(admin_user == 1 && faculty_user==0 && student_user==0 )
        {
            val intent = Intent(context, AdminDashboardActivity::class.java)
            startActivity(context,intent,null)
        }
        else
        {
            android.widget.Toast.makeText(context,"please select a valid user", android.widget.Toast.LENGTH_SHORT).show()
        }
    }

}