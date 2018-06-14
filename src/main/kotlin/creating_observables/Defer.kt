package creating_observables

import io.reactivex.Observable
import observer

object Defer {


    @JvmStatic
    fun main(vararg args: String) {

        val deferred = Observable.defer { Observable.just(1, 2, 3, 4) }

        deferred.subscribe(observer)
    }
}