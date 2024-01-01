package com.goodness.paprikamarket

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class ChatActivity : AppCompatActivity() {

    // Chat Room
    private val clUserChat1: ConstraintLayout by lazy { findViewById(R.id.cl_user_chat1) }
    private val clUserChat2: ConstraintLayout by lazy { findViewById(R.id.cl_user_chat2) }

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
        setContentView(R.layout.activity_chat)

        setListeners()
    }

    private fun setListeners() {
        clUserChat1.setOnClickListener { makeIntent("ChatRoomActivity") }
        clUserChat2.setOnClickListener { makeIntent("ChatRoomActivity") }

        navButtons.forEach { it.setNavButtonListener() }
    }

    private fun LinearLayout.setNavButtonListener() {
        setOnClickListener {
            val index = navButtons.indexOf(this)
            if (index != -1) {
                val activityNames = arrayOf("MainActivity", "NewsActivity", "NearActivity", "ChatActivity", "ProfileActivity")
                makeIntent(activityNames[index])
            }
        }
    }

    private fun makeIntent(activityName: String) {
        Intent(this@ChatActivity, Class.forName("com.goodness.paprikamarket.$activityName")).also {
            startActivity(it)
        }
    }
}
