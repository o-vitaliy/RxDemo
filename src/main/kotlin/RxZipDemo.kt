@file:JvmName("RxDemo")

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.functions.BiFunction
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import java.lang.Thread.sleep
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ThreadFactory

object RxZipDemo {


    private val scheduler1 = createScheduler("executor 1")

    private val schedulerUi1 = createScheduler("ui 1")

    private val scheduler2 = createScheduler("executor 2")

    private val schedulerUi2 = createScheduler("ui 2")

    private val scheduler3 = createScheduler("executor 3")

    private val schedulerUi3 = createScheduler("ui 3")

    @JvmStatic
    fun main(vararg args: String) {
        Observable.zip(
                random().subscribeOn(scheduler1).observeOn(schedulerUi1),
                random().subscribeOn(scheduler2).observeOn(schedulerUi2),
                BiFunction<Long, Long, Long> { t1, t2 ->
                    println("in zip -->> " + Thread.currentThread().name)
                    t1 + t2
                }
        ).subscribeOn(scheduler3).observeOn(schedulerUi3)
                .flatMap {
                           longToObservable(it)
                }
                .subscribeBy(
                        onNext = {
                            println("onNext -->> " + Thread.currentThread().name)
                        }
                )


        sleep(1000)

        //Schedulers.shutdown()
    }


    private fun random(): Observable<Long> = Observable.create<Long> {
        println("create -->> " + Thread.currentThread().name)
        sleep(Math.abs(Random().nextGaussian() * 100).toLong())
        it.onNext(Random().nextLong())
        it.onComplete()
    }
            .doOnNext {
                println("doOnNext -->> " + Thread.currentThread().name)
            }
            .doOnSubscribe {
                println("doOnSubscribe -->> " + Thread.currentThread().name)
            }


    private fun createScheduler(poolName: String): Scheduler {
        return Schedulers.from(Executors.newSingleThreadScheduledExecutor(CustomThreadFactory(poolName)))
        // return Schedulers.io()
        //   return Schedulers.newThread()
    }


    class CustomThreadFactory(private val poolName: String) : ThreadFactory {
        var count = 1
        override fun newThread(r: Runnable) = Thread(r, poolName/* + " " + count++ */)
    }





    private fun longToObservable(long: Long) = Observable.just(long)
            .map {
                println("longToObservable   -->> " + Thread.currentThread().name)
                it
            }

}