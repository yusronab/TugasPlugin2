package com.example.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        binding.viewPager.adapter = viewPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.Open,R.string.Close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.drawerNav.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ProfileDrawer -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.favoriteDrawer -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.inboxDrawer -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.SettingDrawer -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.helpDrawer -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.trashDrawer -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
                R.id.logoutDrawer -> Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            }
            true
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.bottomHome -> setFragment(HomeFragment())
                R.id.bottomSearch -> setFragment(SearchFragment())
            }
            true
        }
    }
    private fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer,fragment)
                .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}