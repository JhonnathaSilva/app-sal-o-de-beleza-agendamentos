package app.salao.thaismello.validation

import app.salao.thaismello.R
import app.salao.thaismello.singUp.FieldState

class ConfirmPasswordValidator {

    fun validate(confirmPassword: String, password: String): TextString? {
        if (confirmPassword.isBlank()) {
            return ResourceString(R.string.confirm_password_is_required)
        }
        if (confirmPassword != password) {
            return ResourceString(R.string.confirm_password_is_invalid)
        }
        return null
    }
}