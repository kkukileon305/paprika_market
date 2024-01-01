package com.goodness.paprikamarket

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text

class SignUpActivity : AppCompatActivity() {

	private val btn_start2 by lazy { findViewById<TextView>(R.id.tv_signup2) }
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_signup)

		btn_start2.setOnClickListener {
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)

		}

	}
}