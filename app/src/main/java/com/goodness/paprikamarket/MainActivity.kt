package com.goodness.paprikamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
	private val productButtons by lazy {
		listOf<ConstraintLayout>(
			findViewById(R.id.cl_product1),
			findViewById(R.id.cl_product2)
		)
	}

	private val townButton by lazy { findViewById<ConstraintLayout>(R.id.cl_town) }

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
	}
}

