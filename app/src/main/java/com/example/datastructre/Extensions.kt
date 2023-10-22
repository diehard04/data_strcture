package com.example.datastructre

import android.widget.ImageView
import java.util.Date

fun main(args: Array<String>) {
    println("Extension function".formattedString());
    //Utility Functions: You can create extension functions to add utility methods to common classes,
    // making them more expressive and readable. For example, you can create an extension function to format
    // a Date object as a string or to parse a string into a date.

    val  imageView:ImageView ?= null
    imageView?.loadImage("https://example.com/image.jpg\"")

    val emai ="dada@gmail.c,"
    val isvalid:Boolean = emai.isEmailValid()

    val result1 = 5.add(3)
    val result2= 5.0.add(4.5)
    println(" $result1 $result2")
}

fun Int.add(order:Int):Int {
    return this + order
}

infix fun Double.add(order: Double):Double {
    return this + order
}


fun String.formattedString(): String {
    return "------------\n$this\n----------"
}

fun ImageView.loadImage(url:String) {
    // Code to load the image from the URL and set it to the ImageView
}

fun String.isEmailValid():Boolean {
    // Check email validation logic
    return true
}
