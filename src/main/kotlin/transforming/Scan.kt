package transforming

import io.reactivex.Observable
import observer
import other.Person
import other.persons
import java.lang.Thread.sleep
import java.util.concurrent.TimeUnit

object Scan {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.fromIterable(persons.toList())


        observable.scan { t1: Person, t2: Person ->  if (t1.age > t2.age) t1 else t2 }
                .takeLast(1)
                .subscribe(observer)

    }




}