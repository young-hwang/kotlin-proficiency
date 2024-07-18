package me.calculator

val trim: Regex = """[^.\d-+*/()]""".toRegex()
fun trim(v:String):String = v.replace(trim,"")
fun repMtoPM(v:String):String = v.replace("-", "+-")
val groupMD: Regex = """((?:\+|\+-)?[.\d]+)([*/])((?:\+|\+-)?[.\d]+)""".toRegex()
val groupParentheses: Regex = """\(([^()]*)\)""".toRegex()
fun foldGroup(v:String):Double {
    var value = groupMD.findAll(v).fold(0.0){ acc, curr ->
        val (_, left, op, right) = curr.groupValues
        val leftValue = left.replace("+", "").toDouble()
        val rightValue = right.replace("+", "").toDouble()
        val result = when(op) {
            "*" -> leftValue * rightValue
            "/" -> leftValue / rightValue
            else -> throw Throwable("invalid operator $op")
        }
        return acc + result
    }
    value += v.split('+').filter{ it.isNotEmpty()}.sumOf { it.toDouble() }
    return value
}

fun calc(v:String):Double {
    var expr = trim(v)
    while(groupParentheses.containsMatchIn(expr)) {
        expr = groupParentheses.replace(expr) {
            val innerExpr = it.groupValues[1]
            calc(repMtoPM( innerExpr)).toString()
        }
    }
    return foldGroup(repMtoPM( expr))
}

fun main() {
    println(calc("-2*(-3+0.4)/-0.2"))
}