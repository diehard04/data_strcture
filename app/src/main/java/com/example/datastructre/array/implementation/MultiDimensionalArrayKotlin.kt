package com.example.datastructre.array.implementation

/**
 * Created by diehard04 on 24/03/24.
 */
fun main(){
    twoDArray()
}


fun twoDArray() {
    val cinema = arrayOf(
        arrayOf(0, 0, 0, 0, 1),
        arrayOf(0, 0, 0, 1, 1),
        arrayOf(0, 0, 1, 1, 1),
        arrayOf(0, 0, 0, 1, 1),
        arrayOf(0, 0, 0, 0, 1)
    )

    println("twoDArray ${cinema[2][4]}")
}