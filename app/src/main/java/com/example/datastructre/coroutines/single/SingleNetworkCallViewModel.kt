/*
package com.diehard04.pizgloria.testlogic.coroutines.single

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.datastructre.coroutines.di.repository.SingleNetworkCallRepository
import kotlinx.coroutines.Dispatchers

*/
/**
 * Created by DieHard_04 on 09-06-2021.
 *//*

class SingleNetworkCallViewModel(private val mainRepository: SingleNetworkCallRepository) : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainRepository.getUsers()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }
}

*/
