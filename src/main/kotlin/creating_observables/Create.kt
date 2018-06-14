package creating_observables

import io.reactivex.Observable
import observer

object Create {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.create<Long> {
            val started = System.currentTimeMillis()
            var value = 1L
            while (started + 1_000 > System.currentTimeMillis()) {
                it.onNext(value++)

                Thread.sleep(100)
            }
            it.onComplete()
        }

        observable.subscribe(observer)
    }
}