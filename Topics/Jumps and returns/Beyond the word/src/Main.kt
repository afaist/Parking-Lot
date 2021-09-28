fun main() {
    val str = readLine()!!
    for (char in 'a'..'z') {
        if (char in str) continue
        print(char)
    }
}