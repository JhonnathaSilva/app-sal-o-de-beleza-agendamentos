package app.salao.thaismello.validation

import android.util.Patterns
import app.salao.thaismello.R
import app.salao.thaismello.singUp.FieldState

class EmailValidator {
    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validate(email: String): TextString? {
        if (email.isBlank()) {
            return ResourceString(R.string.email_is_required)

        }
        if (!isEmailValid(email)) {
            return ResourceString(R.string.email_is_invalid)
        }

        return null

    }
}