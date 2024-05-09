package com.example.ghostrider

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.ghostrider.fragments.BookingFragment
import com.example.ghostrider.fragments.HomeFragment
import com.example.ghostrider.fragments.ListingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets





        }
        val homeFragment = HomeFragment()
        val bookingFragment = BookingFragment()
        val listingFragment = ListingFragment()
        //val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)



        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_favorite -> makeCurrentFragment(listingFragment)
                R.id.ic_car -> makeCurrentFragment(bookingFragment)
                //R.id.ic_person -> makeCurrentFragment(profileFragment)
            }
        }

    }
    private fun makeCurrentFragment(fragment:Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_layout, fragment)
            commit()
        }
}