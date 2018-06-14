import io.reactivex.Observer
import io.reactivex.disposables.Disposable

val observer = object : Observer<Any> {
    override fun onComplete() {
        println("done")
        println()
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: Any) {
        println(t)
    }

    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}