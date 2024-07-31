package com.example.datastructre.kotlinconcepts.sealed

/**
 * The state patter used for to define the state of the object and behaviour of object based on the state
 */
sealed class StatePattern {

    abstract fun handle()
}


object Paused: StatePattern() {
    override fun handle() {
        // pause the video
    }
}


object Play:StatePattern() {
    override fun handle() {
        // play the video
    }
}

object Release: StatePattern() {
    override fun handle() {
        // release the player
    }
}

fun handleState(statePattern: StatePattern) {
    when(statePattern) {
        is Paused -> statePattern.handle()
        is Play -> statePattern.handle()
        is Release -> statePattern.handle()
        else -> {}
    }
}