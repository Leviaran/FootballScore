package com.example.ran.footballclubv2.screen.match

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.ran.footballclubv2.NEXT_MATCH
import com.example.ran.footballclubv2.PREV_MATCH
import com.example.ran.footballclubv2.common.ViewModel.Response
import com.example.ran.footballclubv2.common.domain.interactor.FootaballInteractor
import com.example.ran.footballclubv2.common.domain.interactor.FootballUseCase
import com.example.ran.footballclubv2.common.domain.model.Events
import com.example.ran.footballclubv2.local.database
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import timber.log.Timber
import javax.inject.Inject


const val ENGLISH_LEAGUE = "4328"

class PrevMatchViewModel @Inject constructor(
        val footBallInteractor: FootaballInteractor
) : ViewModel(){

    private val response = MutableLiveData<Response>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun response () : MutableLiveData<Response> = response

    fun loadDataFootball(menu : String, context: Context?) = loadFootballEvent(footBallInteractor, menu, context)

    fun loadFootballEvent(footballUseCase: FootballUseCase, menu : String, context: Context?){

        when(menu) {
            PREV_MATCH -> {
                compositeDisposable.add(
                        footballUseCase.getFootBallResponse().getFootballEventPrev(ENGLISH_LEAGUE)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnSubscribe { response.value = Response.Loading }
                                .subscribe({footballEvent -> response.value = Response.Success(footballEvent)}){
                                    throwable -> response.value = Response.Error
                                }
                )
            }
            NEXT_MATCH -> {
                compositeDisposable.add(
                        footballUseCase.getFootBallResponse().getFootBallEventNext(ENGLISH_LEAGUE)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .doOnSubscribe { response.value = Response.Loading }
                                .subscribe({footballEvent -> response.value = Response.Success(footballEvent)}){
                                    throwable -> Timber.e("Errornya adalah ${throwable.message}")
                                }
                )
            }
            else -> {
                context?.database?.use {
                    val result = select(Events.TABLE_FAVORITE)
                    val favorite = result.parseList(classParser<Events>())
                    Timber.e("hasil parsing, ${favorite.get(0).toString()}")
                    response.value = Response.Success(favorite)
                }
            }
        }


    }

}