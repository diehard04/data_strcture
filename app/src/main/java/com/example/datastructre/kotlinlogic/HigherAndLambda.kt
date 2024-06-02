package com.example.datastructre.kotlinlogic

import kotlin.math.abs

/**
 * Created by Dipak Kumar Mehta on 11/19/2021.
 */
class HigherAndLambda {

    //higher order function
    val add:(Int , Int) ->Int = { a, b-> a+b }
    val addSingle:(Int) -> Int = {a -> a}
    fun passMeFunction(abc: () -> Unit) {
        // I can take function
        // do something here
        // execute the function
        abc()
    }

    // Example of a higher-order function taking a function as a parameter
    fun higherOrderFunction(operation: (Int) -> Int): Int {
        return operation(2)
    }

    val upperCase1:(String) -> String = {str:String -> str.uppercase()}
    val upperCase2:(String) -> String = {a -> a.uppercase()}
    val upperCase3=  {str:String -> str.uppercase()}

    //A simple Higher Order Function in Kotlin
    //This function accepts three parameters
    //And the last parameter is a function
    fun rollDice(range: IntRange, time: Int, callback: (result: Int) -> Unit) {
        for (i in 0 until time) {
            val result = range.random()
            //As the last parameter is a function
            //we can call it as a function
            callback(result)
        }
    }

}

// outer class
class Outer {
    private val bar: Int = 1
    class Nested {
        fun foo() = 2
    }
}
val demo = Outer.Nested().foo() // == 2


//inner class
class Outers {
    private val bar: Int = 1
    inner class Inne{
        fun foo() = bar
    }
}

val demos = Outers().Inne().foo() // == 1





fun main(args: Array<String>) {
    val higherAndLambda = HigherAndLambda()
    higherAndLambda.passMeFunction {
        val result = higherAndLambda.add(1,43)
        println("$result")
    }
    println("${higherAndLambda.add(3,2)}")


// Usage of the higher-order function with the 'add' function
    val result =higherAndLambda.higherOrderFunction(higherAndLambda.addSingle)
    println("Result: $result")

    println(higherAndLambda.add(54,4))
    println(higherAndLambda.upperCase1("dipak"))
    higherAndLambda.rollDice(1..6, 3, { results ->
        println(results)
    })

    val operation = operateOnNumber(5, 4, {
        x, y, -> x-y
    })

    println("$operation")
}

fun operateOnNumber(a:Int, b:Int, operation:(Int, Int) -> Int):Int {
    return operation(a,b)
}
