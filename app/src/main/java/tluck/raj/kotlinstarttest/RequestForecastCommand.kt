package tluck.raj.kotlinstarttest

import android.widget.Toast
import tluck.raj.kotlinstarttest.domain.ForecastDataMapper
import tluck.raj.kotlinstarttest.domain.ForecastList
import org.jetbrains.anko.toast

class RequestForecastCommand(val url: String) :
    Command<ForecastList> {

    override fun execute(): ForecastList {
       // val toast=Toast.makeText(this,"execute",Toast.LENGTH_LONG).show()

        val forecastRequest = ForecastRequest(url)
        return ForecastDataMapper().convertFromDataModel(
            forecastRequest.execute())
    }
}