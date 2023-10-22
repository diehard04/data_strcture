package com.example.datastructre

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow



fun myFlow(numbers:Array<Int>): Flow<Int> = flow {
    numbers.forEach {
        delay(1000)
        emit(it)
    }
}

suspend fun main() {
    val numbers:Array<Int> = arrayOf(1, 2,3,4,5)
    myFlow(numbers).collect{
        value ->
        println( " time $" + value)
    }
}



