package com.goodness.paprikamarket

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
			0 -> Product(R.drawable.product1, "에어팟 프로", "9/31일 구매한 \n한달도 안된 제품이빈다. \n박풀 S급입니다.")
			1 -> Product(R.drawable.product2, "바이레도 블랑쉬 50ml", "ㄷㄷ \nㅁㄴㅇㄹ.")
			else -> Product(0, "", "") // 기본 처리
		}

		productImg.setImageResource(product.imgResId)
		productTitle.text = product.title
		productDesc.text = product.desc

		homeButton.setOnClickListener {
			finish()
			overridePendingTransition(R.anim.none, R.anim.left_to_right)
		}
	}
}