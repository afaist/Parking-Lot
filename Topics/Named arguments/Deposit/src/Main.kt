import kotlin.math.pow

fun main() {
    val parameter = readLine()!!
    val value = readLine()!!.toInt()
    println(
        when (parameter) {
            "amount" -> finalAmount(amount = value)
            "percent" -> finalAmount(percent = value)
            "years" -> finalAmount(years = value)
            else -> {
                finalAmount()
            }
        }
    )
}

fun finalAmount(amount: Int = 1000, percent: Int = 5, years: Int = 10): Int {
    return (amount * (1 + percent / 100.0).pow(years)).toInt()
}
