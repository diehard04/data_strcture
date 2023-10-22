package com.example.datastructre.test

/**
 * Created by Dipak Kumar Mehta on 10/25/2022.
 */
class EnumSealed {
}

fun main(args:Array<String>) {
    val day = DAY.MONDAY
    //println(day)
    //println(day.name + day.int)

    for(i in DAY.values()) {
        //println(i)
    }
    //day.printFormattedDay()


    // seal
    /*val tile = Red("Mushroom", 20)
    val tile2 = Red("Fire", 40)
    println("${tile.point} - ${tile.type}")
    */
    val tile: Tile = Red("Mushroom", 30)
    val point:Int = when(tile) {
        is Blue -> tile.point * 2
        is Red -> tile.point * 4
    }

    println(point)
}

sealed class Tile
class Red(val type:String, val point:Int): Tile()
class Blue(val point:Int): Tile()



enum class DAY(val int:Int) {
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6),
    SUNDAY(7);

    fun printFormattedDay() {
        println("Day is $this")
    }
}