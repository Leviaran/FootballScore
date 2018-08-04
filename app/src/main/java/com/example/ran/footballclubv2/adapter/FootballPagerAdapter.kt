package com.example.ran.footballclubv2.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import android.util.Log
import com.example.ran.footballclubv2.R
import com.example.ran.footballclubv2.screen.prev_match.PrevMatchFragment


const val PAGE_COUNT = 2

class FootballPagerAdapter(var fm : FragmentManager, var context: Context) : FragmentPagerAdapter(fm) {

    var imageResID = arrayOf(
            R.drawable.ic_action_prev_match,
            R.drawable.ic_action_next_match
    )

    private var tabtitle = arrayOf("prev match", "next match")

    override fun getItem(position: Int): Fragment = PrevMatchFragment().newInstances(position +1)

    override fun getCount(): Int = PAGE_COUNT

    override fun getPageTitle(position: Int): CharSequence? {
//        var image = ContextCompat.getDrawable(context, imageResID[position])
//        image?.setBounds(0, 0, image.intrinsicWidth, image.intrinsicHeight)
//
//        var sb = SpannableString(" \n" + tabtitle[position])
//        var imagespan = ImageSpan(image, ImageSpan.ALIGN_BOTTOM)
//        sb.setSpan(imagespan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return tabtitle[position]
    }

}