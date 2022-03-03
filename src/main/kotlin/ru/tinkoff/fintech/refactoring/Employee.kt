package ru.tinkoff.fintech.refactoring

interface BaristaInterface {
    fun makeCoffee(coffeeOrder: CoffeeOrder)
}

interface PizzaMakerInterface {
    fun makePizza(pizzaOrder: PizzaOrder)
}

class Barista : BaristaInterface {

    override fun makeCoffee(coffeeOrder: CoffeeOrder) {
        val coffee = coffeeOrder.coffee
        val orderId = coffeeOrder.number
        val roundedPrice = "%.2f".format(coffee.price)
        println("[Бариста] Готовлю напиток: ${coffee.name}")
        println("[Бариста] Время приготовления: ${calculateCoffeeBrewTimeInMinutes(coffee)} минут")
        println("[Бариста] Стоимость напитка: $roundedPrice")
        println("[Бариста] заказ $orderId готов")
    }
}

class PizzaMaker : PizzaMakerInterface {
    override fun makePizza(pizzaOrder: PizzaOrder) {

        val pizza = pizzaOrder.pizza
        val ingredients = getIngredient(pizza)
        val orderId = pizzaOrder.number

        println("[Пицца мейкер] Делаю пиццу: ${pizza.name}")
        println("[Пицца мейкер] Из ингридиетов:")

        var pizzaPrice = 0.0
        var ingredientCounter = 0
        ingredients.forEach {
            val ingredientName = it.first
            val ingredientCount = it.second
            val price = priceIngridients(ingredientName)
            println("[Пицца мейкер] - ${ingredientName}: в количестве $ingredientCount за $price$")
            pizzaPrice += price * ingredientCount
            ingredientCounter += ingredientCount
        }

        println("[Пицца мейкер] время приготовления $ingredientCounter минут")
        val roundedPrice = "%.2f".format(pizzaPrice)
        println("[Пицца мейкер] в сумме за все $roundedPrice$")
        println("[Пицца мейкер] заказ $orderId готов")
    }
}
