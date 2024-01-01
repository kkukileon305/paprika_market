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
	
	private val translate by lazy { findViewById<ImageView>(R.id.iv_menu) }

	private val menuButtons by lazy {
		listOf<ConstraintLayout>(
			findViewById(R.id.cl_town),
			findViewById(R.id.cl_near),
			findViewById(R.id.cl_chat),
			findViewById(R.id.cl_profile),
		)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		init()
	}

	private fun init() {
		menuButtons.forEach { button ->
			button.setOnClickListener {
				val activity = when (button.id) {
					R.id.cl_town -> TownActivity::class.java
					R.id.cl_near -> NearActivity::class.java
					R.id.cl_chat -> ChatActivity::class.java
					R.id.cl_profile -> ProfileActivity::class.java
					else -> null
				}
				val intent = Intent(this, activity)

				startActivity(intent)
			}
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

