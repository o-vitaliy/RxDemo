package creating_observables

import io.reactivex.Observable
import observer

object Never {


    @JvmStatic
    fun main(vararg args: String) {

        val never = Observable.never<Long>()

        never.subscribe(observer)
    }
}