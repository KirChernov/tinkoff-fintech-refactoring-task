package ru.tinkoff.fintech.refactoring

data class Coffee(
    val name: String,
    val price: Double,
    val time: Int
) {
    companion object {
        private val coffeeStore = listOf(
            Coffee("эспрессо", 5.0, 5),
            Coffee("капучино", 3.48, 6)
        )

        fun getCoffeeByName(name: String): Coffee? {
            return coffeeStore.find { it.name == name }
        }
    }
}

fun calculateCoffeeBrewTimeInMinutes(coffee: Coffee): Int {
    return coffee.time
}