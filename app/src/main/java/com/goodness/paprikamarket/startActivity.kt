package com.goodness.paprikamarket

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.MenuInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class StartActivity : AppCompatActivity() {

    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val btn_start = findViewById<TextView>(R.id.tv_start1)
        val btn_signup = findViewById<TextView>(R.id.tv_signup1)
        val et_nickname = findViewById<EditText>(R.id.et_nickname)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val user_nickname = it.data?.getStringExtra("nickname") ?:""
                et_nickname.setText(user_nickname)
            }
        }


        btn_start.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btn_signup.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        val languageButton: ImageButton = findViewById(R.id.languageButton)

        languageButton.setOnClickListener {
            showPopupMenu(languageButton)
        }

    }

    private fun showPopupMenu(view: View) {
        val popup = PopupMenu(this, view, Gravity.END)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.language_menu, popup.menu)
        popup.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_korean -> changeLanguage("ko")
                R.id.menu_english -> changeLanguage("en")
                // Add more language options as needed
            }
            true
        }
        popup.show()
    }

    private fun changeLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val config = Configuration()
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)

        val intent = Intent(this, StartActivity::class.java)
        startActivity(intent)
        finish()
    }

}
