package com.projects.trending.foodyster.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.projects.trending.foodyster.DBHelper
import com.projects.trending.foodyster.databinding.SignupActivityBinding

class signupactivity : AppCompatActivity()  {

    private lateinit var binding : SignupActivityBinding
    private lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SignupActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbHelper = DBHelper(this)

        binding.btnSignUp.setOnClickListener{
            var mail = binding.etEmail.text.toString()
            var pass = binding.etPass.text.toString()
            var cPass = binding.etConfirmPass.text.toString()
            if(mail.isNotEmpty() && pass.isNotEmpty() && cPass.isNotEmpty()){
                if(pass==cPass){
                    val newUserId = dbHelper.addUser(mail, pass)
                    startActivity(Intent(this,login_activity::class.java))
                    Toast.makeText(this, "Now LogIn", Toast.LENGTH_SHORT).show()
                    finish()

                }
                else{
                    Toast.makeText(this, "Password Doesn't Match", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Fields Con't be Empty",Toast.LENGTH_SHORT).show()
            }

//            startActivity(Intent(this, login_activity::class.java))
//            Toast.makeText(this, "Now LogIn", Toast.LENGTH_SHORT).show()
//            finish()
            dbHelper.close()
        }

        binding.tvLogIn.setOnClickListener{
            startActivity(Intent(this,login_activity::class.java))
            finish()
        }
    }
}