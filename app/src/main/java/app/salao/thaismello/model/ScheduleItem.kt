package app.salao.thaismello.model

import java.sql.Date

data class ScheduleItem(
    val hairProcedure: String,
    val hairdresser: String,
    val date: String,
    val hours: String,
    val timeProcedure: String,
    val price: Double
)


