package com.goodness.paprikamarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityOptionsCompat
import com.google.android.material.tabs.TabLayout

class NearActivity : AppCompatActivity() {

    private val btnMore : Button by lazy { findViewById(R.id.btn_more) }
    private val btnLess : ConstraintLayout by lazy {findViewById(R.id.btn_less)  }

    private val menuIconMore : LinearLayout by lazy { findViewById(R.id.menu_icon_more) }
    private val btnPet : Button by lazy { findViewById(R.id.btn_pet) }

    private val tabStore : TabLayout by lazy { findViewById(R.id.tab_store) }
    private val storeRestaurant : ConstraintLayout by lazy { findViewById(R.id.store_restaurant) }
    private val storeHealth : ConstraintLayout by lazy { findViewById(R.id.store_health) }
    private val storeLife : ConstraintLayout by lazy { findViewById(R.id.store_life) }
    private val storeAll : ConstraintLayout by lazy { findViewById(R.id.store_all) }

    private val btnRestaurant : Button by lazy { findViewById(R.id.btn_restaurant) }


    private val clHome : ConstraintLayout by lazy { findViewById(R.id.cl_home) }
    private val clTown : ConstraintLayout by lazy { findViewById(R.id.cl_town) }
    private val clChat : ConstraintLayout by lazy { findViewById(R.id.cl_chat) }
    private val clMine : ConstraintLayout by lazy { findViewById(R.id.cl_mine) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_near)

        btnMore.setOnClickListener {
            menuIconMore.visibility = View.VISIBLE
            btnLess.visibility = View.VISIBLE
            btnMore.visibility = View.GONE
            btnPet.visibility = View.VISIBLE
        }

        btnLess.setOnClickListener{
            btnPet.visibility = View.GONE
            btnMore.visibility = View.VISIBLE
            menuIconMore.visibility = View.GONE
            btnLess.visibility = View.GONE
        }



        tabStore.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab) {
                when(tab.position){
                    0 -> {
                        storeRestaurant.visibility = View.VISIBLE
                        storeHealth.visibility = View.GONE
                        storeLife.visibility = View.GONE
                        storeAll.visibility = View.GONE
                    }

                    1 -> {
                        storeHealth.visibility = View.VISIBLE
                        storeRestaurant.visibility = View.GONE
                        storeLife.visibility = View.GONE
                        storeAll.visibility = View.GONE
                    }

                    2 -> {
                        storeHealth.visibility = View.GONE
                        storeRestaurant.visibility = View.GONE
                        storeLife.visibility = View.VISIBLE
                        storeAll.visibility = View.GONE
                    }

                    3 -> {
                        storeAll.visibility = View.VISIBLE
                        storeRestaurant.visibility = View.GONE
                        storeHealth.visibility = View.GONE
                        storeLife.visibility = View.GONE
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        btnRestaurant.setOnClickListener {
            val intent = Intent(this,NearFoodActivity::class.java)
            val options = ActivityOptionsCompat.makeCustomAnimation(this, R.anim.near_from_right_enter,R.anim.near_to_right_exit)
            startActivity(intent,options.toBundle())

        }

        clHome.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        clTown.setOnClickListener{
            val intent = Intent(this, TownActivity::class.java)
            startActivity(intent)
        }

        clChat.setOnClickListener{
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }
        clMine.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }


    }

}