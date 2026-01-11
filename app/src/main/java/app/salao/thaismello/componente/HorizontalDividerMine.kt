package app.salao.thaismello.componente

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun HorizontalDividerMine() {
        HorizontalDivider(
            thickness = 0.1.dp,
            color = Color.Transparent
        )
}

@Preview(showBackground = true)
@Composable
private fun HorizontalDividerPreview() {
    HorizontalDividerMine()
}