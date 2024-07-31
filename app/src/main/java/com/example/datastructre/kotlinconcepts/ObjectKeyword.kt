package com.example.datastructre.kotlinconcepts

fun main () {
    //object decleration
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementFbLikes()
    SharingWidget.display()

    //object Expression, we are using here anonymus object
    var testObject = object {
        val x:Int = 10

        fun method() {
            println("I am obbject Expression")
        }
    }
    testObject.method()

    //we are using here anonymus object and implement Clonables interface
    var obj = object :Clonables {
        override fun clone() {
            println("I am clone")
        }
    }

    obj.clone()

    //we are using here anonymus object
    var obj2 = object :Persion("Object expressions") {
        override fun fullName() {
            super.fullName()
            println("Anonymus $name")
        }
    }
    obj2.fullName()
}
//object Expressions

interface Clonables {
    fun clone()
}

// object decleration
object SharingWidget {
    private var twitterLikes = 0
    private var fbLikes = 0

    fun incrementTwitterLikes() = twitterLikes ++
    fun incrementFbLikes() = fbLikes ++

    fun display() = println("Facebook $fbLikes ---- Twitter $twitterLikes" )
}

//object Expression
open class Persion(val name:String) {
    open fun fullName() = println("Full name $name")
}