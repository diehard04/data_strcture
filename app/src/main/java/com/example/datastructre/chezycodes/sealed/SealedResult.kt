package com.example.datastructre.chezycodes.sealed

/**
 * a sealed class is used to represent a restricted class hierarchy,
 * where a value can have one of the types from a limited set.
 * This is particularly useful when you have a known set of subclasses and you want to enforce type safety.
 */
/**
 * 1st example
 */
sealed class SealedResult {
    data class Success(val data:SealedModel):SealedResult()
    data class Fail(val message:String) :SealedResult()
}


fun handleResult(sealedResult: SealedResult) {
    when(sealedResult) {
        is SealedResult.Success ->
            println(sealedResult.data.name)

        is SealedResult.Fail ->
            println(sealedResult.message)
    }
}

data class SealedModel(val id:String,val name:String)


/**
 * 2nd example
 */
sealed class Shape {
    data class Circle(val radius: Double) : Shape()
    data class Rectangle(val height: Double, val width: Double) : Shape()
    object NotAShape : Shape()
}

fun describeShape(shape: Shape): String {
    return when (shape) {
        is Shape.Circle -> "A circle with radius ${shape.radius}"
        is Shape.Rectangle -> "A rectangle with height ${shape.height} and width ${shape.width}"
        Shape.NotAShape -> "Not a shape"
    }
}

fun main() {
    handleResult(SealedResult.Fail("failed"))

    val circle = Shape.Circle(5.0)
    val rectangle = Shape.Rectangle(3.0, 4.0)
    val notAShape = Shape.NotAShape

    println(describeShape(circle))       // Output: A circle with radius 5.0
    println(describeShape(rectangle))    // Output: A rectangle with height 3.0 and width 4.0
    println(describeShape(notAShape))    // Output: Not a shape
}