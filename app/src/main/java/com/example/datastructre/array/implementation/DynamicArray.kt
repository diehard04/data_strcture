package com.example.datastructre.array.implementation

/**
 * Created by Dipak Kumar Mehta on 11/2/2022.
 */
class DynamicArray(private var array: Array<String?> = arrayOfNulls(1), private var capacity:Int = 1, private var length:Int = 0) {

    fun push(string:String) {
        if (length == capacity) {
            val tempArray = arrayOfNulls<String>(2 * capacity)
            for (i in array.indices) {
                tempArray[i] = array[i]
            }
            array = tempArray
            capacity *= 2
        }
        array[length] = string
        length++
    }

    // gets the array
    fun getArray(): Array<String?> {
        val tempArray = arrayOfNulls<String>(length)
        for(i in 0 until length) {
            tempArray[i] = array[i]
        }
        return tempArray
    }
}

fun  main(args:Array<String>) {
    val dynamicArray = DynamicArray()
    dynamicArray.push("ravi")
    dynamicArray.push("sunil")
    dynamicArray.push("kumar")
}