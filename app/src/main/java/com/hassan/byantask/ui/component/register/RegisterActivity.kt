package com.hassan.byantask.ui.component.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.hassan.byantask.R
import com.hassan.byantask.ui.component.home.HomeActivity
import com.hassan.byantask.ui.component.login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        findViewById<TextView>(R.id.tv_login).setOnClickListener {
            startActivity(Intent(this  , LoginActivity::class.java))
        }
        findViewById<TextView>(R.id.bt_register).setOnClickListener {
            startActivity(Intent(this  , HomeActivity::class.java))
        }
    }
}