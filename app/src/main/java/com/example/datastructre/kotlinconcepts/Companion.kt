package com.example.datastructre.kotlinconcepts

fun main() {
    MyClass.f()
    MyClass.AnotherObject.g()
}


class MyClass{
    // one class only one companion can define
    companion object {
        fun f() = println("Hello I am F from Object")

    }

    object AnotherObject{
        fun  g() {
            println("Hello I am g from another object")
        }
    }
}