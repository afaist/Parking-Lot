class Fabric(var color: String) {
    var pattern: String = "none"
    var patternColor: String = "none"

    init {
        println("$color fabric is created")
    }

    constructor(color: String, _pattern: String, _patternColor: String) : this(color) {
        this.pattern = _pattern
        this.patternColor = _patternColor
        println("$patternColor $pattern pattern is printed on the fabric")
    }
}
