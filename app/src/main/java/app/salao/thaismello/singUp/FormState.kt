package app.salao.thaismello.singUp

import app.salao.thaismello.validation.TextString

data class FormState(
    val email: FieldState = FieldState(),
    val password: FieldState = FieldState(),
    val confirmPassword: FieldState = FieldState(),
    val name: FieldState = FieldState(),
    val phone: FieldState = FieldState(),
    val birthDate: FieldState = FieldState(),
    val formIsValid: Boolean = false,
)

data class FieldState(
    var field: String = "",
    var error: TextString? = null,
    val isValid: Boolean = false
)

