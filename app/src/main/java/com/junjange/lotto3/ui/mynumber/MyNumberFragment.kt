package com.junjange.lotto3.ui.mynumber

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.junjange.lotto3.Adapter.MyNumberFragmentStatePagerAdapter
import com.junjange.lotto3.R
import com.junjange.lotto3.ui.home.HomeViewModel
import kotlinx.android.synthetic.main.fragment_my_number.*

class MyNumberFragment : Fragment() {

override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
): View? {

    return inflater.inflate(R.layout.fragment_my_number, container, false)

}

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        configureTopNavigation()
    }
    private fun configureTopNavigation(){

        vp_ac_mynumber_frag_pager.adapter =
            fragmentManager?.let { MyNumberFragmentStatePagerAdapter(it, 2) }

        tl_ac_mynumber_top_menu.setupWithViewPager(vp_ac_mynumber_frag_pager)

        val topNaviLayout: View = this.layoutInflater.inflate(R.layout.top_navigation_tab, null, false)

        tl_ac_mynumber_top_menu.getTabAt(0)!!.customView = topNaviLayout.findViewById(R.id.btn_top_navi_lotto640_tab) as RelativeLayout
        tl_ac_mynumber_top_menu.getTabAt(1)!!.customView = topNaviLayout.findViewById(R.id.btn_top_navi_lotto720_tab) as RelativeLayout
//      tl_ac_mynumber_top_menu.getTabAt(2)!!.customView = topNaviLayout.findViewById(R.id.btn_top_navi_america_tab) as RelativeLayout // 메가 밀리언 개발중..


    }
}