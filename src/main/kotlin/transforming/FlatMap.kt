package transforming

import io.reactivex.Observable
import observer
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object FlatMap {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.just(1, 2, 3, 4)


        observable.flatMap { doSomeHeavyTaskWithPassedValue(it) }
                .subscribe(observer)

    }


    private fun doSomeHeavyTaskWithPassedValue(value: Int): Observable<String> = Observable.fromCallable {
        sleep(100)
        "some product by id $value"
    }


}