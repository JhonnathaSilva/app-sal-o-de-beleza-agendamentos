package app.salao.thaismello.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.salao.thaismello.login.LoginUiState
import app.salao.thaismello.singUp.FieldState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    var uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()


    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set


    fun updatePassword (newPassword: String) {
        password = newPassword
    }


    fun updateEmail(newEmail: String) {
        email = newEmail
    }



    fun singIn() {
        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch{
            delay(3000)
        }

        _uiState.update { it.copy(isLoading = true, goToHome = true) }



    }


}