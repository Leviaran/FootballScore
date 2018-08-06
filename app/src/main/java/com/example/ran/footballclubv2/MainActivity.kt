package com.example.ran.footballclubv2

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.ran.footballclubv2.screen.prev_match.PrevMatchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val onNavigationSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {
                item -> when (item.itemId) {
                R.id.prev_match -> {
                    item.isCheckable = true
                    val prevMatchFragment = PrevMatchFragment.newInstance()
                    openFragment(prevMatchFragment)
                    return@OnNavigationItemSelectedListener  true
                }
                R.id.next_match -> {
                    return@OnNavigationItemSelectedListener  true
                }
            }
                false
            }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationSelectedListener)
        bottomNavigation.selectedItemId = R.id.prev_match

    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}
