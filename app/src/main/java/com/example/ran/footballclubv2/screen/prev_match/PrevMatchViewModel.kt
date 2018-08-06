package com.example.ran.footballclubv2.screen.prev_match

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.ran.footballclubv2.common.ViewModel.Response
import com.example.ran.footballclubv2.common.domain.interactor.FootaballInteractor
import com.example.ran.footballclubv2.common.domain.interactor.FootballUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
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

    fun loadDataFootball() = loadFootballEvent(footBallInteractor)

    fun loadFootballEvent(footballUseCase: FootballUseCase){

        compositeDisposable.add(
                footballUseCase.getFootBallResponse().getFootballEvent(ENGLISH_LEAGUE)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe { response.value = Response.Loading }
                        .subscribe({footballEvent -> response.value = Response.Success(footballEvent)}){
                            throwable -> response.value = Response.Error
                        }
        )
    }

}