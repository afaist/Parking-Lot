fun main(args: Array<String>) {
    val speed = readLine()!!.toInt()
    val limit = readLine()!!.run { if (this == "no limit") 60 else this.toInt() }
    println(if (speed > limit) "Exceeds the limit by ${speed - limit} kilometers per hour" else "Within the limit")
}