package tluck.raj.kotlinstarttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import tluck.raj.kotlinstarttest.domain.Forecast

class MainActivity : AppCompatActivity() {


    private val items = listOf(
        "Mon 6/23 - Sunny - 31/17",
        "Tue 6/24 - Foggy - 21/8",
        "Wed 6/25 - Cloudy - 22/17",
        "Thurs 6/26 - Rainy - 18/11",
        "Fri 6/27 - Foggy - 21/10",
        "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
        "Sun 6/29 - Sunny - 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val forecastList=findViewById<RecyclerView>(R.id.forecastList)
       forecastList.layoutManager = LinearLayoutManager(this)

        //val result = RequestForecastCommand("94043").execute()

        //forecastList.adapter=forecastListAdaptor(result)


        val url="https://samples.openweathermap.org/data/2.5/forecast/" +
                "daily?lat=35&lon=139&cnt=10&appid=b1b15e88fa797225412429c1c50c122a1"


        doAsync{
            val res = RequestForecastCommand(url).execute()
            //val result="tilakrak"
            uiThread {
               forecastList.adapter = forecastListAdaptor(res){forecast -> toast(forecast.date) }
               // toast(result)
            }
        }

    }
}
