package com.example.kotlinlogicandcoroutine.functions

import android.os.Handler
import android.os.Looper
import kotlin.math.pow

/**
 * Created by diehard04 on 18/05/24.
 */

/**
 * A higher-order function is a function that takes another function as parameter and/or returns a function.
 *
 */
fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {  // 1
    return operation(x, y)                                          // 2
}

fun sum(x: Int, y: Int) = x + y                                     // 3

fun main() {
    val sumResult = calculate(4, 5, ::sum)                          // 4
    val mulResult = calculate(4, 5) { a, b -> a * b }               // 5
    println("sumResult $sumResult, mulResult $mulResult")

    higherOderFunction {
        callback ->
        println(callback)
    }

    runOnBackgroundThread({
       doExpensiveCalculation()
    }, {
        result ->
    })
}
fun doExpensiveCalculation(): String {
    // Simulate a long-running task
    Thread.sleep(3000)  // Sleep for 3 seconds to mimic a long computation

    // Perform some complex calculation
    val result = (1..1_000_000).sumOf { it.toDouble().pow(0.5) }  // Example: sum of square roots of first 1,000,000 numbers

    return "Calculation Result: $result"
}


fun higherOderFunction(callBack:(result:String) ->Unit) {
    // do some stuff here
    callBack("result return from higher order function")
}

fun <T> runOnBackgroundThread(backgroundFunc: () -> T, callback: (T) -> Unit) {
    val handler = Handler(Looper.getMainLooper())
    Thread {
        val result = backgroundFunc()
        handler.post { callback(result) }
    }.start()
}