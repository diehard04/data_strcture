
/**
 * Created by Dipak Kumar Mehta on 10/28/2022.
 */
class InlineFunction : Logics(){
}

fun main(args:Array<String>) {
    myInlineFun { println("Call to inline function") }
}

inline fun myInlineFun(myFun: () -> Unit ) {
    myFun()
    print("TutorialsPoint")
}