val rangeDegrees = -92..57

data class City(val name: String, val defaultDegrees: Int) {
    var degrees: Int = 0
        set(value) {
            field = if (value !in rangeDegrees) defaultDegrees else value
        }
}

fun main() {
    val first = readLine()!!.toInt()
    val second = readLine()!!.toInt()
    val third = readLine()!!.toInt()
    val firstCity = City("Dubai", 30)
    firstCity.degrees = first
    val secondCity = City("Moscow", 5)
    secondCity.degrees = second
    val thirdCity = City("Hanoi", 20)
    thirdCity.degrees = third

    val cities = listOf(firstCity, secondCity, thirdCity).sortedBy { it.degrees }
    println(if (cities[0].degrees == cities[1].degrees) "neither" else cities[0].name)
}