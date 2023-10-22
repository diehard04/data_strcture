package com.example.datastructre.chezycodes

import kotlin.math.pow
import kotlin.reflect.KFunction2

fun main () {
    var fn: (a: Double, b: Double) -> Double  = ::addition
    println( fn(2.1,4.4))

    fn =::power
    println(fn(2.0, 3.0))
}

//fun addition(a:Int, b: Int):Int  = a+b // inline function


fun power(a:Double, b:Double):Double {
   return a.pow(b)
}

fun addition(a:Double, b:Double):Double {
    return a+b
}