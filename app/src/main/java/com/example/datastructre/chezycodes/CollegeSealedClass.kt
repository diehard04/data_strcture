package com.example.datastructre.chezycodes

sealed class CollegeSealedClass {

    abstract fun setStream()
}

class CS: CollegeSealedClass() {

    override fun setStream() {
        println("This is Computer Science")
    }
}

class IT: CollegeSealedClass() {
    override fun setStream() {
        println("This is IT")
    }
}

fun main() {
    val cs = CollegeFactory.createBranch("A")

    val IT = CollegeFactory.createBranch("B")

    val EC = CollegeFactory.createBranch("EC") // it will return null


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



