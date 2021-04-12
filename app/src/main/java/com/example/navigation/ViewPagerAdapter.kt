package com.example.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(supportFragment: FragmentManager): FragmentPagerAdapter(supportFragment, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position){
            0 -> HomeFragment()
            else -> SearchFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Home"
            else -> "Search"
        }
    }
}