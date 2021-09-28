package parking

fun main() {
    var parking: ParkingLot? = null

    loop@ while (true) {
        val inputStr = readLine()!!.split(" ")
        val command = inputStr[0]
        when (command) {
            "exit" -> break@loop
            "create" -> {
                parking = ParkingLot(inputStr[1].toInt())
                continue@loop
            }
        }
        if (parking == null) {
            println("Sorry, a parking lot has not been created.")
            continue@loop
        } else {
            when (command) {
                "park" -> {
                    parking.park(inputStr.slice(1..2))
                }
                "leave" -> {
                    parking.leave(inputStr[1].toInt())
                }
                "status" -> parking.status()
                "spot_by_color" -> parking.getSpotsByColor(inputStr[1])
                "spot_by_reg" -> parking.getSpotsByReg(inputStr[1])
                "reg_by_color" -> parking.getRegsByColor(inputStr[1])
            }
        }
    }
}

data class Car(val regNum: String, var color: String)

data class Spot(val number: Int, var car: Car? = null) {
    /**
     * Is spot empty
     */
    fun isEmpty(): Boolean {
        return car == null
    }

    /**
     * Put car in spot
     */
    fun putCarInSpot(carInfo: List<String>): Boolean {
        return if (car == null) {
            val carNumber = carInfo.first().uppercase()
            val carColor = carInfo.last()[0].uppercaseChar() + carInfo.last().drop(1)
            car = Car(carNumber, carColor)
            println("$carColor car parked in spot $number.")
            true
        } else {
            println("Spot $number is busy!")
            false
        }
    }

    fun removeCar(): Boolean {
        println("Spot $number is free.")
        return if (car == null) {
            false
        } else {
            car = null
            true
        }
    }

    /**
     * Is spot not empty
     */
    fun isNotEmpty(): Boolean {
        return !isEmpty()
    }

    /**
     * toString()
     */
    override fun toString(): String {
        return if (car == null) {
            "There is no car in spot $number."
        } else {
            "$number ${car!!.regNum} ${car!!.color}"
        }
    }

    /**
     * return car color or ""
     */
    fun getCarColor(): String {
        if (car != null) {
            return car!!.color.lowercase()
        }
        return ""
    }

    /**
     * Get car number or ""
     */
    fun getCarNumber(): String {
        if (car != null) {
            return car!!.regNum.uppercase()
        }
        return ""
    }
}

class ParkingLot(private val _spots: Int) {
    private var parking = Array(_spots) { i -> Spot(i + 1) }
    private var numberOfCars = 0

    init {
        println("Created a parking lot with $_spots spots.")
    }

    /**
     * return minimal number of free spot
     */
    private fun getFreeSpot(): Int {
        if (numberOfCars == _spots) {
            return 0
        }
        for (i in parking.indices) {
            if (parking[i].isEmpty()) {
                return i + 1
            }
        }
        return 0
    }

    /**
     * park car
     */
    fun park(carInfo: List<String>) {
        val freeSpot = getFreeSpot()
        if (freeSpot == 0) {
            println("Sorry, the parking lot is full.")
        } else {
            val spot = parking[freeSpot - 1]
            if (spot.putCarInSpot(carInfo)) {
                numberOfCars++
            }
        }
    }

    /**
     * leave spot with number
     */
    fun leave(number: Int) {
        val spot = parking[number - 1]
        if (spot.isNotEmpty()) {
            spot.removeCar()
            numberOfCars--
        } else {
            // spot is empty
            println(spot)
        }
    }

    /**
     * Print status of parking lot
     */
    fun status() {
        if (numberOfCars == 0) println("Parking lot is empty.")
        else {
            for (i in parking.indices) {
                val spot = parking[i]
                if (spot.isNotEmpty()) {
                    println("$spot")
                }
            }
        }
    }

    fun getSpotsByColor(color: String) {
        val carColor = color.lowercase()
        val numbersSpots = mutableListOf<Int>()
        if (numberOfCars > 0) {
            for (i in parking.indices) {
                val spot = parking[i]
                if (spot.getCarColor() == carColor) {
                    numbersSpots.add(spot.number)
                }
            }
        }
        if (numbersSpots.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(numbersSpots.joinToString())
        }
    }

    fun getSpotsByReg(regNum: String) {
        val carRegNum = regNum.uppercase()
        val numbersSpots = mutableListOf<Int>()
        if (numberOfCars > 0) {
            for (i in parking.indices) {
                val spot = parking[i]
                if (spot.getCarNumber() == carRegNum) {
                    numbersSpots.add(spot.number)
                }
            }
        }
        if (numbersSpots.isEmpty()) {
            println("No cars with registration number $regNum were found.")
        } else {
            println(numbersSpots.joinToString())
        }
    }

    fun getRegsByColor(color: String) {
        val carColor = color.lowercase()
        val numbersSpots = mutableListOf<String>()
        if (numberOfCars > 0) {
            for (i in parking.indices) {
                val spot = parking[i]
                if (spot.getCarColor() == carColor) {
                    numbersSpots.add(spot.getCarNumber())
                }
            }
        }
        if (numbersSpots.isEmpty()) {
            println("No cars with color $color were found.")
        } else {
            println(numbersSpots.joinToString())
        }
    }
}
