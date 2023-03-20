package com.junjange.lotto3.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.junjange.lotto3.MyNumberFragment.AmericaNumberFragment
import com.junjange.lotto3.MyNumberFragment.lotto645NumberFragment
import com.junjange.lotto3.MyNumberFragment.lotto720NumberFragment

class MyNumberFragmentStatePagerAdapter(fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return lotto645NumberFragment()
            1 -> return lotto720NumberFragment()
            2 -> return AmericaNumberFragment()
            else -> return Fragment()
        }
    }

    override fun getCount(): Int = fragmentCount

}