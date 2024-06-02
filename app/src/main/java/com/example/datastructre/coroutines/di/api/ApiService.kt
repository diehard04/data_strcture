package com.example.datastructre.coroutines.di.api

import com.example.datastructre.kotlinlogic.scope.User
import retrofit2.http.GET

/**
 * Created by DieHard_04 on 09-06-2021.
 */
interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}