package com.example.kotlinlogicandcoroutine

/**
 * Created by diehard04 on 29/05/24.
 */
fun main() {
    val input = "mom"
    if (isPalindrome(input)) {
        println("The string \"$input\" is a palindrome.")
    } else {
        println("The string \"$input\" is not a palindrome.")
    }
}

fun isPalindromeInHalf(s: String): Boolean {
    val str = s.filter { it.isLetterOrDigit() }.lowercase()
    for (i in 0 until str.length / 2) {
        if (str[i] != str[str.length - i - 1]) {
            return false
        }
    }
    return true
}
fun isPalindrome(str: String): Boolean {
    var start = 0
    var end = str.length - 1
    while (start < end) {
        if (str[start] != str[end]) {
            return false
        }
        start++
        end--
    }
    return true
}

fun palindromUsingForLoop(originalString:String) {
    var reverseString = ""
    var length = originalString.length

    for (i in (length - 1) downTo 0) {
        reverseString = reverseString + originalString[i]
    }
}