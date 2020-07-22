package com.example.vannakimhai.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.vannakimhai.Fragment.AccountFragment
import com.example.vannakimhai.Fragment.CategoryFragment
import com.example.vannakimhai.Fragment.HomeFragment
import com.example.vannakimhai.Fragment.SearchFragment
import com.example.vannakimhai.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        // Show ProductsFragment as default
        showFragment(HomeFragment())

        // Handle event when user clicks on Bottom Nav items
        bottomNav.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.mnu_home -> {
                    supportActionBar!!.setTitle(R.string.Home)
                    showFragment(HomeFragment())
                }
                R.id.mnu_category -> {
                    supportActionBar!!.setTitle(R.string.Categories)
                    showFragment(CategoryFragment())
                }
                R.id.mnu_seach -> {
                    supportActionBar!!.setTitle(R.string.Search)
                    showFragment(SearchFragment())
                }
                R.id.mnu_account -> {
                    supportActionBar!!.setTitle(R.string.Search)
                    showFragment(AccountFragment())
                }
            }

            true
        }
    }

    private fun showFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.lytFragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}
