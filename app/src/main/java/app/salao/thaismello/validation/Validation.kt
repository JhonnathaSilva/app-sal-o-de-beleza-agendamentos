package app.salao.thaismello.validation

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

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

interface TextString {
    @get:Composable
    val value: String
//    @Composable
//    fun asString(): String

}

class ResourceString(@StringRes private val input: Int) : TextString {
    override val value: String
        @Composable
        get() = stringResource(input)


}

class RawString(private val input: String) : TextString {

    override val value: String
        @Composable
        get() = input

}
