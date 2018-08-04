package com.example.ran.footballclubv2.screen.prev_match

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.bundleOf
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.textView

class PrevMatchFragment : Fragment() {

    companion object {
        const val ARGS_PAGE = "ARGS_PAGE"
    }

    private var mPage : Int? = 0

    fun newInstances(page : Int) : PrevMatchFragment{
        var args = bundleOf()
        args.putInt(ARGS_PAGE, page)
        var fragment = PrevMatchFragment()
        fragment.arguments = args
        return fragment

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPage = arguments?.getInt(ARGS_PAGE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {
            linearLayout {
                textView{
                    text = "Hello world"
                }
            }
        }.view
    }


}