package com.goodness.paprikamarket

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btn_start = findViewById<TextView>(R.id.tv_signup2)

        btn_start.setOnClickListener{

            setResult(RESULT_OK, intent)

            if (!isFinishing) finish()

        }

    }
}