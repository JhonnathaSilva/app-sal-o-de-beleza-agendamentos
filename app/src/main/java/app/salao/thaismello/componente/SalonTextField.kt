package app.salao.thaismello.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.salao.thaismello.ui.theme.DarkGray
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.LightGray
import app.salao.thaismello.ui.theme.MediumGray
import org.w3c.dom.Text

@Composable
fun SalonTextField(
    value: String,
    label: String,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    isError: String? = null,
    readOnly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
){
    SalonTextField(
        value = TextFieldValue(value, selection = TextRange(value.length)),
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        keyboardType = keyboardType,
        imeAction = imeAction,
        isError = isError,
        readOnly = readOnly,
        visualTransformation = visualTransformation,
    ) {
        onValueChange(it.text)
    }
}
//
@Composable
fun SalonTextField(
    value: TextFieldValue,
    label: String,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    isError: String? = null,
    readOnly: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (TextFieldValue) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

            OutlinedTextField(
                value = value,
                onValueChange = {
                    if (!readOnly) {
                        onValueChange(it)
                    }
                },
                label = { Text(text = label, color = LightGray) },
                placeholder = {
                    Text(
                        text = placeholder,
                        color = MediumGray
                    )
                },
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                isError = isError != null,
                supportingText = {
                    isError?.let { msg ->
                        Text(text = msg)
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
              modifier = Modifier
                .fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Gold,
                    unfocusedBorderColor = DarkGray,
                    errorBorderColor = Color(0xFFF44336),
                    focusedContainerColor = Color.Transparent.copy(alpha = 0.5f),
                    unfocusedContainerColor = Color.Transparent.copy(alpha = 0.5f),
                    errorContainerColor = DarkGray,
                    focusedLabelColor = Gold,
                    unfocusedLabelColor = LightGray,
                    cursorColor = Gold,
                    focusedLeadingIconColor = Gold,
                    unfocusedLeadingIconColor = LightGray,
                    focusedTrailingIconColor = Gold,
                    unfocusedTrailingIconColor = LightGray,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    errorTextColor = Color(0xFFF44336)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
                visualTransformation = visualTransformation,
                readOnly = readOnly
            )
        }


}

