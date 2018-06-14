@file:JvmName("RxDemo")

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import java.lang.Thread.sleep

object RxDemo {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.create<Long> {
            val started = System.currentTimeMillis()
            while (started + 1_000 > System.currentTimeMillis()) {
                it.onNext(System.currentTimeMillis())

                sleep(100)
            }
            it.onComplete()
        }

        observable
                .subscribeBy(
                        onNext = {
                            println("onNext ----->> " + Thread.currentThread().name)
                        },
                        onComplete = {
                            println("done:  ----->>" + Thread.currentThread().name)
                        }
                )
    }
}