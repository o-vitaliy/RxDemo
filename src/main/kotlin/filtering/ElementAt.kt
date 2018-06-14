package filtering

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import observer
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object ElementAt {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.range(0, 10)


        observable
                .elementAt(11) // returns Maybe
                .subscribeBy(
                        onComplete = { println("done") },
                        onSuccess = { println(it) }
                )


        sleep(2000)
    }
}