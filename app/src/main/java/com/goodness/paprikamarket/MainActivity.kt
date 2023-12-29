package com.goodness.paprikamarket

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Locale

class MainActivity : AppCompatActivity() {
	private val productButtons by lazy {
		listOf<ConstraintLayout>(
			findViewById(R.id.cl_product1),
			findViewById(R.id.cl_product2)
		)
	}

	private val townButton by lazy { findViewById<ConstraintLayout>(R.id.cl_town) }
	private val translate by lazy { findViewById<ImageView>(R.id.iv_menu) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		init()
	}

	private fun init() {
		townButton.setOnClickListener {
			val intent = Intent(this, TownActivity::class.java)

			startActivity(intent)
			overridePendingTransition(R.anim.main_right_to_left, R.anim.main_none)
		}

		productButtons.forEachIndexed { index, productButton ->
			productButton.setOnClickListener {
				val intent = Intent(this, MainDetailActivity::class.java)
				intent.putExtra("key", index)
				startActivity(intent)

				overridePendingTransition(R.anim.main_right_to_left, R.anim.main_none)
			}
		}

		translate.setOnClickListener {
			val cur = resources.configuration.locales[0].language

			val newLocale = Locale(if (cur == "en") "kr" else "en")

			val configuration = Configuration(resources.configuration)
			configuration.setLocale(newLocale)

			baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)
			recreate()
		}
	}
}

