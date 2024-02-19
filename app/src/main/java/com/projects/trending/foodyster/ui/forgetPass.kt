package com.projects.trending.foodyster.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.projects.trending.foodyster.DBHelper
import com.projects.trending.foodyster.databinding.LogininActivityBinding
import com.projects.trending.foodyster.databinding.ResetpassBinding

class forgetPass : AppCompatActivity() {
    private lateinit var binding : ResetpassBinding
    private lateinit var dbhelper : DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResetpassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbhelper = DBHelper(this)

        binding.reset.setOnClickListener{
            var mail = binding.etEmail.text.toString()
            var pass = binding.etPass.text.toString()

            val isMailValid = dbhelper.authenticateEmail(mail)
            if(isMailValid){

                val passReset = dbhelper.resetPassword(mail,pass)
                if(passReset) {
                    startActivity(Intent(this,login_activity::class.java))
                    Toast.makeText(this,"Password Reset Successfully", Toast.LENGTH_SHORT).show()
                    finish()
                }
                else{
                    Toast.makeText(this,"Password Reset Failed", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this,"Not a Valid User", Toast.LENGTH_SHORT).show()
            }
        }

        dbhelper.close()

    }
}