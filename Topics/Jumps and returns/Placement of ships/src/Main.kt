fun main() = Array(3) { readLine()!!.split(" ").map { it.toInt() } }
    .let { ships ->
        val rows = ships.map { it.first() }
        val columns = ships.map { it.last() }
        println((1..5).filterNot { it in rows }.joinToString(" "))
        println((1..5).filterNot { it in columns }.joinToString(" "))
    }
