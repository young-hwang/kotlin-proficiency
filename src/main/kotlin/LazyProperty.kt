class LazyProperty(val initializer: () -> Int) {
    val lazy: Int
        get() {
            var value:Int ?= null
            if (value ==  null) {
                value = initializer()
            }
            return value!!
        }
}