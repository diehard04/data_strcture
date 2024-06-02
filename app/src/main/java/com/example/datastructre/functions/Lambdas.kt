package com.example.datastructre.functions

/**
 * Created by diehard04 on 18/05/24.
 */


/**
 * A lambda expression in Kotlin is a concise, unnamed function enclosed in braces,
 * used for defining code blocks that can be passed as values or stored as variables.
 */

fun main() {
    //variable.invoke()
    variable1(1,"variable1")
    val v2 = variable2(2, "variable 2")
    println(v2)
    variable3()
    val v4 = variable4()
    println(v4)
}

//basis uses of Lambdas
val variable = { println("Inside Lambda Expression")}

//There are four function types, varying based on parameters and return types.

// 1-With Parameters and No Return Value:
val variable1: (Int, String) -> Unit = {a:Int, b:String -> println("$a +  $b")}

// 2-With Parameters and Return Value:
val variable2: (Int, String) -> String = { a:Int, b:String -> "$a + $b"}

// 3-No Parameters and No Return Value:
val variable3:() -> Unit = { println("No Parameters and No Return Value\"") }

// 4-No Parameters and Return Value:
val variable4 :()->String = {"return only"}