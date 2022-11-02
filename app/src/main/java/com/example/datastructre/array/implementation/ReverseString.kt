package com.example.datastructre.array.implementation

/**
 * Created by Dipak Kumar Mehta on 11/2/2022.
 */
class ReverseString {
}

private fun reverse(string: String): String {
    var result = ""
    for (i in string.length - 1 downTo 0) {
        result += string[i]
    }
    return result
}

// Note: This method uses built-in function called reversed()
private fun reverse2(string: String) = string.reversed()

private fun reverseUsingChar(str:String):String {
    val char = str.toCharArray()
    var i = 0
    var j = char.size -1
    while (i < j) {
        val c = char[i]
        char[i] = char[j]
        char[j] = c
        i ++
        j --
    }
    return String(char)
}

fun main() {
    println(reverse("Hello, World!"))
    println(reverse2("Hello, World!"))

    println(reverseUsingChar("dipa"))
}