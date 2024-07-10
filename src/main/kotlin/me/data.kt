package me

data class Product(val description: String, val price: Double, val popularity: Int)

val cactus = Product("cactus", 11.2,  13)
val cake = Product("cake", 3.2,  111)
val camera = Product("camera", 134.5,  2)
val car = Product("car", 30000.0,  0)
val carrot = Product("carrot", 1.34,  5)
val cellphone = Product("cell phone", 129.9,  99)
val chimney = Product("chimney", 190.0,  2)
val certificate = Product("certificate", 99.9,  1)
val cigar = Product("cigar", 1.1,  2)
val coffee = Product("coffee", 3.2,  3)
val coffeeMaker = Product("coffee maker", 3.3,  4)
val cola = Product("cola", 2.5,  5)

fun getProducts() = listOf(cactus, cake, camera, car, cellphone, carrot, chimney, certificate, cigar, coffee, coffeeMaker, cola)