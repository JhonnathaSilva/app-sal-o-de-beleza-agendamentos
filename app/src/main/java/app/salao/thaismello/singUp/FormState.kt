package app.salao.thaismello.singUp

data class FieldState(
    var field: String = "",
    var error: String? = null
)

data class FormState(
    val email: FieldState = FieldState(),
    val password: FieldState = FieldState(),
    val confirmPassword: FieldState = FieldState(),
    val name: FieldState = FieldState(),
    val phone: FieldState = FieldState(),
    val birthDate: FieldState = FieldState(),
)