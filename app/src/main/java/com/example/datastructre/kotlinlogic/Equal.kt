package com.example.datastructre.kotlinlogic


class Car(val color: String) {

}

data class Bike(val color:String){

}

fun main(array: Array<String>) {

    val car1 = Car("RED")
    val car2 = Car("RED")

    println(car1 == car2) // false
    println(car1 === car2) // false
    println(car1.equals(car2)) // false

    val car3 = car1
    println(car1 == car3) // true
    println(car1 === car3) // true
    println(car1.equals(car3))

    val string1 = "dipak"
    val string2 = "dipak"

    println(string1 == string2) // true
    println(string1 ===string2) // true
    println(string1.equals(string2)) // true

    val string3 = string1
    println(string1 == string3) // true
    println(string1 ===string3) // true
    println(string1.equals(string3)) // true


    val bike1 = Bike("RED")
    val bike2 = Bike("RED")

    println(bike1 == bike2) // true
    println(bike1 === bike2) // false
    println(bike1.equals(bike2)) // true
}