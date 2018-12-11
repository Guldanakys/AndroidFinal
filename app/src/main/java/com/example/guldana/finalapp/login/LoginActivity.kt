package com.example.guldana.finalapp.login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.guldana.finalapp.main.MainActivity
import com.example.guldana.finalapp.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("someId", "Logged successfully!")
            startActivity(intent)
            finish()
        }
    }
}
