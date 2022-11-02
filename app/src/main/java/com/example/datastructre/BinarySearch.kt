package com.example.datastructre

/**
 * Created by Dipak Kumar Mehta on 11/2/2022.
 */
class BinarySearch {
}

fun <T:Comparable<T>> binarySearch(list: List<T>, key:T): Int? {
    var rangeStart = 0
    var rangeEnd = list.count()
    while (rangeStart < rangeEnd) {
        val midIndex = rangeStart + (rangeEnd - rangeStart)/2
        if (list[midIndex] == key) {
            return midIndex
        } else if (list[midIndex] < key) {
            rangeStart = midIndex + 1
        } else {
            rangeEnd = midIndex
        }
    }
    return null
}


fun main(args: Array<String>) {
    println("\nOrdered list:")
    val ordered = listOf("Adam", "Clark", "John", "Tim", "Zack")
    println(ordered)
    val name = "John"
    println("\n$name is in the position ${binarySearch(ordered, name)} in the ordered List.")
    //println("\n$name is in the position ${binarySearchRec(ordered, name)} in the ordered List.")
}