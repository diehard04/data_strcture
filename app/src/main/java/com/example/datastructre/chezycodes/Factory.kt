package com.example.datastructre.chezycodes


fun main() {
    val pizza = Pizza.Factory.create("Peppy Panner")
    println(pizza.toString())

    // above I am calling vai Factory reference - don't want to use Factory reference

    // Now after defining that as companion
    var pizza2 = Pizza.create("Tomato")
    println(pizza2.toString())

    // one more thing we can do - We want every one to call this create method if they want to use Pizza
    // for that we will mark the constructor as private
    //var pizza3 = Pizza("","") // now everyone need to call create mehtod
    // that is everone has to to call it's factory

}
class Pizza private constructor(val type:String, val toppins:String) {
    companion object Factory{ // this is my factory object
        fun create(pizzaType:String):Pizza {
            return when(pizzaType) {
                "Tomato" -> Pizza("Tomato", "Tomato Cheeze")
                "Peppy Panner" -> Pizza("Panner", "Panner , peppy")
                else -> Pizza("Mashrom", "paper mashroom")
            }
        }
    }

    override fun toString(): String {
        return "Pizza(type $type and toppins $toppins)"
    }
}