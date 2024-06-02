package com.example.datastructre.kotlinlogic

/**
 * Created by Dipak Kumar Mehta on 11/19/2021.
 */
class InlineFunction {

    fun doSomething() {
        print("doSomething start")
        doSomethingElse()
        print("doSomething end")
        doSomeNoramlFunctionCall()



    }

    inline fun doSomethingElse() {
        print("doSomethingElse")
    }

    fun doSomeNoramlFunctionCall() {
        println("doSomeNoramlFunctionCall")
    }
}