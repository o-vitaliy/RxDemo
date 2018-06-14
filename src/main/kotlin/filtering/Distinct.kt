package filtering

import io.reactivex.Observable
import observer
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object Distinct {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.create<Long> {
            val started = System.currentTimeMillis()
            var value = 1L
            while (started + 1_000 > System.currentTimeMillis()) {

                it.onNext(value)
                it.onNext(value)
                it.onNext(value)
                it.onNext(value)

                value++

                Thread.sleep(100)
            }
            it.onComplete()
        }

        observable
                .distinct()
                .subscribe(observer)

        sleep(2000)
    }
}