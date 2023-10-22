package com.example.datastructre.chezycodes

fun main() {
    var arr = arrayOf("one", "two", "three")

    var array1 = arrayOf(1,2,3)

    for (i in arr) {
        //println(i)
    }
    
    for ((i, element) in arr.withIndex()) {
        println("$i $element")
    }
}
