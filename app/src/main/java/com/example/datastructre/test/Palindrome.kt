package com.example.datastructre.test

/**
 * Created by Dipak Kumar Mehta on 11/16/2022.
 */
class Palindrome {
    fun main() {
        println("Hello, world!!!")
        println(isPalindorme(1331))
        println(isPalindorme("madam"))
    }

    fun isPalindorme(s:Int):Boolean {
        var originalNumber = s
        var reverseNumber = 0
        var temp = originalNumber

        while(temp > 0) {
            val reminder = temp % 10
            reverseNumber  = reverseNumber * 10 + reminder
            temp = temp/10
        }

        if(reverseNumber == originalNumber ) {
            return true
        } else {
            return false
        }
    }

    fun isPalindorme(s:String):Boolean {
        val originalString = s
        var reverseString = ""
        var length = originalString.length

        for(i in (length - 1) downTo 0 ) {
            reverseString = reverseString + originalString[i]
        }

        if(originalString.equals(reverseString)) {
            return true
        } else {
            return false
        }
    }
}