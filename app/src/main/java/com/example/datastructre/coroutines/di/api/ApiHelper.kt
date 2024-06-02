package com.example.datastructre.coroutines.di.api

/**
 * Created by DieHard_04 on 09-06-2021.
 */
class ApiHelper(private val apiService: ApiService) {

    suspend fun getUsers() = apiService.getUsers()
}