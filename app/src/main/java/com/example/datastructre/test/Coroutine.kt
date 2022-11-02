
import kotlinx.coroutines.*

/**
 * Created by Dipak Kumar Mehta on 10/27/2022.
 */
class Coroutine {
}

fun main(args:Array<String>) {
    fetchUserAndShow()
}

 fun fetchUserAndShow(){
    CoroutineScope(Dispatchers.IO).launch {
        println("CoroutineScope ${Thread.currentThread().name}")
    }

    GlobalScope.launch(Dispatchers.IO) {
        println("GlobalScope ${Thread.currentThread().name}")
    }

    MainScope().launch(Dispatchers.Default) {
        println("MainScope ${Thread.currentThread().name}")
    }
}