package com.example.datastructre.kotlinconcepts.sealed

sealed class CollegeSealedClass {

    abstract fun makeBranch()
}

class CS: CollegeSealedClass() {

    override fun makeBranch() {
        println("This is Computer Science")
    }
}

class IT: CollegeSealedClass() {
    override fun makeBranch() {
        println("This is IT")
    }
}

object CollegeFactory {
    fun createBranch(stream:String) : CollegeSealedClass? {
        return when(stream) {
            "A" -> CS()
            "B" -> IT()
            else -> null
        }
    }
}


/**
 * With this definition, we can create different types of Branches by calling the createBranch method with the appropriate type, like this:
 */

fun main() {
    val cs = CollegeFactory.createBranch("A")
    val IT = CollegeFactory.createBranch("B")
}