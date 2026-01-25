package app.salao.thaismello.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.salao.thaismello.ui.theme.ColorGoldLight
import app.salao.thaismello.ui.theme.DarkGray
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.LightGray
import app.salao.thaismello.ui.theme.MediumGray
import app.salao.thaismello.ui.theme.NearBlack


@Composable
fun GradientButton(
    color1: Color = Gold,
    color2: Color = ColorGoldLight,
    text: String,
    textColor: Color = Color.Black,
    enabled: Boolean = true,
    loading: Boolean = false,
    onClick: () -> Unit,
) {
    val disabledColor1 = NearBlack
    val disabledColor2 = MediumGray

    val currentGradient = if (loading || !enabled) {
        listOf(disabledColor1, disabledColor2)
    } else {
        listOf(color1, color2)
    }

    Box(
        modifier = Modifier.wrapContentSize().background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            enabled = enabled && !loading,
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(currentGradient),
                    shape = RoundedCornerShape(20)
                ),
        ) {

            Text(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                text = if (loading) "" else text,
                color = textColor
            )
        }
        if (loading){
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = Gold
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun GradientButtonPreview() {
    GradientButton(
        text = "TODO()",
        enabled = false,
        loading = false,
        onClick = {}
    )

}

@Preview(showBackground = true)
@Composable
private fun GradientButtonPreviewLoading() {
    GradientButton(
        text = "TODO()",
        enabled = true,
        loading = true,
        onClick = {}
    )

}

//@Composable
//fun GradientButton(
//    modifier: Modifier = Modifier,
//    text: String,
//    color1: Color = Gold,
//    color2: Color = ColorGoldLight,
//    textColor: Color = Color.Black,
//    onClick: () -> Unit
//) {
//    val shape = RoundedCornerShape(20)
//
//    Surface(
//        onClick = onClick,
//        modifier = modifier
//            .fillMaxWidth()
//            .height(45.dp),
//        shape = shape,
//        shadowElevation = 6.dp,
//        color = Color.Transparent
//    ) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    brush = Brush.horizontalGradient(
//                        listOf(color1, color2)
//                    ),
//                    shape = shape
//                ),
//            contentAlignment = Alignment.Center
//        ) {
//            Row {
//                Text(
//                    text = text,
//                    color = textColor,
//                    fontWeight = FontWeight.Bold
//                )
//            }
//        }
//    }
//}


//@Preview
//@Composable
//private fun GradientButtonPreview() {
//    GradientButton(
//        onClick = {},
//        text = "Esqueceu a senha?",
//        color1 = LightGray,
//        color2 = NearBlack,
//        textColor = Gold
//    )
//}