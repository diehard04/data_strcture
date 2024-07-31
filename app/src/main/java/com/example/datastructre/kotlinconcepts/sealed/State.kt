package com.example.datastructre.kotlinconcepts.sealed

/**
 * We might define a sealed class called State with subclasses representing different states of a game.
 */
// 1st example
sealed class State {
    object Initial : State()
    object Running : State()
    object Paused : State()
    object Finished : State()
}

fun handleState(state: State) {

    when(state) {
        is State.Initial ->
            println("This game is starting")

        is State.Finished -> println("this game is finished")
        is State.Paused -> println("this game is paused state")
        is State.Running -> println("this game is running")
    }
}

fun main() {

    handleState(State.Paused)
}

// 2nd example
