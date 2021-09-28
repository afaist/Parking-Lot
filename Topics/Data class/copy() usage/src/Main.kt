// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val (height, length1, length2, width) = Array(4) { readLine()!!.toInt() }
    val box1 = Box(height, length1, width)
    val box2 = box1.copy(length = length2)
    println(box1)
    println(box2)
}