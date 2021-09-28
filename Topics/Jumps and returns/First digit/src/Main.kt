fun main() {
    readLine()!!.forEach { ch ->
        if (ch in '0'..'9') {
            println(ch)
            return
        }
    }
}