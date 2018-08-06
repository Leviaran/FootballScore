package com.example.ran.footballclubv2.screen.prev_match

import android.graphics.Color
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.ran.footballclubv2.R
import org.jetbrains.anko.*

class PrevMatchItemUI : AnkoComponent<ViewGroup> {

    override fun createView(ui: AnkoContext<ViewGroup>) : View = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)
            orientation = LinearLayout.VERTICAL

            textView {
                id = R.id.date_match_item
                text = "Sen, 05 Agus 2018"
                textColor = ContextCompat.getColor(context,R.color.colorPrimary)
                gravity = Gravity.CENTER_HORIZONTAL
            }.setTypeface(textView().typeface, Typeface.BOLD)

            linearLayout {
                lparams(matchParent, wrapContent)
                orientation = LinearLayout.HORIZONTAL

                textView {
                    id = R.id.home_match_item
                    text = "Arsenal"
                }

                textView {
                    id = R.id.home_score_item
                    text = "3"
                }

                textView {
                    text = "vs"

                }.setTypeface(textView().typeface, Typeface.BOLD)

                textView {
                    id = R.id.away_score_item
                    text = "Arsenal"
                }

                textView {
                    id = R.id.away_match_item
                    text = "Arsenal"
                }

            }
        }
    }

}