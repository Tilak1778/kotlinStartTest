package tluck.raj.kotlinstarttest

import android.util.Log
import java.net.URL

class Request (val url:String ){

    fun Run(){

        val forecastJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, forecastJsonStr)
    }
}