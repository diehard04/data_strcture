package com.example.datastructre.array.implementation

/**
 * Created by Dipak Kumar Mehta on 11/2/2022.
 */
class Sorting {
    fun main(args:Array<String>) {
        val student = intArrayOf(1, 31,2,42,222,32,21)
        student.sort()
        println("sorted array ${student.contentToString()}")


        val students = arrayOf(Student("dipak", 21), Student("Rvi", 2), Student("kamal", 5))
        students.forEach {
            println("original array $it")
        }

        students.sortBy {
                student -> student.rank
        }
        students.forEach {
            println("sorted array $it")
        }
    }


    data class Student(val name:String, val rank:Int)
}

fun main(args:Array<String>) {

}
