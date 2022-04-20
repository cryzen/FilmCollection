package com.example.filmcollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.filmcollection.databinding.ActivityMainBinding
import com.example.filmcollection.fragments.HomeFragment
import com.example.filmcollection.fragments.ProfileFragment
import com.example.filmcollection.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null){
            replaceFragment(homeFragment)
            chooseFragment()
        }
    }

    override fun onBackPressed() {
        val selectedItem = binding.bNav.selectedItemId

        if (R.id.home != selectedItem) {
            replaceFragment(homeFragment)
            binding.bNav.selectedItemId = R.id.home
        } else {
            super.onBackPressed()
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.right_in, R.anim.right_out, R.anim.right_in, R.anim.right_out)
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    private fun chooseFragment() {
        binding.bNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.search -> replaceFragment(searchFragment)
                R.id.profile -> replaceFragment(profileFragment)
            }
            true
        }
    }
}