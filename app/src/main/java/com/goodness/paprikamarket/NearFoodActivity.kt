package com.goodness.paprikamarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NearFoodActivity : AppCompatActivity() {

    val btnBack : Button by lazy { findViewById(R.id.btn_back) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_near_food)

        btnBack.setOnClickListener {
            finish()
        }
    }
}