package com.example.datastructre.chezycodes


fun main() {
    val p1 = Person("John", 21); // creating instance of object person
    val p2 = Person("John", 21); // creating different instance of object person
    val s1= Student(intArrayOf(21, 1,10))
    val s2= Student(intArrayOf(21, 1,10))
    println(s1 == s2)
    println(s1.hashCode())
    println(s2.hashCode())
    println(p1);
    println(p2)
    println(p1.hashCode()) // 71750730
    println(p2.hashCode()) // 71750730
    println(p1 == p2) // true
    println(p1===p2) // false


    val p3 = p1.copy("John", 22)

    println(p3 == p2)
}

data class  Student(val intArray: IntArray) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Student

        if (!intArray.contentEquals(other.intArray)) return false

        return true
    }

    override fun hashCode(): Int {
        return intArray.contentHashCode()
    }
}

data class Person(val name:String, val age:Int) {

}