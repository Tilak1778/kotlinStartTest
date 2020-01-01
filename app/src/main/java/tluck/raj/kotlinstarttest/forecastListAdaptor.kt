package tluck.raj.kotlinstarttest

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import tluck.raj.kotlinstarttest.ctx


import tluck.raj.kotlinstarttest.domain.Forecast
import tluck.raj.kotlinstarttest.domain.ForecastList

class forecastListAdaptor(private val weekForecast: ForecastList,val itemClick:(Forecast)->Unit)
    : RecyclerView.Adapter<forecastListAdaptor.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):ViewHolder {

        val view=LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast,parent,false)

        return ViewHolder(view,itemClick)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindForecast(weekForecast.dailyForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    class ViewHolder(val view:View, val itemClick:(Forecast)->Unit) : RecyclerView.ViewHolder(view){



        private val iconView=view.find<ImageView>(R.id.icon)
        private val dateView = view.find<TextView>(R.id.date)
        private val descriptionView =view.find<TextView>(R.id.description)
        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)


        fun bindForecast(forecast: Forecast){

            with(forecast){
                Picasso.get().load(iconUrl).into(iconView)

               // Glide.with(itemView.ctx).load(iconUrl).into(iconView)

                dateView.text=date
                descriptionView.text=description
                maxTemperatureView.text="$high"
                minTemperatureView.text="$low"

                itemView.setOnClickListener(){

                    itemClick(this)
                }

            }
        }
    }


    interface OnItemClickListner{
        operator fun invoke(forecast:Forecast)
    }
}
