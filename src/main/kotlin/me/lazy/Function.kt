package me.lazy

fun task(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0}
    val isOdd: Int.() -> Boolean = { this % 2 == 1}
    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}

fun<K, V> buildMutableMap(build: HashMap<K, V>.() -> Unit): Map<K, V> {
    val map = HashMap<K, V>()
    map.build()
    return map
}

fun usage(): Map<Int, String> {
    return buildMutableMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
