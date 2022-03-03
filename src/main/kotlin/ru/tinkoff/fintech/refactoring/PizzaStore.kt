package ru.tinkoff.fintech.refactoring

data class PizzaOrder(
    val number: Int,
    val pizza: Pizza
)

data class CoffeeOrder(
    val number: Int,
    val coffee: Coffee
)

class PizzaStore {
    var orderNumber = 0
    private val pizzaMaker = PizzaMaker()
    private val barista = Barista()
    fun orderCoffee(name: String): CoffeeOrder {
        val coffee = Coffee.getCoffeeByName(name)
            ?: error("Неизвестный вид кофе!")
        return CoffeeOrder(++orderNumber, coffee
        )
    }

    fun orderPizza(name: String): PizzaOrder {
        val pizza = Pizza(name)

        return PizzaOrder(++orderNumber, pizza
        )
    }

    fun executeOrder(pizzaOrder: PizzaOrder? = null, coffeeOrder: CoffeeOrder? = null) {
        if (pizzaOrder != null) {
            pizzaMaker.makePizza(pizzaOrder)
        }

        if (coffeeOrder != null) {
            barista.makeCoffee(coffeeOrder)
        }
    }
}