package com.example.ran.footballclubv2

import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.view.View
import com.example.ran.footballclubv2.adapter.FootballPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tab_icon_layout.*
import kotlinx.android.synthetic.main.tab_icon_layout.view.*
import org.jetbrains.anko.tabWidget

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        view_pager.adapter = FootballPagerAdapter(supportFragmentManager, this)
        sliding_tab.setupWithViewPager(view_pager)
        initIconTab()

        sliding_tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabIconColor = ContextCompat.getColor(this@MainActivity, android.R.color.white)
                tab?.icon?.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabIconColor = ContextCompat.getColor(this@MainActivity, R.color.colorPrimary)
                tab?.icon?.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)

            }
        })

    }

    fun initIconTab(){

//        var imageResID = arrayOf(
//                ResourcesCompat.getDrawable(resources, R.drawable.ic_action_prev_match, null),
//                ResourcesCompat.getDrawable(resources, R.drawable.ic_action_next_match, null)
//        )

        var imageResID = arrayOf(
                R.drawable.ic_action_prev_match,
                R.drawable.ic_action_next_match
        )

        var textResId = arrayOf(
                R.string.prev_match,
                R.string.next_match
        )

        for (i in 0..1){
            val view1 = layoutInflater.inflate(R.layout.tab_icon_layout, null)
            view1.icon.setBackgroundResource(imageResID[i])
            view1.tv_keterangan.text = resources.getText(textResId[i])
            sliding_tab.getTabAt(i)?.customView = view1
//            sliding_tab.getTabAt(i)?.icon = imageResID[i]
        }

    }

}
