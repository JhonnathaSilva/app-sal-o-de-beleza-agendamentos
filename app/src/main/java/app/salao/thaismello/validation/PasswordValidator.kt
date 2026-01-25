package app.salao.thaismello.validation

import app.salao.thaismello.R
import app.salao.thaismello.singUp.FieldState

class PasswordValidator {

    fun validate (password: String) : TextString? {
        val digitsOnly = password.filter { isNumber -> isNumber.isDigit() }

        if (digitsOnly.isBlank()) {
            return  ResourceString(R.string.password_is_required)

        }
        if (digitsOnly.length < 8) {
            return ResourceString(R.string.password_is_invalid)

        }
        return null
    }
}