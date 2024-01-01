package com.goodness.paprikamarket

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    // Bottom navigation Buttons and Icons
    private val navButtons: List<LinearLayout> by lazy {
        listOf(
            findViewById(R.id.btn_nav_home),
            findViewById(R.id.btn_nav_news),
            findViewById(R.id.btn_nav_nearby),
            findViewById(R.id.btn_nav_chat),
            findViewById(R.id.btn_nav_profile)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setListeners()
    }

    private fun setListeners() {
        navButtons.forEach { it.setNavButtonListener() }
    }

    private fun LinearLayout.setNavButtonListener() {
        setOnClickListener {
            val index = navButtons.indexOf(this)
            if (index != -1) {
                val activityNames = arrayOf(
                    "MainActivity",
                    "NewsActivity",
                    "NearActivity",
                    "ChatActivity",
                    "ProfileActivity"
                )
                makeIntent(activityNames[index])
            }
        }
    }

    private fun makeIntent(activityName: String) {
        Intent(
            this@ProfileActivity,
            Class.forName("com.goodness.paprikamarket.$activityName")
        ).also {
            startActivity(
                it,
                ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
            )
        }
    }
}