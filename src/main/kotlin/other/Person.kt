package other


val persons = arrayOf(
        Person(age = 25, name = "Sue"),
        Person(age = 25, name = "Frank"),
        Person(age = 30, name = "Joe"),
        Person(age = 35, name = "Sarah"),
        Person(age = 18, name = "Vitaliy")
        )

data class Person(
        val name: String,
        val age: Int
)