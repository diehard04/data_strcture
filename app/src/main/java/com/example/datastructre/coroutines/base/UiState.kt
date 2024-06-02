package com.example.datastructre.coroutines.base

/**
 * Created by diehard04 on 09/11/23.
 */
sealed class UiState<out T> {

    data class Success<T>(val data:T): UiState<T>()

    data class Error<T>(val string:T):UiState<T>()

    data class Loading<T>(val nothing: Nothing): UiState<T>()
}
