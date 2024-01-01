package com.goodness.paprikamarket

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Gravity
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import java.util.Locale

class StartActivity : AppCompatActivity() {

    private val btn_start1 :Button by lazy{findViewById(R.id.tv_start1)}
    private val btn_signup1 :Button by lazy{findViewById(R.id.tv_signup1)}


    private lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        btn_start1.setOnClickListener{
            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)

        }

        btn_signup1.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)

        }

        val et_nickname = findViewById<EditText>(R.id.et_nickname)

        activityResultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val user_nickname = it.data?.getStringExtra("nickname") ?:""
                et_nickname.setText(user_nickname)
            }
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

        recreate()
    }
}
