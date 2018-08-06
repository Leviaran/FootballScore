package com.example.ran.footballclubv2.screen.detail_match

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.example.ran.footballclubv2.R
import com.example.ran.footballclubv2.common.domain.model.Events
import kotlinx.android.synthetic.main.notification_template_lines_media.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI


const val DETAIL_EVENT = "detail_event"

class DetailMatch : Fragment() {

    var events: Events? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = this.arguments
        when {
            (bundle != null) -> events = bundle.getParcelable<Events>(DETAIL_EVENT)
             else -> return
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return UI {

            verticalLayout {
                orientation = LinearLayout.VERTICAL
                lparams(matchParent, matchParent)

                textView {
                    id = R.id.date_match_item
                    text = "Sen, 05 Agus 2018"
                    textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                    gravity = Gravity.CENTER_HORIZONTAL
                }.setTypeface(textView().typeface, Typeface.BOLD)

                relativeLayout {
//                    orientation = LinearLayout.HORIZONTAL
                    lparams(matchParent, dip(100))

                    // One Layout for badge and text
                    linearLayout {
                        id = R.id.home_match_item
                        orientation = LinearLayout.VERTICAL
                        gravity = Gravity.END

                        imageView(R.drawable.avd_show_password) {
//                            Glide.with(this).load(events.strTeamHomeBadge).into(this)
                        }.lparams(dip(50), dip(50))

                        // Score Home Layout
                        textView {
                            id = R.id.home_match_item
                            text = "Arsenal"
                            textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                            textSize = dip(9).toFloat()
                            gravity = Gravity.END
                        }

                    }.lparams(dip(80), wrapContent){leftOf(R.id.home_score_item);leftMargin = dip(10)}

                    ///////////////////////////////
                    textView {
                        id = R.id.home_score_item
                        text = "3"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        textSize = dip(10).toFloat()

                    }.lparams(){leftOf(R.id.tv_vs_item);leftMargin = dip(10); topMargin = dip(15)}

                    textView {
                        id = R.id.tv_vs_item
                        text = "VS"
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)

                    }.lparams(){centerHorizontally(); margin = dip(15)}

                    textView {
                        id = R.id.away_score_item
                        text = "3"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        textSize = dip(10).toFloat()
                    }.lparams(){rightOf(R.id.tv_vs_item);rightMargin = dip(10); topMargin = dip(15)}

                    ///////////////////////////////
                    linearLayout {
                        id = R.id.away_match_item
                        orientation = LinearLayout.VERTICAL

                        imageView(R.drawable.avd_show_password) {
//                            Glide.with(this).load(events.strTeamAwayBadge).into(this)
                        }.lparams(dip(50), dip(50))

                        // Score Home Layout
                        textView {
                            id = R.id.away_match_item
                            text = "Arsenal"
                            textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                            textSize = dip(9).toFloat()
                        }

                    }.lparams(dip(80), wrapContent){rightOf(R.id.away_score_item);rightMargin = dip(10)}
                }

                //////////////////
                view {
                    backgroundColor = Color.LTGRAY
                }.lparams(matchParent, dip(1)){margin = dip(10)}

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    weightSum = 5f

                    textView {
                        id = R.id.df_home_goal
                        text = "(10) Modric"

                    }.lparams(){weight = 2f}

                    textView {
                        text = "Goals"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){weight = 1f}

                    textView {
                        id = R.id.df_away_goal
                        text = "(10) Modric"
                        gravity = Gravity.END
                        gravity = Gravity.RIGHT
                    }.lparams(){weight = 2f}

                }.lparams(matchParent, wrapContent){margin = dip(10)}
                ///////////////////////

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    weightSum = 5f

                    textView {
                        id = R.id.df_home_goal
                        text = "(10) Modric"

                    }.lparams(){weight = 2f}

                    textView {
                        text = "Shots"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){weight = 1f}

                    textView {
                        id = R.id.df_away_goal
                        text = "(10) Modric"
                        gravity = Gravity.END
                        gravity = Gravity.RIGHT
                    }.lparams(){weight = 2f}

                }.lparams(matchParent, wrapContent){margin = dip(10)}

                view {
                    backgroundColor = Color.LTGRAY
                }.lparams(matchParent, dip(1)){margin = dip(10)}

                ///////////////////////////
                textView {
                    text = "Lineups"
                    gravity = Gravity.CENTER_HORIZONTAL
                }.setTypeface(textView().typeface, Typeface.BOLD)

                ///////////////////////////

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    weightSum = 5f

                    textView {
                        id = R.id.df_home_goal
                        text = "(10) Modric"

                    }.lparams(){weight = 2f}

                    textView {
                        text = "Goal Keeper"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){weight = 1f}

                    textView {
                        id = R.id.df_away_goal
                        text = "(10) Modric"
                        gravity = Gravity.END
                        gravity = Gravity.RIGHT
                    }.lparams(){weight = 2f}

                }.lparams(matchParent, wrapContent){margin = dip(10)}

                ///////////////////////////

                ///////////////////////////

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    weightSum = 5f

                    textView {
                        id = R.id.df_home_goal
                        text = "(10) Modric"

                    }.lparams(){weight = 2f}

                    textView {
                        text = "Defence"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){weight = 1f}

                    textView {
                        id = R.id.df_away_goal
                        text = "(10) Modric"
                        gravity = Gravity.END
                        gravity = Gravity.RIGHT
                    }.lparams(){weight = 2f}

                }.lparams(matchParent, wrapContent){margin = dip(10)}

                ///////////////////////////

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    weightSum = 5f

                    textView {
                        id = R.id.df_home_goal
                        text = "(10) Modric"

                    }.lparams(){weight = 2f}

                    textView {
                        text = "Midfield"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){weight = 1f}

                    textView {
                        id = R.id.df_away_goal
                        text = "(10) Modric"
                        gravity = Gravity.END
                        gravity = Gravity.RIGHT
                    }.lparams(){weight = 2f}

                }.lparams(matchParent, wrapContent){margin = dip(10)}

                ///////////////////////////

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    weightSum = 5f

                    textView {
                        id = R.id.df_home_goal
                        text = "(10) Modric"

                    }.lparams(){weight = 2f}

                    textView {
                        text = "Forward"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){weight = 1f}

                    textView {
                        id = R.id.df_away_goal
                        text = "(10) Modric"
                        gravity = Gravity.END
                        gravity = Gravity.RIGHT
                    }.lparams(){weight = 2f}

                }.lparams(matchParent, wrapContent){margin = dip(10)}

                ///////////////////////////

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_HORIZONTAL
                    weightSum = 5f

                    textView {
                        id = R.id.df_home_goal
                        text = "(10) Modric"

                    }.lparams(){weight = 2f}

                    textView {
                        text = "Subtituties"
                        textColor = ContextCompat.getColor(context, R.color.colorPrimary)
                        gravity = Gravity.CENTER_HORIZONTAL
                        setTypeface(this.typeface, Typeface.BOLD)
                    }.lparams(){weight = 1f}

                    textView {
                        id = R.id.df_away_goal
                        text = "(10) Modric"
                        gravity = Gravity.END
                        gravity = Gravity.RIGHT
                    }.lparams(){weight = 2f}

                }.lparams(matchParent, wrapContent){margin = dip(10)}

                ///////////////////////////

            }

        }.view
    }
}