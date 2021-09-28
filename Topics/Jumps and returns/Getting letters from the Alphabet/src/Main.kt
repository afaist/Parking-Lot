fun main() {
    val letter = readLine()!!.first()
    for (c in 'a'..'z') {
        if (c == letter) return
        print(c)
    }
}