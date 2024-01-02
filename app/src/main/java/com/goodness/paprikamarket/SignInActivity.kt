package com.goodness.paprikamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class SignInActivity : AppCompatActivity() {

	private val btn_signin by lazy { findViewById<LinearLayout>(R.id.ll_signin) }
	private val btn_signup by lazy { findViewById<LinearLayout>(R.id.ll_signup) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_signin)

		btn_signin.setOnClickListener {
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)
		}

		btn_signup.setOnClickListener {
			val intent = Intent(this, SignUpActivity::class.java)
			startActivity(intent)
		}


	}
}