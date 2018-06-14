package creating_observables

import io.reactivex.Observable
import observer

object Throw {


    @JvmStatic
    fun main(vararg args: String) {

        val error = Observable.error<Long>(Exception("wtf?!"))

        error.subscribe(observer)
    }
}