package com.example.pre.Controller.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pre.Controller.Fragment.Top_Four_Fragment.AccountFragment
import com.example.pre.Controller.Fragment.Top_Four_Fragment.InformationFragment
import com.example.pre.Controller.Fragment.Top_Four_Fragment.PostFragment
import com.example.pre.Controller.Fragment.Top_Four_Fragment.SearchFragment
import com.example.pre.R
import com.example.pre.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = BottomNavigationPagerAdapter(this)
        binding.viewPager.isUserInputEnabled = false

        binding.bottomNavigation.setOnItemSelectedListener {
            val currentItem = getCurrentItem(it.itemId)
            binding.viewPager.setCurrentItem(currentItem, true)
            return@setOnItemSelectedListener true
        }

        return binding.root
    }

    private fun getCurrentItem(itemId: Int): Int {
        return when (itemId) {
            R.id.nav_Search -> 0
            R.id.nav_Post -> 1
            R.id.nav_Information -> 2
            R.id.nav_Account -> 3
            else -> 0
        }
    }

    class BottomNavigationPagerAdapter(fm: MainFragment) : FragmentStateAdapter(fm) {
        override fun getItemCount(): Int {
            return 4
        }

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> {
                    SearchFragment()
                }
                1 -> {
                    PostFragment()
                }
                2 -> {
                    InformationFragment()
                }
                3 -> {
                    AccountFragment()
                }
                else -> {
                    SearchFragment()
                }
            }
        }
    }
}