package com.example.ran.footballclubv2.common.ViewModel

import com.example.ran.footballclubv2.common.domain.model.EventFootball

sealed class Response {
    object Loading : Response()
    data class Success (val data: Any?) : Response()
    object Error : Response()
}