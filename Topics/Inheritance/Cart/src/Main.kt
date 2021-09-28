fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = when (productType) {
        "headphones" -> Headphones(price)
        "smartphone" -> Smartphone(price)
        "tv" -> Tv(price)
        "laptop" -> Laptop(price)
        else -> Product(price)
    }
    println(totalPrice(product))
}

fun totalPrice(product: Product) = product.totalPrice

open class Product(private val price: Int, private val tax: Double = 0.0) {
    val totalPrice: String
        get() = "%.0f".format(price + price * tax)
}

class Headphones(price: Int) : Product(price, 0.11)

class Smartphone(price: Int) : Product(price, 0.15)

class Tv(price: Int) : Product(price, 0.17)

class Laptop(price: Int) : Product(price, 0.19)