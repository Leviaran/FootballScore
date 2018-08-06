package com.example.ran.footballclubv2.screen.prev_match


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import com.example.ran.footballclubv2.R
import com.example.ran.footballclubv2.common.ViewModel.Response
import com.example.ran.footballclubv2.common.domain.model.EventFootball
import com.example.ran.footballclubv2.common.domain.model.Events
import com.example.ran.footballclubv2.screen.detail_match.DetailMatch
import dagger.android.support.AndroidSupportInjection
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_prev_match.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PrevMatchFragment : Fragment() {

    companion object {
        fun newInstance(): PrevMatchFragment = PrevMatchFragment()
    }

    lateinit var progressBar: ProgressBar

    @Inject
    lateinit var prevMatchViewModelFactory: PrevMatchViewModelFactory

    private lateinit var prevMatchViewModel: PrevMatchViewModel

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        prevMatchViewModel = ViewModelProviders.of(this, prevMatchViewModelFactory).get(PrevMatchViewModel::class.java)

        prevMatchViewModel.response().observe(this, Observer { response -> execute(response!!) })
        prevMatchViewModel.loadDataFootball()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return UI {
            relativeLayout {

                progressBar = progressBar {
                    id = R.id.rv_pb_prev_match
                    indeterminateDrawable.setColorFilter(ContextCompat
                            .getColor(context, R.color.colorPrimary), PorterDuff.Mode.SRC_IN)

                }.lparams(){centerHorizontally(); centerVertically()}

                recyclerView {
                    id = R.id.rv_prev_match
                    layoutManager = LinearLayoutManager(context)

                }.lparams(matchParent, matchParent)
            }
        }.view
    }

    private fun execute(response : Response) = when (response) {
        is Response.Loading -> renderLoadingState()
        is Response.Success -> renderDataState(response.data)
        is Response.Error -> renderErrorState()
    }

    private fun renderLoadingState() {
        Timber.e("Loading")

    }

    private fun renderDataState(footballEvent : EventFootball?) {
        Timber.e("Yesss")

        progressBar.visibility = View.GONE
        val list = mutableListOf<Events>()

        val recycler = view?.findViewById<RecyclerView>(R.id.rv_prev_match)
        recycler?.adapter = PrevMatchAdapter(footballEvent?.events?.toMutableList() ?: list ) {
            Toast.makeText(context, it.dateEvent, Toast.LENGTH_SHORT).show()

            fragmentManager?.beginTransaction()
                    ?.replace(R.id.container, DetailMatch())
                    ?.addToBackStack(null)
                    ?.commit()
        }

    }

    private fun renderErrorState() {
        Timber.e("Error")
        progressBar.visibility = View.GONE
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }


}