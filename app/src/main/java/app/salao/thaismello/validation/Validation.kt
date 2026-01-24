package app.salao.thaismello.validation

fun Mask(pattern: String,currentValue: String, value: String): String {
    val cleanValue = value.filter { it.isDigit() }
    var result = ""
    var i = 0

    for (char in pattern){
        if (char != '#'){
            result += char
            if (currentValue > value && result.length >= value.length){
                result = result.dropLast(1)
            }
            continue
        }
        if (i >= cleanValue.length) {
            break
        }
        result += cleanValue[i]
        i++
    }
    return result
}
