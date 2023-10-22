package com.example.datastructre.chezycodes

fun main() {

    val circle = Circle(4.0)
    val player = Player("Smiley")

    val arr: Array<Any> = arrayOf(circle, player, Test())

    for (obj in arr) {
        if (obj is Circle) {
            println(obj.area()) // smart cast
        }
        else {
            if(obj is Player) {
                obj.sayMyName()
            }
        }
    }
}

interface Draggable {
    fun drag()
}

interface Clonable {
    fun clone()
}
fun dragObject(objects: Array<Draggable>) {
    for (obj in objects) {
        obj.drag()
    }
}

abstract class Shape():Draggable {
    abstract fun area(): Double

    abstract override fun drag()
}

class Circle(val radius:Double):Shape() {
    override fun area(): Double = Math.PI * radius * radius

    override fun drag() = println("Circle is draging")
}

class Square(val side:Double):Shape() {
    override fun area(): Double = side * side

    override fun drag() = println("Square is draging")
}

class Tringle(val base:Double, val height:Double):Shape() {
    override fun area(): Double = 0.5 * base * height

    override fun drag() = println("Triangle is dragging")

}


class Player(val name:String):Draggable {
    override fun drag() = println(" $name is dragging")

    fun sayMyName() = println("Hey my name is $name")
}


class Test {

}