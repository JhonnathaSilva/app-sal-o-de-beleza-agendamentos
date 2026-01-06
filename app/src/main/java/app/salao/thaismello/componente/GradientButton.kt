package app.salao.thaismello.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.salao.thaismello.ui.theme.ColorGoldLight
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.LightGray
import app.salao.thaismello.ui.theme.NearBlack

@Composable
fun GradientButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    color1: Color = Gold,
    color2: Color = ColorGoldLight,
    textColor: Color = Color.Black

) {
    val shape = RoundedCornerShape(20)

    Surface(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(45.dp),
        shape = shape,
        shadowElevation = 6.dp,
        color = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(color1, color2)
                    ),
                    shape = shape
                ),
            contentAlignment = Alignment.Center
        ) {
            Row {
                Text(
                    text = text,
                    color = textColor,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview
@Composable
private fun GradientButtonPreview() {
    GradientButton(onClick = {}, text = "Esqueceu a senha?", color1 = LightGray, color2 = NearBlack, textColor = Gold)
}