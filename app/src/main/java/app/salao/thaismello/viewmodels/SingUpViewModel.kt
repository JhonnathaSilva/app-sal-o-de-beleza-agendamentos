package app.salao.thaismello.viewmodels

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import app.salao.thaismello.singUp.FieldState
import app.salao.thaismello.singUp.FormState
import app.salao.thaismello.validation.Mask
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SingUpViewModel : ViewModel() {

    var formState by mutableStateOf(FormState())


    fun updateName(newName: String) {
        if (newName.isBlank()) {
            formState = formState.copy(name = FieldState(field = newName))
            return
        }
        if (newName.length < 3) {
            formState = formState.copy(name = FieldState(field = newName, error = "Nome deve ter no mínimo 3 caracteres"))
            return
        }

        formState = formState.copy(name = FieldState(field = newName, error = null))
    }

    fun updateEmail(newEmail: String) {
        if (newEmail.isBlank()) {
            formState =
                formState.copy(email = FieldState(field = newEmail, error = "E-mail é obrigatório"))
            return
        }
        if (!isEmailValid(newEmail)) {
            formState =
                formState.copy(email = FieldState(field = newEmail, error = "E-mail inválido"))
            return
        }
        formState = formState.copy(email = FieldState(field = newEmail, error = null))
    }

    fun updatePassword(newPassword: String) {
        val digitsOnly = newPassword.filter { isNumber -> isNumber.isDigit() }

        if (digitsOnly.isBlank()) {
            formState =
                formState.copy(password = FieldState(field = digitsOnly, error = "Senha é obrigatória"))
            return
        }
        if (digitsOnly.length < 8) {
            formState =
                formState.copy(password = FieldState(field = digitsOnly, error = "Senha deve ter no mínimo 8 caracteres"))
            return
        }
        formState = formState.copy(password = FieldState(field = digitsOnly, error = null))
    }

    fun updatePasswordConfirm(confirmPassword: String) {
        if (confirmPassword.isBlank()) {
            formState =
                formState.copy(confirmPassword = FieldState(field = confirmPassword, error = "Senha é obrigatória"))
            return
        }
        if (confirmPassword != formState.password.field) {
            formState =
                formState.copy(confirmPassword = FieldState(field = confirmPassword, error = "Confirmar senha deve ser igual a senha"))
            return
        }
        formState = formState.copy(confirmPassword = FieldState(field = confirmPassword, error = null))
    }

    fun updatePhone(newPhone: String){
        val pattern = "(##) #####-####"
        val currentPhone = formState.phone.field
        val result = Mask(pattern,currentPhone ,newPhone)


        if (!Patterns.PHONE.matcher(newPhone).matches()){
            formState = formState.copy(phone = FieldState(field = result, error = "Telefone inválido"))
            return
        } else {
            formState = formState.copy(phone = FieldState(field = result.format(), error = null))
        }
    }
    private fun isEmailValid(email: String): Boolean{
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun UpdateBirthday(newBirthday: String) {
        val pattern = "##/##/####"
        val currentBithDay = formState.birthDate.field
        val result = Mask(pattern, currentBithDay, newBirthday)

        if (result.isBlank()) {
            formState =
                formState.copy(
                    birthDate = FieldState(field = result, error = "Data de nascimento é obrigatório")
                )
            return
        }

        if (result.length != pattern.length) {
            formState = formState.copy(
                birthDate = FieldState(field = result, error = "Data de nascimento inválida")
            )
            return
        }

        try {
            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).run {
                isLenient = false
                parse(result)
            }?.also {
                val now = Date()
                if (it.after(now)) {
                    formState = formState.copy(
                        birthDate = FieldState(field = result, error = "Data de nascimento não pode ser maior que hoje")
                    )
                    return
                }

            }

            formState = formState.copy(
                birthDate = FieldState(field = result, error = null)
            )

        } catch (e: ParseException) {
            formState = formState.copy(
                birthDate = FieldState(field = result, error = "Data de nascimento inválida")
            )
        }

    }

}
