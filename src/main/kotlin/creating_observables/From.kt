package creating_observables

import io.reactivex.Observable
import observer

object From {


    @JvmStatic
    fun main(vararg args: String) {

        val fromArray = Observable.fromArray(1, 2, 3, 4)
        fromArray.subscribe(observer)


        val fromCallable = Observable.fromCallable { "from callable" }
        fromCallable.subscribe(observer)


        val fromPublisher = Observable.fromPublisher<String> {
            it.onNext("fromPublisher1")
            it.onNext("fromPublisher2")
            it.onComplete()
        }
        fromPublisher.subscribe(observer)


    }


}