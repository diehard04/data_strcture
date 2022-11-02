package com.ltts.ott.utils.test

import kotlin.math.pow

/**
 * Created by Dipak Kumar Mehta on 10/21/2022.
 */
class ExtensionFunction(val radius: Double) {

    // member function of class
    fun area(): Double{
        return Math.PI * radius * radius;
    }
}


fun main (args : Array<String>) {

    fun ExtensionFunction.perimere():Double {
        return 2 * Math.PI * radius
    }
    val circle = ExtensionFunction(3.0)
    println("Area of the circle is ${circle.area()}")
    println("Perimeter of the circle is ${circle.perimere()}")

    // Extension function defined for Int type
    fun Int.abs() : Int{
        return if(this < 0) -this else this
    }
    println((-4).abs())
    println(4.abs())

    // Extension function operate defined for A
    fun A.operate():Int {
        return a + b
    }

    // Extension function operate defined for B
    fun B.operate() :Int{
        return a * b
    }

    fun display(a:A) {
        println(a.operate())
    }
    println("extended library A ${A(10,10).operate()}")
    display(B())

    //lazy function
    val someClass = SomeClass()
    println("some class initialize")
    someClass.accessObject()
    someClass.accessObject()
    doLambda()

    doHigherOrderFunction()
}

fun doHigherOrderFunction() {
    println(sum(2.0,3.0))
    println(power(2.0, 3.0))

    val fn = ::sum
    calculator(3.0, 4.0, ::sum)
}

fun sum(a:Double , b :Double):Double {
    return a+b
}

fun power(a:Double , b:Double):Double {
    return a.pow(b)
}

fun calculator(a:Double, b:Double, gn:(Double, Double) -> Double) {
    val result = gn(a, b)

    println(result)
}

fun doLambda() {

    // lambda
    val square:(Int) -> Int = {
        it * it
    }
    println(square(4))


    val squareNoReturn:(String) -> Unit = {
        println(it)
    }

    squareNoReturn("test square no return")

    fun lambda1(a:Int, b:Int):Int {
        return a+b
    }
    val lambda1 = {
        x:Int, y:Int -> x+y
    }

    println( lambda1(1, 2))

    val multilineLambda = {
        ""
        1
    }
}


//Extended library class using extension function
// Open class created to be inherited
open class A(val a:Int, val b:Int){
}

// Class B inherits A
class B():A(5, 5){}


// lazy function
class SomeClass {
    private val heavyObject: HeavyClass by lazy {
        println("Heavy Object initialised")
        HeavyClass()
    }

    fun accessObject() {
        println(heavyObject)
    }
}

class HeavyClass {

}