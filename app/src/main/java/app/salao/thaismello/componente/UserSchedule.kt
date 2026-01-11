package app.salao.thaismello.componente

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.salao.thaismello.R
import app.salao.thaismello.model.ScheduleItem
import app.salao.thaismello.ui.theme.Gold
import app.salao.thaismello.ui.theme.LightGray
import app.salao.thaismello.ui.theme.NearBlack

val sampleSchedules = listOf(
    ScheduleItem(
        hairProcedure = "Corte e Escova Progressiva",
        hairdresser = "Com Thais Mello",
        date = "25/07/2024",
        hours = "14:30",
        timeProcedure = "Duração: 2h 30min",
        price = 250.0
    )
//    ScheduleItem(
//        hairProcedure = "Manicure e Pedicure",
//        hairdresser = "Com Ana Clara",
//        date = "28/07/2024",
//        hours = "10:00",
//        timeProcedure = "Duração: 1h 30min",
//        price = 80.0
//    ),
//    ScheduleItem(
//        hairProcedure = "Design de Sobrancelha com Henna",
//        hairdresser = "Com Julia Ferraz",
//        date = "02/08/2024",
//        hours = "16:00",
//        timeProcedure = "Duração: 45min",
//        price = 60.0
//    ),
//    ScheduleItem(
//        hairProcedure = "Maquiagem para Evento",
//        hairdresser = "Com Thais Mello",
//        date = "10/08/2024",
//        hours = "19:00",
//        timeProcedure = "Duração: 1h 15min",
//        price = 180.0
//    ),
//    ScheduleItem(
//        hairProcedure = "Maquiagem para Evento",
//        hairdresser = "Com Thais Mello",
//        date = "10/08/2024",
//        hours = "19:00",
//        timeProcedure = "Duração: 1h 15min",
//        price = 180.0
//    ),
//    ScheduleItem(
//        hairProcedure = "Maquiagem para Evento",
//        hairdresser = "Com Thais Mello",
//        date = "10/08/2024",
//        hours = "19:00",
//        timeProcedure = "Duração: 1h 15min",
//        price = 180.0
//    )
)

@Composable
fun UserSchedule(
    scheduleItems: List<ScheduleItem> = emptyList()
) {
    Surface(
        color = Color.Transparent,
        modifier = Modifier.fillMaxSize()
    ) {
        if (scheduleItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Nenhum agendamento encontrado",
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                items(scheduleItems) { schedule ->
                    UserScheduleItem(details = schedule)
                }
            }
        }
    }
}

@Composable
fun UserScheduleItem(
    details: ScheduleItem
) {
    Column(
        modifier = Modifier.padding(start = 20.dp, end = 20.dp),
    ) {
        ElevatedCard(
            modifier = Modifier
                //.width(290.dp)
                .fillMaxWidth()
                .height(200.dp),
            colors = CardDefaults.elevatedCardColors(
                containerColor = NearBlack.copy(alpha = 0.8f)
            ),
            elevation = CardDefaults.elevatedCardElevation(
                defaultElevation = 15.dp,
                pressedElevation = 2.dp,
                focusedElevation = 10.dp
            ),

        ) {
            Column(
            ) {
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    text = details.hairProcedure,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    text = details.hairdresser,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        color = Gold,
                        fontSize = 9.sp
                    )
                )
                Row(
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(3.dp)

                ) {
                    Icon(
                        modifier = Modifier.size(9.dp),
                        imageVector = Icons.Outlined.CalendarToday,
                        tint = LightGray,
                        contentDescription = stringResource(R.string.icone_de_um_calendario)
                    )
                    Text(
                        modifier = Modifier.padding(end = 4.dp),
                        text = details.date.toString(),
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 9.sp
                        )
                    )
                    Icon(
                        modifier = Modifier.size(9.dp),
                        imageVector = Icons.Outlined.AccessTime,
                        tint = LightGray,
                        contentDescription = stringResource(R.string.icone_de_um_relogio)
                    )
                    Text(
                        text = details.hours,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 9.sp
                        )
                    )
                }
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
//                    color = Color.Red
                    thickness = 0.1.dp,
                )
                Column() {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = details.timeProcedure,
                            style = TextStyle(
                                color = LightGray,
                                fontSize = 9.sp
                            )
                        )
                        Text(
                            text = "R$" + details.price.toString(),
                            style = TextStyle(
                                color = Color.White,
                                fontSize = 9.sp
                            )
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, top = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(
                            onClick = {},
                            modifier = Modifier
                                .wrapContentHeight()
                                .width(120.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = NearBlack.copy(alpha = 0.5f)
                            ),

                            shape = RoundedCornerShape(20),
                            //contentPadding = PaddingValues(10.dp)

                        ) {
                            Text(
                                text = "Reagendar",
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                        OutlinedButton(
                            onClick = {},
                            modifier = Modifier
                                .wrapContentHeight()
                                .width(120.dp),
                            colors = ButtonDefaults.outlinedButtonColors(
                                containerColor = Color.Red.copy(alpha = 0.5f)
                            ),

                            shape = RoundedCornerShape(20),
                            //contentPadding = PaddingValues(10.dp)

                        ) {
                            Text(
                                text = "Cancelar",
                                style = TextStyle(
                                    color = Color.White,
                                    fontSize = 9.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }
                    }
                }

            }
        }
    }


}


@Preview(showBackground = true, backgroundColor = 0xFF1C1C1E) // Fundo escuro para o preview
@Composable
private fun UserSchedulePreview(
) {
    // Passamos a lista de exemplos para a função
    UserSchedule(scheduleItems = sampleSchedules)
}

@Preview(showBackground = true, backgroundColor = 0xFF1C1C1E)
@Composable
private fun UserScheduleItemPreview() {
    // Passamos o primeiro item da lista de exemplos para o preview do item
    UserScheduleItem(details = sampleSchedules.first())
}