package combining

import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import observer
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object Merge {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.range(0, 10).delay(10, TimeUnit.MILLISECONDS)
        val observable2 = Observable.range(-20, 10).delay(10, TimeUnit.MILLISECONDS)


        Observable.merge(
                observable.subscribeOn(Schedulers.newThread()),
                observable2.subscribeOn(Schedulers.newThread())
        )
                .subscribe(observer)


        sleep(100)
    }
}