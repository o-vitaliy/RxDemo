package transforming

import io.reactivex.Observable
import observer
import java.util.concurrent.TimeUnit

object Buffer {


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



        observable.buffer(2)
                .subscribe(observer)


        observable.buffer(500, TimeUnit.MILLISECONDS)
                .subscribe(observer)
    }
}