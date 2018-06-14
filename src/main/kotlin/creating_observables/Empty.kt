package creating_observables

import io.reactivex.Observable
import observer

object Empty {


    @JvmStatic
    fun main(vararg args: String) {

        val empty = Observable.empty<Long>()

        empty.subscribe(observer)
    }
}