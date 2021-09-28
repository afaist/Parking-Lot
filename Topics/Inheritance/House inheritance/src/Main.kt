fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House(rooms, price)
    println(totalPrice(house))
}

fun totalPrice(house: House) = house.getTotalPrice()

class House(rooms: Int, price: Int) {
    private val internalPrice = if (price > 1_000_000) 1_000_000 else if (price < 0) 0 else price

    private val coefficient = when {
        rooms <= 1 -> 1.0
        rooms in 2..3 -> 1.2
        rooms == 4 -> 1.25
        rooms in 5..7 -> 1.4
        else -> 1.6
    }

    fun getTotalPrice() = "%.0f".format(internalPrice * coefficient)
}
