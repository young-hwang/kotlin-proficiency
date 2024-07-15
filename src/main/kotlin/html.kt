open class Tag(val name: String) {
    val children = mutableListOf<Tag>()
    val attributes = mutableListOf<Attribute>()

    override fun toString(): String {
        return "<$name" +
        (if (attributes.isEmpty()) "" else attributes.joinToString(" ", prefix = " ")) + ">" +
        (if (children.isEmpty()) "" else  children.joinToString(" ")) +
        "</$name>"
    }
}

class Attribute(val name: String, val value: String) {
    override fun toString(): String {
        return """$name="$value"""
    }
}




