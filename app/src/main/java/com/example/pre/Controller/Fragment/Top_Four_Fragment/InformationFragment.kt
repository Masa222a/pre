package com.example.pre.Controller.Fragment.Top_Four_Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.pre.databinding.FragmentInformationBinding
import com.google.android.material.tabs.TabLayoutMediator

class InformationFragment : Fragment() {
    private lateinit var binding: FragmentInformationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInformationBinding.inflate(inflater, container, false)

        binding.viewPager.adapter = CountriesAreaAdapter(this)
        binding.viewPager.isUserInputEnabled = false

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> {
                    "東・東南アジア"
                }
                1 -> {
                    "南・中央アジア"
                }
                2 -> {
                    "オセアニア"
                }
                3 -> {
                    "北米"
                }
                4 -> {
                    "中米"
                }
                5 -> {
                    "南米"
                }
                6 -> {
                    "ヨーロッパ"
                }
                7 -> {
                    "中東・北アフリカ"
                }
                else -> {
                    "アフリカ"
                }
            }.toString()
        }.attach()
    }

    class CountriesAreaAdapter(fm: Fragment) : FragmentStateAdapter(fm) {
        override fun getItemCount(): Int {
            return 8
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