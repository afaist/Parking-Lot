data class Client(val name: String, val age: Int, val balance: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        } else {
            if (other is Client) {
                return name == other.name && age == other.age
            }
            return false
        }
    }
}

fun main() = println(
    Client(readLine()!!, readLine()!!.toInt(), readLine()!!.toInt()) ==
            Client(readLine()!!, readLine()!!.toInt(), readLine()!!.toInt())
)