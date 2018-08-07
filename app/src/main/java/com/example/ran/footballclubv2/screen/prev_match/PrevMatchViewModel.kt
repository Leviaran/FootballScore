package com.example.ran.footballclubv2.screen.prev_match

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.ran.footballclubv2.PREV_MATCH
import com.example.ran.footballclubv2.common.ViewModel.Response
import com.example.ran.footballclubv2.common.domain.interactor.FootaballInteractor
import com.example.ran.footballclubv2.common.domain.interactor.FootballUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
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

    fun loadDataFootball(menu : String) = loadFootballEvent(footBallInteractor, menu)

    fun loadFootballEvent(footballUseCase: FootballUseCase, menu : String){

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
            else -> {
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
        }


    }

}