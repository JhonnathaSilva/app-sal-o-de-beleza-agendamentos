package app.salao.thaismello.validation

import app.salao.thaismello.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class BirthDayValidator {
    private val pattern = "##/##/####"
    lateinit var result: String

    fun validate(currentBithDay: String, birthDay: String): TextString? {
        result = Mask(pattern, currentBithDay, birthDay)

        if (result.isBlank()) {
            return ResourceString(R.string.error_birthday_blank)
        }

        if (result.length != pattern.length) {

            return ResourceString(R.string.error_birthday_invalid)
        }

        try {
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).run {
                isLenient = false
                parse(result)
            }?.also {
                val now = Date()
                if (it.after(now)) {

                    return ResourceString(R.string.error_birthday_future_invalid)
                }

            }
        } catch (e: ParseException) {
            return ResourceString(R.string.error_birthday_invalid)
        }
        return null
    }
}