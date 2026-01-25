package app.salao.thaismello.validation

import app.salao.thaismello.R

class NameValidator {
    fun validate(name: String): TextString? {
        if (name.isBlank()) {
            return ResourceString(R.string.name_is_required)
        }

        if (name.length < 3) {
            return ResourceString(R.string.name_is_invalid)
        }
        return null
    }
}
