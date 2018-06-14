package transforming

import io.reactivex.Observable
import observer
import other.Person
import other.persons
import java.util.*


object GroupBy {


    @JvmStatic
    fun main(vararg args: String) {

        val observable = Observable.fromIterable(persons.toList())

        observable
                .groupBy { it.age == 18 }
                .flatMapSingle {
                    val key = it.key
                    it.collect(
                            { Collections.singletonMap(it.key, ArrayList<Person>()) },
                            { map, value ->
                                map[key]?.add(value)
                            })

                }
                .subscribe(observer)

    }

}