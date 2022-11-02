package com.example.datastructre.array.implementation

import java.util.*

/**
 * Created by Dipak Kumar Mehta on 11/2/2022.
 */
class MergeSortedArrays {
}
fun mergeSortedArrays(intArray1: IntArray, intArray2: IntArray):IntArray {
    var i =0
    var j =0
    var k =0

    val mergedArray = IntArray(intArray1.size + intArray2.size)

    while (i < intArray1.size && j < intArray2.size) {
        if (intArray1[i] < intArray2[j]) {
            mergedArray[k] = intArray1[i]
            i++
        } else {
            mergedArray[k] = intArray2[j]
            j++
        }
        k++
    }
    println(mergedArray)
    while (i < intArray1.size) {
        mergedArray[k] = intArray1[i]
        i++
        k++
    }

    mergedArray
    while (j < intArray2.size) {
        mergedArray[k] = intArray2[j]
        j++
        k++
    }

    return mergedArray
}


fun main(args: Array<String>) {
    val mergedArrays = mergeSortedArrays(intArrayOf(0,3,5,121), intArrayOf(0,6,7))

    println(mergedArrays.contentToString())
}