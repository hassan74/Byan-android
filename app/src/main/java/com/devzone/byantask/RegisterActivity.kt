package com.devzone.byantask

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        findViewById<TextView>(R.id.tv_login).setOnClickListener {
            startActivity(Intent(this  ,LoginActivity::class.java))
        }
        findViewById<TextView>(R.id.bt_register).setOnClickListener {
            startActivity(Intent(this  ,HomeActivity::class.java))
        }
    }
}