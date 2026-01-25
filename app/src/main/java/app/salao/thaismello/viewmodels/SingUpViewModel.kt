package app.salao.thaismello.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import app.salao.thaismello.singUp.FieldState
import app.salao.thaismello.singUp.FormState
import app.salao.thaismello.validation.BirthDayValidator
import app.salao.thaismello.validation.ConfirmPasswordValidator
import app.salao.thaismello.validation.EmailValidator
import app.salao.thaismello.validation.NameValidator
import app.salao.thaismello.validation.PasswordValidator
import app.salao.thaismello.validation.PhoneValidator

class SingUpViewModel : ViewModel() {

    var formState by mutableStateOf(FormState())

    val nameValidator = NameValidator()
    val emailValidator = EmailValidator()
    val phoneValidator = PhoneValidator()
    val birthDayValidator = BirthDayValidator()
    val passwordValidator = PasswordValidator()
    val confirmPasswordValidator = ConfirmPasswordValidator()


    fun updateName(newName: String) {
        val textString = nameValidator.validate(newName)
        formState = formState.copy(
            name = FieldState(
                field = newName,
                error = textString,
                isValid = textString == null
            )
        )
        updateButton()
    }

    fun updateEmail(newEmail: String) {
        val textString = emailValidator.validate(newEmail)
        formState = formState.copy(
            email = FieldState(
                field = newEmail,
                error = textString,
                isValid = textString == null
            )
        )
        updateButton()
    }

    fun updatePassword(newPassword: String) {
        val digitsOnly = newPassword.filter { it.isDigit() }
        val textString = passwordValidator.validate(digitsOnly)
        formState = formState.copy(
            password = FieldState(
                field = digitsOnly,
                error = textString,
                isValid = textString == null
            )
        )
        updateButton()
    }

    fun updatePasswordConfirm(confirmPassword: String) {
        val textString =
            confirmPasswordValidator.validate(confirmPassword, formState.password.field)
        formState =
            formState.copy(
                confirmPassword = FieldState(
                    field = confirmPassword,
                    error = textString,
                    isValid = textString == null
                )
            )
        updateButton()
    }

    fun updatePhone(newPhone: String) {
        val textString = phoneValidator.validate(formState.phone.field, newPhone)

        formState = formState.copy(
            phone = FieldState(
                field = phoneValidator.result,
                error = textString,
                isValid = textString == null
            )
        )
        updateButton()

    }

    fun updateBirthday(newBirthday: String) {
        val textString = birthDayValidator.validate(formState.birthDate.field, newBirthday)
        formState = formState.copy(
            birthDate = FieldState(
                field = birthDayValidator.result,
                error = textString,
                isValid = textString == null
            )
        )
        updateButton()

    }

    private fun updateButton(){
        val formIsValid = with(formState){
            email.isValid &&
                    name.isValid &&
                    phone.isValid &&
                    birthDate.isValid &&
                    password.isValid &&
                    confirmPassword.isValid
        }
        formState = formState.copy(
            formIsValid = formIsValid
        )
    }

}
