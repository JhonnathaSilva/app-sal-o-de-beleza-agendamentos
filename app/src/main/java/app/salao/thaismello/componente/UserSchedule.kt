package app.salao.thaismello.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.salao.thaismello.model.ScheduleItem
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.LightGray
import app.salao.thaismello.ui.theme.NearBlack

@Composable
fun UserSchedule(
//    onClick: (ScheduleItem) -> Unit
) {
    Surface(
        modifier = Modifier
            .wrapContentSize(),
        color = Color.Transparent
    ) {
        LazyVerticalGrid(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            columns = GridCells.Fixed(1)) {
            items(5) {
                UserScheduleItem()
            }
        }
    }


}

@Composable
fun UserScheduleItem(
//    details: ScheduleItem
) {
    Column {
        ElevatedCard(
            modifier = Modifier.wrapContentSize(),
            colors = CardDefaults.elevatedCardColors(
                containerColor = LightGray
            )
        ) {
            Column(
            ) {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    text = "Corte e Escova",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    text = "Com Thais",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Gold,
                        fontSize = 11.sp
                    )
                )
            }
        }
    }
    

}


@Preview(showBackground = true)
@Composable
private fun UserSchedulePreview() {
    UserSchedule()
}

@Preview
@Composable
private fun UserScheduleItemPreview() {
    UserScheduleItem()
}