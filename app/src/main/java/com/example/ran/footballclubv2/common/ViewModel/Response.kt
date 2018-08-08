package com.example.ran.footballclubv2.common.ViewModel

sealed class Response {
    object Loading : Response()
    data class Success (val data: Any?) : Response()
    object Error : Response()
}