package com.ltts.ott.utils.test

/**
 * Created by Dipak Kumar Mehta on 10/25/2022.
 */
class Collections {

}

fun main(args:Array<String>) {

    val nums = listOf<Int>(2,7,1,41)
    //println(isOdd(2))
    //println(isOdd(3))

    //val list = nums.filter(::isOdd)
    //val list = nums.filter { a: Int -> a % 2 != 0 }
    val list = nums.filter { it %2 != 0 }
    //println(list)

    val userList = listOf(Users(1, "A"), Users(2, "B"), Users(3,"C"))

    println(userList.filter { it.id == 2 })

    val paidUser = userList.map {
        PaidUser(it.id, it.name, "Paid")
    }
    println(paidUser)

    nums.forEach {
        println(it)
    }
}

fun isOdd(a:Int):Boolean {
    return a%2 !=0
}

data class Users(val id:Int, val name:String)

data class PaidUser(val id:Int, val name:String, val type:String)