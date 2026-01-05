package app.salao.thaismello.Componentes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.salao.thaismello.ui.theme.Gold


@Composable
fun PhotoIcon(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.size(120.dp),
        shape = CircleShape,
        color = Color.Black,
        border = BorderStroke(1.dp, Gold),
        tonalElevation = 2.dp
    ) {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center),
            text = "TM",
            color = Gold,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 40.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun PhotoIconPreview() {
    PhotoIcon()
}