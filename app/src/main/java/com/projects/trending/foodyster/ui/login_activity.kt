package com.projects.trending.foodyster.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.projects.trending.foodyster.DBHelper
import com.projects.trending.foodyster.R
import com.projects.trending.foodyster.databinding.LogininActivityBinding
import com.projects.trending.foodyster.ui.onBoarding.viewPagerFragment

class login_activity : AppCompatActivity() {
    private lateinit var binding : LogininActivityBinding
    private lateinit var dbHelper: DBHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LogininActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbHelper = DBHelper(this)

        binding.btnLogin.setOnClickListener{

            var mail = binding.etEmail.text.toString()
            var pass = binding.etPass.text.toString()

            if (mail.isNotEmpty() && pass.isNotEmpty()) {
                val isUserAuthenticated = dbHelper.authenticateUser(mail, pass)
                if (isUserAuthenticated) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this," Wrong Credentials ",Toast.LENGTH_SHORT).show()
                }
            }
            else {
                Toast.makeText(this, "Fields Must be Filled", Toast.LENGTH_SHORT).show()
            }
//            startActivity(Intent(this, MainActivity::class.java))
//            finish()
            dbHelper.close()
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this,signupactivity::class.java))
            finish()

        }

        binding.tvForgetPass.setOnClickListener{
            startActivity(Intent(this, forgetPass::class.java))
            finish()
        }


    }
}
