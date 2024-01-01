package com.goodness.paprikamarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SignInActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val btn_signin = findViewById<TextView>(R.id.tv_signin)

        btn_signin.setOnClickListener{

            setResult(RESULT_OK, intent)

            if (!isFinishing) finish()
        }


    }
}