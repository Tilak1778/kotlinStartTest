package tluck.raj.kotlinstarttest

import com.google.gson.Gson
import java.net.URL

class ForecastRequest (val url:String){



    fun execute():ForecastResult{


        val forecastJsonStr= URL(url).readText()

        //val g:Gson= Gson()

        return Gson().fromJson(forecastJsonStr,ForecastResult::class.java)

    }

}