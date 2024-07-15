package me

import Customer
import LazyProperty
import Order
import Product
import Shop
import task

fun findMostExpensiveProductBy(customer: Customer): Product? {
    return customer.orders
        .filter(Order::isDelivered)
        .flatMap(Order::products)
        .maxByOrNull(Product::price)
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return customers.flatMap(Customer::orders)
        .flatMap(Order::products)
        .count { it == product }
}

fun Customer.getOrderedProducts() : List<Product> = orders.flatMap(Order::products)

fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { s -> s.length }
    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.maxOrNull()
    return groupsByLength.values.firstOrNull { group -> group.size == maximumSizeOfGroup }
}

fun main() {
    println(task())
}
