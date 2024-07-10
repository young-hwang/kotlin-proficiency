package me

fun renderProductTable(): String {
    return html {
        table {
            tr("###") {
                td {
                    text("Produc")
                }
                td {
                    text("Producb")
                }
                td {
                    text("Producta")
                }
            }
        }
    }.toString()
}

fun main() {
//    println("Hello World!")
    println(renderProductTable())
}