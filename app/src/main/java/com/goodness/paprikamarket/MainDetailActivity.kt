package com.goodness.paprikamarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class MainDetailActivity : AppCompatActivity() {
	private val homeButton by lazy { findViewById<ImageView>(R.id.iv_home) }
	private val productImg by lazy { findViewById<ImageView>(R.id.iv_product) }
	private val productTitle by lazy { findViewById<TextView>(R.id.tv_product_title) }
	private val productDesc by lazy { findViewById<TextView>(R.id.tv_product_desc) }

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main_detail)

		init()
	}

	private fun init() {
		val key = intent.getIntExtra("key", 0)

		val product = when (key) {
			0 -> Product(
				R.drawable.main_product1,
				getString(R.string.main_product_1),
				getString(R.string.main_product_desc_1)
			)

			1 -> Product(
				R.drawable.main_product2,
				getString(R.string.main_product_2),
				getString(R.string.main_product_desc_2)
			)

			else -> Product(0, "", "")
		}

		Log.d("debug", getString(R.string.main_product_desc_1))

		productImg.setImageResource(product.imgResId)
		productTitle.text = product.title
		productDesc.text = product.desc

		homeButton.setOnClickListener {
			finish()
			overridePendingTransition(R.anim.main_none, R.anim.main_left_to_right)
		}
	}
}