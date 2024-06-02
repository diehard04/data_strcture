package com.example.kotlinlogicandcoroutine

/**
 * Created by diehard04 on 28/05/24.
 */
fun main(string:Array<String>) {

    val listA = intArrayOf(1,2,4,5,7)
    val listB = intArrayOf(5,6,3,4,8)

    val number = 9
    val pair = getPairs(listA, listB, number)
    println("$pair")
}

fun getPairs(a:IntArray, b: IntArray,  number: Int) :List<Pair<Int, Int>> {
    val setA = a.toSet()
    val setB = b.toSet()
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in setA) {
        val remaining = number - i
        if (remaining in setB) {
            list.add(Pair(i, remaining))
        }
    }
    return list
}