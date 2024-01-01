package com.goodness.paprikamarket

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.Locale

class TownActivity : AppCompatActivity() {
	private val postButtons by lazy {
		listOf<ConstraintLayout>(
			findViewById(R.id.cl_post1),
			findViewById(R.id.cl_post2),
		)
	}

	private val menuButtons by lazy {
		listOf<ConstraintLayout>(
			findViewById(R.id.cl_home),
			findViewById(R.id.cl_near),
			findViewById(R.id.cl_chat),
			findViewById(R.id.cl_profile),
		)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_town)

		init()
	}

	private fun init() {
		menuButtons.forEach { button ->
			button.setOnClickListener {
				val activity = when (button.id) {
					R.id.cl_home -> MainActivity::class.java
					R.id.cl_near -> NearActivity::class.java
					R.id.cl_chat -> ChatActivity::class.java
					R.id.cl_profile -> ProfileActivity::class.java
					else -> null
				}
				val intent = Intent(this, activity)

				startActivity(intent)
			}
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