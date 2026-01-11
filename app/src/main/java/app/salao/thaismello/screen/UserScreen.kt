package app.salao.thaismello.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.salao.thaismello.componente.UserSchedule
import app.salao.thaismello.model.ScheduleItem
import app.salao.thaismello.ui.theme.ColorGoldLight
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.NearBlack

val sampleSchedules = listOf(
    ScheduleItem(
        hairProcedure = "Corte e Escova Progressiva",
        hairdresser = "Com Thais Mello",
        date = "25/07/2024",
        hours = "14:30",
        timeProcedure = "Duração: 2h 30min",
        price = 250.0
    ),
    ScheduleItem(
        hairProcedure = "Corte e Escova Progressiva",
        hairdresser = "Com Thais Mello",
        date = "25/07/2024",
        hours = "14:30",
        timeProcedure = "Duração: 2h 30min",
        price = 250.0
    ),

    )

@Composable
fun UserScreen() {
    Scaffold(
        containerColor = Color.Transparent,
        modifier = Modifier
            .fillMaxSize()
           .background(Color.DarkGray)
            //.background(brush = Brush.verticalGradient(colors = listOf(Gold, NearBlack, DarkGray,LightGray)))
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            Surface(
                color = Color.Transparent,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 25.dp)
                    .height(99.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Gold, ColorGoldLight)
                        ),
                        shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text(
                        modifier = Modifier.padding(start = 15.dp, top = 23.dp),
                        text = "Meus Agendamentos",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = NearBlack
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        modifier = Modifier.padding(start = 15.dp),
                        text = "Gerencie seus horários",
                        style = TextStyle(
                            fontWeight = FontWeight.Medium,
                            fontSize = 13.sp,
                            color = Color.Black.copy(alpha = 0.5f)
                        )
                    )

                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                UserSchedule(sampleSchedules)
            }
        }
    }
}



@Preview(showSystemUi = true)
@Composable
private fun UserScreenPreview() {
    UserScreen()
}