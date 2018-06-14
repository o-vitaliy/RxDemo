package combining

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import observer
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object Switch {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.range(0, 10)
        val observable2 = Observable.range(-20, 10)

        val o = Observable.just(observable, observable2)


        Observable.switchOnNext(o)
                .subscribe(observer)

        sleep(100)
    }
}