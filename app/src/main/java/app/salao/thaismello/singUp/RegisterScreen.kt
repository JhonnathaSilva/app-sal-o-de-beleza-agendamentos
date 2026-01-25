package app.salao.thaismello.singUp

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import app.salao.thaismello.componente.GradientButton
import app.salao.thaismello.componente.PhotoIcon
import app.salao.thaismello.componente.SalonTextField
import app.salao.thaismello.ui.theme.ColorGoldLight
import app.salao.thaismello.ui.theme.DarkGray
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.LightGray
import app.salao.thaismello.ui.theme.NearBlack
import app.salao.thaismello.viewmodels.SingUpViewModel

@Composable
fun RegisterScreen(
    singUpViewModel: SingUpViewModel = viewModel(),
    onCreateAccount: () -> Unit = {},
    onNavigateToLogin: () -> Unit = {}
) {
    val context = LocalContext.current

    var showPassword by rememberSaveable { mutableStateOf(false) }
    var showConfirmPassword by rememberSaveable { mutableStateOf(false) }
    var acceptedTerms by rememberSaveable { mutableStateOf(false) }
    var termsError by remember { mutableStateOf<String?>(null) }
    val scrollState = rememberScrollState()


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Gold, NearBlack, DarkGray),
                    startY = 0.0f
                )
            ),
        color = Color.Transparent
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            PhotoIcon()

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Criar Conta",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Preencha seus dados para começar",
                color = LightGray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                SalonTextField(
                    value = singUpViewModel.formState.name.field,
                    label = "Nome",
                    placeholder = "Maria Silva",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Person,
                            contentDescription = "Ícone de usuário"
                        )
                    },
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    isError = singUpViewModel.formState.name.error?.value,
                ) { name -> singUpViewModel.updateName(name) }

                SalonTextField(
                    value = singUpViewModel.formState.email.field,
                    label = "E-mail",
                    placeholder = "seu@email.com",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.MailOutline,
                            contentDescription = "Ícone de e-mail"
                        )
                    },
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next,
                    isError = singUpViewModel.formState.email.error?.value,
                ) { email -> singUpViewModel.updateEmail(email) }

                // Telefone
                SalonTextField(
                    value = TextFieldValue(
                        text = singUpViewModel.formState.phone.field,
                        selection = TextRange(singUpViewModel.formState.phone.field.length)
                    ),
                    label = "Telefone",
                    placeholder = "(64) 98765-4321",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Phone,
                            contentDescription = "Ícone de telefone"
                        )
                    },
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Next,
                    isError = singUpViewModel.formState.phone.error?.value,
                ) { phone -> singUpViewModel.updatePhone(phone.text) }


                SalonTextField(
                    value = TextFieldValue(
                        text = singUpViewModel.formState.birthDate.field,
                        selection = TextRange(singUpViewModel.formState.birthDate.field.length)
                    ),
                    label = "Data de nascimento",
                    placeholder = "DD/MM/AAAA",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.CalendarToday,
                            contentDescription = "Ícone de calendário"
                        )
                    },
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next,
                    isError = singUpViewModel.formState.birthDate.error?.value
                ) { singUpViewModel.updateBirthday(it.text) }


                SalonTextField(
                    value = singUpViewModel.formState.password.field,
                    label = "Senha",
                    placeholder = "Mínimo 8 caracteres",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Ícone de cadeado"
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { showPassword = !showPassword }) {
                            Icon(
                                imageVector = if (showPassword) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                                contentDescription = if (showPassword) "Ocultar senha" else "Mostrar senha"
                            )
                        }
                    },
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Next,
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    isError = singUpViewModel.formState.password.error?.value,
                ) { password -> singUpViewModel.updatePassword(password) }

                SalonTextField(
                    value = singUpViewModel.formState.confirmPassword.field,
                    label = "Confirmar senha",
                    placeholder = "Digite a senha novamente",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = "Ícone de cadeado"
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = { showConfirmPassword = !showConfirmPassword }) {
                            Icon(
                                imageVector = if (showConfirmPassword) Icons.Outlined.Visibility else Icons.Outlined.VisibilityOff,
                                contentDescription = if (showConfirmPassword) "Ocultar senha" else "Mostrar senha"
                            )
                        }
                    },
                    keyboardType = KeyboardType.NumberPassword,
                    imeAction = ImeAction.Done,
                    visualTransformation = if (showConfirmPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    isError = singUpViewModel.formState.confirmPassword.error?.value,
                ) { confirmPassword -> singUpViewModel.updatePasswordConfirm(confirmPassword) }
            }
            Spacer(modifier = Modifier.height(24.dp))

            GradientButton(
                text = "Criar Conta",
                textColor = Color.Black,
                enabled = singUpViewModel.formState.formIsValid,

            ){}

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Já tem uma conta? ",
                    color = LightGray,
                    fontSize = 14.sp
                )
                TextButton(onClick = onNavigateToLogin) {
                    Text(
                        text = "Entrar",
                        color = Gold,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 14.sp
                    )
                }
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen()
}


