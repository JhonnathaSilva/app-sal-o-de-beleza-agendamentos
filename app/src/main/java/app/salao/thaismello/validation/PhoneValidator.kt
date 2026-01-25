package app.salao.thaismello.validation

import android.util.Patterns
import app.salao.thaismello.R

class PhoneValidator {
    val pattern = "(##) #####-####"
    lateinit var result: String

    fun validate(currentPhone: String, phone: String): TextString? {
        result = Mask(pattern, currentPhone, phone)

        if (result.length != pattern.length) {
            return ResourceString(R.string.phone_is_invalid)
        }
        return null
    }
}