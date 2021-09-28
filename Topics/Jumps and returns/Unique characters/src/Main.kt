fun main() {
    var str = readLine()!!
    var count = 0
    while (str.isNotEmpty()) {
        val char = str[0]
        if (char !in str.substring(1)) {
            count++
        }
        str = str.replace(char.toString(), "")
    }
    println(count)
}