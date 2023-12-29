package com.goodness.paprikamarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class TownDetailActivity : AppCompatActivity() {
	private val homeButton by lazy { findViewById<ImageView>(R.id.iv_home) }
	private val title by lazy { findViewById<TextView>(R.id.tv_post_title) }
	private val desc by lazy { findViewById<TextView>(R.id.tv_post_desc) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_town_detail)

		val key = intent.getIntExtra("key", 0)

		val post = when (key) {
			0 -> Post("맥주마실 사람~~", "쪽지주지마세요 ㄱㄱ!!")
			1 -> Post("글 2", "asd ㄱㄱ!!")
			else -> Post("", "")
		}

		title.text = post.title
		desc.text = post.desc

		homeButton.setOnClickListener {
			finish()
			overridePendingTransition(R.anim.main_none, R.anim.main_left_to_right)
		}
	}
}