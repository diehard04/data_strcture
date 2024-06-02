package com.example.kotlinlogicandcoroutine

/**
 * Created by diehard04 on 28/05/24.
 */

fun main(array:Array<String>) {
    val intArray = intArrayOf(1,4,1,2,64,12,42)

    for (i in intArray.iterator().withIndex()) {
        println(" index ${i.index} value ${i.value}")
    }
}