
/**
 * Created by Dipak Kumar Mehta on 10/19/2022.
 */
class ScopeFunction {

}


fun main(args: Array<String>) {

    val emp = Employee()
    emp.name = "John"
    emp.age = 20

    // apply return type object and scope object this
    val x = emp.apply {
        age = 30
        name = "Sean"
    }

    println(emp)

    // last line will be return type
    val re:Unit = emp.let {
        println(it.name)
    }

    // with
    // return valu will be last line
    with(emp){
        age = 13
        name = "da"
    }

    //  return value last item
    // combinate of with and let
    emp.run {
        age = 212
        name = "xyz"
    }
}

data class Employee(var name: String = "", var age: Int = 18)