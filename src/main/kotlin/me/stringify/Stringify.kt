package me.stringify

import kotlin.reflect.KProperty

fun <T: Any> stringify(target: T): String {
    // forEach에서 KProperty 를 사용하기 위해서는 형변환이 필요
    // 이를 간단히 하기 위해 kotlin은 filterInstance 제공
    // target::class.members.filter { it is KProperty<*> }.forEach {
    //     val prop = it as KProperty<*>
    // }
    val builder = StringBuilder()
    builder.append("{")
    target::class.members.filterIsInstance<KProperty<*>>().forEach{
        builder.append(it.name, ":")
        val value = it.getter.call(target)
        builder.append(value,",")
    }
    builder.append("}")
    return "$builder"
}

class Json(val a: Int, val b: String)

fun main() {
    println(stringify(Json(a = 10, b = "abc")))
}