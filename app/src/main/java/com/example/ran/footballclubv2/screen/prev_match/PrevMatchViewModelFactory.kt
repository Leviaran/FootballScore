package com.example.ran.footballclubv2.screen.prev_match

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.ran.footballclubv2.common.domain.interactor.FootaballInteractor

class PrevMatchViewModelFactory (
        val footballInteractor: FootaballInteractor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(PrevMatchViewModel::class.java) -> {
                return PrevMatchViewModel(footballInteractor) as (T)
            }
        }
        throw IllegalArgumentException(" Kelas tidak diketahui")
    }

}