package com.example.datastructre.chezycodes


fun main() {
    val p1 = Person("John", 21); // creating instance of object person
    val p2 = Person("John", 21); // creating different instance of object person

    println(p1);
    println(p2)
    println(p1.hashCode()) // 71750730
    println(p2.hashCode()) // 71750730
    println(p1 == p2) // true
    println(p1===p2) // false


    val p3 = p1.copy("John", 22)

    println(p3 == p2)
}


data class Person(val name:String, val age:Int) {

}