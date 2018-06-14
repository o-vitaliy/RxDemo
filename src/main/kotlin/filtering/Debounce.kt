package filtering

import io.reactivex.Observable
import observer
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object Debounce {


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

        observable
                .debounce(200, TimeUnit.MILLISECONDS)
                .subscribe(observer)

        sleep(2000)
    }
}