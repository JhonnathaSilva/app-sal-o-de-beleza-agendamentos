package app.salao.thaismello.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.salao.thaismello.R
import app.salao.thaismello.componente.GradientButton
import app.salao.thaismello.componente.PhotoIcon
import app.salao.thaismello.ui.theme.DarkGray
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.LightGray
import app.salao.thaismello.ui.theme.NearBlack

@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit = {}
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
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
                text = stringResource(R.string.bem_vindo_de_volta),
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = stringResource(R.string.entre_para_continuar),
                color = LightGray
            )

            Spacer(modifier = Modifier.height(30.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = { email = it },
                    singleLine = true,
                    label = {
                        Text(text = "E-mail")
                    },
                    shape = RoundedCornerShape(20),
                    placeholder = { Text("seu@email.com") },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next,
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.MailOutline,
                            contentDescription = stringResource(R.string.icone_de_uma_carta)
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = DarkGray,
                        focusedContainerColor = DarkGray,
                        focusedLeadingIconColor = Gold,
                        focusedBorderColor = Gold,
                        unfocusedBorderColor = DarkGray,
                    )
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Senha") },
                    shape = RoundedCornerShape(20),
                    placeholder = { Text("******") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Lock,
                            contentDescription = stringResource(R.string.icone_de_um_cadeado)
                        )
                    },
                    visualTransformation = if (passwordHidden)
                        PasswordVisualTransformation() else VisualTransformation.None,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.NumberPassword,
                        imeAction = ImeAction.Done
                    ),
                    trailingIcon = {
                        IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            Icon(
                                imageVector = if (passwordHidden)
                                    Icons.Outlined.Visibility
                                else Icons.Outlined.VisibilityOff,
                                contentDescription = if (passwordHidden)
                                    stringResource(R.string.mostrar_senha)
                                else stringResource(R.string.esconder_senha)
                            )
                        }
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedContainerColor = DarkGray,
                        focusedContainerColor = DarkGray,
                        focusedLeadingIconColor = Gold,
                        focusedBorderColor = Gold,
                        focusedTrailingIconColor = Gold,
                        unfocusedBorderColor = DarkGray,
                    )
                )

                Spacer(modifier = Modifier.height(25.dp))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    GradientButton(
                        onClick = {},
                        text = stringResource(R.string.entrar)
                    )

                    GradientButton(
                        onClick = {},
                        text = stringResource(R.string.esqueceu_a_senha),
                        textColor = Gold,
                        color1 = Color(0xFF2A2A2A),
                        color2 = Color(0xFF3A3A3A)
                    )
                }

                Spacer(modifier = Modifier.height(25.dp))

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    HorizontalDivider(modifier = Modifier.padding(bottom = 20.dp))

                    Text(
                        text = stringResource(R.string.ainda_n_o_tem_uma_conta),
                        color = LightGray
                    )

                    TextButton(onClick = onNavigateToRegister) {
                        Text(
                            text = stringResource(R.string.cadastre_se_gratuitamente),
                            color = Gold,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}