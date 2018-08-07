package com.example.ran.footballclubv2.screen.detail_match

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.ran.footballclubv2.common.ViewModel.Response
import com.example.ran.footballclubv2.common.domain.interactor.FootaballInteractor
import com.example.ran.footballclubv2.common.domain.interactor.FootballUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

class DetailMatchViewModel @Inject constructor(
        val footbalInteractor: FootaballInteractor
) : ViewModel() {
    private val response = MutableLiveData<Response>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun response(): MutableLiveData<Response> = response

    fun loadImage(name : String?) = loadImageData(footbalInteractor, name)

    fun loadImageData(footballUsecase : FootballUseCase,name : String?){
        Timber.e("coba")
        compositeDisposable.add(
                footballUsecase.getFootBallResponse().getTeamData(name)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe {response.value = Response.Loading}
                        .subscribe({teamData -> run {
                            Timber.e(" hasil adalah ${teamData.teams[0].strTeamBadge}")
                            response.value = Response.Success(teamData)
                        }})
                        { response.value = Response.Error}
        )
    }

}