
/**
 * Created by Dipak Kumar Mehta on 10/27/2022.
 */
open class Logics {
}

fun main(args:Array<String>){
    var num = 121
    var reverseInteger = 0
    var reminder:Int
    val originalInteger = num

    while (num !=0) {
        reminder = num % 10
        reverseInteger = reverseInteger * 10 + reminder
        num /= 10
    }

    if (originalInteger == reverseInteger) {
        println("$originalInteger is a palindrome.")
    } else {
        println("$originalInteger is not a palindrome.")
    }

    println(isPalindrome("nun"))

    val mylist = intArrayOf(1, 2,3,4)
    val myList = listOf<String>("C", "Java", "C#", "Java", "C", "C#", "SQL")
    var s = "aabbccA"
    findDuplicateElement(myList)
}

fun isPalindrome(str: String): Boolean {
    // Pointers pointing to the beginning
    // and the end of the string
    var i = 0
    var j = str.length - 1
    // While there are characters toc compare
    while (i < j) {
        // If there is a mismatch
        if (str[i] != str[j]) return false
        // Increment first pointer and
        // decrement the other
        i++
        j--
    }
    // Given string is a palindrome
    return true
}

fun findDuplicateElement(array: List<String>):Set<String> {
    val seen:MutableSet<String> = mutableSetOf()
    val duplicate:MutableSet<String> = mutableSetOf()

    for(i in array) {
        if (!seen.add(i)) {
            duplicate.add(i)
        }
    }
    return duplicate

}

// using filter option
fun findAllDuplicates(array: IntArray): Set<Int> {
    val nums = array.toList()
    return nums.filter {
        item -> nums.count { it == item } > 1
    }.toSet()
}
