package app.salao.thaismello.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.sp
import app.salao.thaismello.ui.theme.ColorGoldLight
import app.salao.thaismello.ui.theme.DarkGray
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.NearBlack

@Composable
fun UserScreen() {
    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(colors = listOf(Gold, NearBlack, DarkGray)))
    ) { contentpadding ->
        Surface(
            color = Color.Transparent,
            modifier = Modifier
                .height(90.dp)
                .padding(contentpadding)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Gold, ColorGoldLight)
                    ),
                    shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                ),

        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text("Meus Agendamentos")
            }
        }
    }
}

@Preview
@Composable
private fun UserScreenPreview() {
    UserScreen()
}