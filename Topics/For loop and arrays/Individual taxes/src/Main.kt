fun main() {
    val numberOfCompanies = readLine()!!.toInt()
    val annualIncomes = IntArray(numberOfCompanies) { readLine()!!.toInt() }
    val taxes = IntArray(numberOfCompanies) { i -> readLine()!!.toInt() * annualIncomes[i] }
    println(taxes.indexOf(taxes.maxOrNull()!!) + 1)
}