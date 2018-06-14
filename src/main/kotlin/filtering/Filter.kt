package filtering

import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import observer
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object Filter {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.range(0, 10)


        observable
                .filter { it % 2 == 0 } // returns Maybe
                .subscribe(observer)


        sleep(2000)
    }
}