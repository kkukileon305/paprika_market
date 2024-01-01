package com.goodness.paprikamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignInActivity : AppCompatActivity() {

	private val btn_start3 by lazy { findViewById<TextView>(R.id.tv_signin) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_signin)

		btn_start3.setOnClickListener {
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)

		}


	}
}