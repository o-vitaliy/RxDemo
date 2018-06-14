package transforming

import io.reactivex.Observable
import io.reactivex.rxkotlin.mergeAll
import observer
import other.Person
import other.persons
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object Window {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.range(0, 10)


        observable.window(5)
                .map {
                    it.toList()
                }

                .subscribe(observer)


    }


}