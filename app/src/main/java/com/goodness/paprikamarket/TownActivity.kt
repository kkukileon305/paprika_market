package com.goodness.paprikamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class TownActivity : AppCompatActivity() {
	private val postButtons by lazy {
		listOf<ConstraintLayout>(
			findViewById(R.id.cl_post1),
			findViewById(R.id.cl_post2),
		)
	}

	private val homeButton by lazy { findViewById<ConstraintLayout>(R.id.cl_home) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_town)

		init()
	}

	private fun init() {
		homeButton.setOnClickListener {
			finish()
			overridePendingTransition(R.anim.main_none, R.anim.main_left_to_right)
		}

		postButtons.forEachIndexed { index, postButton ->
			postButton.setOnClickListener {
				val intent = Intent(this, TownDetailActivity::class.java)
				intent.putExtra("key", index)
				startActivity(intent)

				overridePendingTransition(R.anim.main_right_to_left, R.anim.main_none)
			}
		}
	}
}